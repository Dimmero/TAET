package tests;

import BaseTest.BaseAbstractChromeTest;
import BaseTest.BaseAbstractTest;
import org.testng.annotations.Test;


public class Test1 extends BaseAbstractChromeTest {

    public Test1(String browser) {
        super("chrome");
    }

    @Test
    public void test() {
        int a = 5+6;
    }
}
