package student;

import jdk.internal.util.xml.impl.Pair;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PipedOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Stack;

import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;


public class Encriptor implements Runnable {
    private boolean SETTING_OFF_BUFFER = false;//false для работы с POS, true для работы с массивом строк
    private byte[] privateKey;
    private byte[] publicKey;
    private String fileName;
    private PipedOutputStream pipedOutputStream;
    private String separator;
    private byte[][][] workingBuffer; // никто не отвечал за сохранение последовательности
    private final String endOfStream = "StreamEnd";

    /**
     * @deprecated  reason this method is deprecated </br>
     *              {It just dosent work} </br>
     *              use {@link String[][2] instead of PipedOutputStream}
     *
     */
    @Deprecated
    Encriptor(KeyPair keyPair, String fileName,String separator,PipedOutputStream pipedOutputStream)
    {
        this.privateKey= keyPair.getPrivate().getEncoded();
        this.publicKey= keyPair.getPublic().getEncoded();
        this.fileName = fileName;
        this.separator = separator;
        this.pipedOutputStream = pipedOutputStream;
        this.SETTING_OFF_BUFFER = false;
    }

    Encriptor(KeyPair keyPair, String fileName,String separator,byte[][][] workingBuffer)
    {
        this.privateKey= keyPair.getPrivate().getEncoded();
        this.publicKey= keyPair.getPublic().getEncoded();
        this.fileName = fileName;
        this.separator = separator;
        this.workingBuffer = workingBuffer;
        this.SETTING_OFF_BUFFER = true;
    }
    // RSA encoder itself
    synchronized public static byte[] encryptRSA(byte[] publicKey, byte[] inputData)
            throws Exception {
        PublicKey key = KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(publicKey));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(inputData);
        return encryptedBytes;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String readerLine = " ";
            int laneCounter = 0;
            try {
                while (true) {

                    readerLine = bufferedReader.readLine();
                    String[] itsAdressAndPassword = readerLine.split(separator);

                    //Encoding our data
                    byte[] encodedMail = Base64.getEncoder()
                            .encode(itsAdressAndPassword[0].getBytes());
                    byte[] encriptedPassword = encryptRSA(publicKey, itsAdressAndPassword[1].getBytes());

                    // --this is code, that using byte array
                    if(SETTING_OFF_BUFFER)
                    {
                        synchronized (workingBuffer) {
                            for (int ib = 0; ib < encodedMail.length; ib++) {
                                workingBuffer[laneCounter][0][ib] = encodedMail[ib];
                                System.out.println(encodedMail.length);
                            }
                            for (int ib = 0; ib < encriptedPassword.length; ib++) {
                                workingBuffer[laneCounter][1][ib] = encriptedPassword[ib];
                                //System.out.println(encriptedPassword.length);
                            }
                            laneCounter++;
                        }
                    }

                    // --this code use pis-es and pos-es
                    else {
                        pipedOutputStream.write((encodedMail + " " + encriptedPassword + " ").getBytes());
                    }
                }
            }
            catch (Exception e) {
                //e.printStackTrace();
                byte[] eos = endOfStream.getBytes();
                for (int ib = 0; ib < eos.length; ib++) {
                    workingBuffer[laneCounter][0][ib] = eos[ib];
                    workingBuffer[laneCounter][1][ib] = eos[ib];
                }
                return;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
