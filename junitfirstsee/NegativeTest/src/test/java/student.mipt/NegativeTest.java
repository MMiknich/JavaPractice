package student.mipt;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class NegativeTest {

    @Test(expected = java.lang.Exception.class)
    public void exeptionCheck() throws Exception
    {
        //throw new Exception("Dick");
        IsPrime isPrime = new IsPrime(-1);
        assertNull("ExeptionCheck with 1 have error", isPrime.get());
    }

    @Test
    public void expectingKK() throws Exception
    {
        IsPrime isPrime = new IsPrime(23);
        assertThat(isPrime.get(), allOf(containsInteger(2)).and(containsInteger(23)));
    }
}
