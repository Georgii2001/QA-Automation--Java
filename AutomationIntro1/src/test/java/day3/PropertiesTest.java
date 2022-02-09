package day3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PropertiesTest extends BaseTest {
    @Test
    public void firstTest(){
        assertEquals("https://www.google.com/?gws_rd=ssl",driver.getCurrentUrl());
    }
}
