package student.mipt;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.sqrt;


public class App {

    public static void main(String[] args) {
        System.out.print("Введите число: ");
        try {
            IsPrime myIsPrime = new IsPrime(new Scanner(System.in).nextInt());

            System.out.println("Простые числа: ");
            for (Integer A : myIsPrime.get()) {
                System.out.print(A);
                System.out.print(" ");
            }
        }catch (Exception e)
            {
                e.printStackTrace();
                return;
            }
    }
}

class IsPrime {
    private int limit; //верхняя граница

    IsPrime(int limit) throws Exception
    {
        if (limit <= 1) {
                Exception ex = new Exception("Hui");
                throw ex;
        }
        this.limit=limit;
    }
    private static boolean primeCheck(int num) {
        boolean flag = true;
        double sqrlim = sqrt((double)num);
        for (int j = 2; j <= sqrlim; j++) {
            if (num % j == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public  ArrayList<Integer> get() {
        if (limit <= 1)
            return null;
        ArrayList<Integer> outputList = new ArrayList();
        for (int i=2;i<=limit;i++)
        {
            if(primeCheck(i))
                outputList.add(i);
        }
        //IntStream intStream = IntStream.iterate(1,n->n+1).range(1,limit);
        return outputList;
    }
}