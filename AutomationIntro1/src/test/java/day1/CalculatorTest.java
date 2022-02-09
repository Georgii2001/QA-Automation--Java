package day1;

import org.junit.*;
import com.endava.day1.BasicCalculator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculatorTest {
    BasicCalculator calculator;

    @BeforeClass
    public static void beforeTests()
    {
        System.out.println("START!");
    }

    @Before
    public void startTests()
    {
        System.out.println("Run test");
        calculator=new BasicCalculator();
    }

    @After
    public void StopTests()
    {
        System.out.println("Finish test");
    }

    @AfterClass
    public static void AfterTests()
    {
        System.out.println("STOP!");
    }

    @Test
    public void testadd()
    {
        System.out.println("Running test add");
        int result= calculator.add(3, 4 ,5 );
        assertEquals(12, result);
    }

    @Test
    public void testmultiply()
    {
        System.out.println("Running test multiply");
        int result= calculator.multiply(3, 4 ,2 );
        assertEquals(24, result);
    }

    @Test
    public void testSubtract()
    {
        System.out.println("Running test Subtract");
        int result= calculator.subtract(15, 2 ,5 );
        assertEquals(8, result);
    }

    @Test
    public void testDivide()
    {
        System.out.println("Running test Divide");
        int result= calculator.divide(81, 9, 3);
        assertEquals(3, result);
    }

    @Test
    public void testpow()
    {
        System.out.println("Running test pow");
        int result= calculator.pow(3, 2 );
        assertEquals(9, result);
    }

    @Test (expected= IllegalArgumentException.class)
    public void testpowException()
    {
        System.out.println("Running test powException");
        int result= calculator.pow(3, -2 );
        assertNotNull(result);
    }
}
