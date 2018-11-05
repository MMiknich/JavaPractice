package student.mipt;

import org.junit.Test;
import student.mipt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class PositiveTest {


    @Test
    public void primeCheckFor16()
    {
        try {
            IsPrime isPrime = new IsPrime(16);
            Integer[] expected = {2, 3, 5, 7, 11, 13};
            ArrayList<Integer> arrlist = isPrime.get();
            Integer[] array = new Integer[arrlist.size()];
            array = arrlist.toArray(array);
            assertArrayEquals("для 16 они не равны\n", expected, array);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return;
        }
    }
    @Test
    public void primeCheckFor12()
    {
        try {
            IsPrime isPrime = new IsPrime(12);
            Integer[] expected = {2, 3, 5, 7, 11};
            ArrayList<Integer> arrlist = isPrime.get();
            Integer[] array = new Integer[arrlist.size()];
            array = arrlist.toArray(array);
            assertArrayEquals("для 12 они не равны\n", expected, array);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return;
        }
    }
}
