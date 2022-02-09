package day1;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class JunitAssertions {
    @Test
    public void whenAssertingConditions_themVerified() {
        System.out.println("Running 'AssertTrue'");
        Assert.assertTrue("5>2", 5>2);
    }
    @Test
    public void whenAssertingEquality_thenEquals() {
        System.out.println("Running 'AssertEquals'");
        int square= 2*2;
        int rectangle= 2+2;
        Assert.assertEquals("egale", square, rectangle);
    }
    @Test
    public void whenAssertingEquality_thenNotEquals() {
        System.out.println("Running 'AssertNotEquals'");
        int value= 5;
        Assert.assertNotEquals(1,value);
    }
    @Test
    public void whenAssertingNotNull_thenTrue() {
        System.out.println("Running 'AssertNotNull'");
        Object dog= new Object();
        Assert.assertNotNull("Dog should not be null", dog);
    }
    @Test
    public void whenAssertingEquality_thenEqual() {
        System.out.println("Running 'AssertArrayEquals'");
        char[] expected =new char[] {'E','n','d','a','v','a'};
        char[] actual ="Endava".toCharArray();
        Assert.assertArrayEquals("be egal", expected, actual);
    }
    @Ignore
    public void whenFailingTest_thenFailed() {
        System.out.println("Running 'AssertFail'");
        Assert.fail("This is not completed!");
    }


}
