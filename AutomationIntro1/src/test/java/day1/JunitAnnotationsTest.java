package day1;

import org.junit.*;

public class JunitAnnotationsTest {
    @Test
    public void test1() {
        System.out.println("I'm test1");
    }

    @Ignore
    public void test2(){
        System.out.println("I'm test2");
    }

    @Before
    public void beforeMethode() {
        System.out.println("I'm before methode");
    }
    @After
    public void afterMethode() {
        System.out.println("I'm after methode");
    }
    @BeforeClass
    public static void beforeClassMethode() {
        System.out.println("I'm beforeClass methode");
    }
    @AfterClass
    public static void afterClassMethode() {
        System.out.println("I'm afterClass methode");
    }

}
