package student;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        String fileName = "src/main/java/mipt/student/temp.cvs";
        KeyPair keyPair = KeyPairGenerator.getInstance("RSA").genKeyPair();

        //потоки для общения с потоками)
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStreams = new PipedOutputStream(pipedInputStream);


        //создаем поток который зашифрует наши адреса и пароли
        Encriptor encriptor = new Encriptor(keyPair,fileName,"\\|",pipedOutputStreams);
        System.out.print("here we are\n");
        Thread myTread = new Thread(new Runnable(){
            @Override
            synchronized public void run() {


            }
        });
        myTread.run();
        encriptor.run();




        /*/ Decode data on other side, by processing encoded data
        byte[] valueDecoded = Base64.getDecoder().decode(bytesEncoded);
        System.out.println("Decoded value is " + new String(valueDecoded));*/

    }
}
