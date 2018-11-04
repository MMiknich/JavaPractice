package student;

import javax.crypto.Cipher;
import java.io.*;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Decriptor implements Runnable {
    private boolean SETTING_OFF_BUFFER = false;//false для работы с POS, true для работы с массивом строк
    private byte[] pivateKey;
    private PipedInputStream pipedInputStream;
    private String separator;
    private byte[][][] workingBuffer;
    private final String fileName = "output.cvs";
    private final String endOfStream = "StreamEnd";

    /**
     * @deprecated  reason this method is deprecated </br>
     *              {It just dosent work} </br>
     *              use {@link String[][2] instead of PipedInputStream}
     *
     */
    @Deprecated
    public Decriptor(KeyPair publicKey,String separator, PipedInputStream pipedInputStream)
    {
        this.pipedInputStream = pipedInputStream;
        this.pivateKey = publicKey.getPrivate().getEncoded();
        this.separator = separator;
        this.SETTING_OFF_BUFFER = false;
    }
    public  Decriptor(KeyPair publicKey, String separator, byte[][][] workingBuffer)
    {
        this.pivateKey = publicKey.getPrivate().getEncoded();
        this.separator = separator;
        this.workingBuffer = workingBuffer;
        this.SETTING_OFF_BUFFER = true;
    }

    private static String decrypt(PrivateKey publicKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(cipher.doFinal(encrypted));
    }

    public static byte[] decryptRSA(byte[] privateKey, byte[] inputData)
            throws Exception {

        PrivateKey key = KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(privateKey));

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);

        return cipher.doFinal(inputData);
    }

    @Override
    public void run() {
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
                int strCounter = 0;
                boolean nullFlag = true;
                byte[] encriptedMail = new byte[16];
                byte[] encriptedPassword = new byte[128];
                while (true) {
                    synchronized (workingBuffer) {
                        boolean newFlag = false;
                        for(int i=0; i<10; i++) {
                            if(workingBuffer[0][0][i] == 0)
                                newFlag = true;
                        }
                        if (!newFlag) {
                            encriptedMail = workingBuffer[strCounter][0];
                            encriptedPassword = workingBuffer[strCounter][1];
                            strCounter++;
                            nullFlag = true;
                        }
                        else
                            nullFlag = false;
                    }
                    if (nullFlag) {
                        if (encriptedMail.equals(endOfStream.getBytes())) {
                            return;
                        }
                        String oMail = new String(Base64.getDecoder()
                                .decode(encriptedMail));
                        String oPassword = new String(decryptRSA(pivateKey, encriptedPassword));
                        System.out.println(oMail + separator + oPassword + '\n');
                        //bufferedWriter.write();
                    }
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
                return;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
        // This is a secret message
}
