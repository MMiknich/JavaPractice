import sun.net.www.content.text.Generic;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args)
    {
        MyQueue<Integer> A = new MyQueue<>();
        int B[] = {1, 2, 3, 4,6 ,6 ,6 , 7};
        for (int i = 0; i<=7; i++)
        {
            A.add(B[i], true);
        }
        for (int i = 0; i<=8; i++)
        {
            try {
                System.out.println(A.poll(false));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
