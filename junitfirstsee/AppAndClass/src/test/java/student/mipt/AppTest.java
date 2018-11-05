package student.mipt;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
//@RunWith(Suite.class)
//@Suite.SuiteClasses({PositiveTest.class,NegativeTest.class})
public class AppTest 
{

    //private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    //private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
      //  System.setOut(new PrintStream(outContent));
       // System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
       // System.setOut(null);
       // System.setErr(null);
    }
}
