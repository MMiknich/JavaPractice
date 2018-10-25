import sun.net.www.content.text.Generic;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args)
    {
        MyQueue<Integer> A = new MyQueue<>();
        int B[] = {1, 2};

        for (int aB : B) {
            A.add(aB, false);
        }

        for (int i = 0; i < B.length; i++)

        {
            try {
                System.out.println(A.poll(true));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
