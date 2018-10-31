package student;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PipedOutputStream;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;


public class Encriptor implements Runnable {

    private PrivateKey privateKey;
    private PublicKey publicKey;
    private String fileName;
    private PipedOutputStream pipedOutputStream;
    private String separator;

    Encriptor(KeyPair keyPair, String fileName,String separator,PipedOutputStream pipedOutputStream)
    {
        this.privateKey= keyPair.getPrivate();
        this.publicKey= keyPair.getPublic();
        this.fileName = fileName;
        this.separator = separator;
        this.pipedOutputStream = pipedOutputStream;
    }
    // RSA encoder itself
    synchronized public static byte[] encryptRSA(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(message.getBytes());
    }
    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String readerLine = " ";
            try {
                while (true) {
                    readerLine = bufferedReader.readLine();
                    System.out.print("here we are\n");
                    String[] itsAdressAndPassword = readerLine.split(separator);
                    //Encoding our data
                    String encodedMail = new String(Base64.getEncoder()
                            .encode(itsAdressAndPassword[0].getBytes()));
                    String encriptedPassword = new String(encryptRSA(privateKey, itsAdressAndPassword[1]));
                    String newSrt = new String(encodedMail  +"--@--"+ encriptedPassword+"@@-@@");
                    System.out.print(newSrt.getBytes()+"\n");
                    pipedOutputStream.flush();
                    pipedOutputStream.write(newSrt.getBytes());
                    System.out.print("Why!\n");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                pipedOutputStream.close();
                return;
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
