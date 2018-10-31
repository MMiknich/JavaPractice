package student;

import javax.crypto.Cipher;
import java.io.IOException;
import java.io.PipedInputStream;
import java.security.PublicKey;

public class Decriptor implements Runnable {
    private PublicKey publicKey;
    private PipedInputStream pipedInputStream;
    private String separator;

    private static byte[] decrypt(PublicKey publicKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(encrypted);
    }

    @Override
    public void run() {
        try {
            String str = "a";
            byte[] verified = decrypt(publicKey, str.getBytes());
            System.out.println(new String(verified));
            int inpChar = pipedInputStream.read();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

        // This is a secret message
}
