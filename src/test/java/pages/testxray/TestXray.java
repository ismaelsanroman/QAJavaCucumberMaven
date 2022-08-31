package pages.testxray;

import pages.FunctionsPage;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestXray extends FunctionsPage {

    public TestXray() {
        super(driver);
    }

    public void test1Xray() {
    	System.out.println(" --- Test 1 Xray --- ");
    	System.out.println(" - Test 1 completed");
    }
    
    public void test2Xray() {
    	System.out.println(" --- Test 2 Xray --- ");
    	System.out.println(" - Test 2 completed");
    }
    
    public void test3Xray() {
    	System.out.println(" --- Test 3 Xray --- ");
    	Assert.assertEquals("Error in the test number 3 contemplated", 5, 3);
    	System.out.println(" - Test 3 completed");
    }
    
    public void test4Xray() {
    	System.out.println(" --- Test 4 Xray --- ");
    	System.out.println(" - Test 4 completed");
    }
    
    public void test5Xray() {
    	System.out.println(" --- Test 5 Xray --- ");
    	Assert.assertEquals("Error in the test number 5 contemplated", 7, 5);
    	System.out.println(" - Test 5 completed");
    }
    
    public void test6Xray() {
    	System.out.println(" --- Test 6 Xray --- ");
    	System.out.println(" - Test 6 completed");
    }
    
    public void test7Xray() {
    	System.out.println(" --- Test 7 Xray --- ");
    	Assert.assertEquals("Error in the test number 7 contemplated", 9, 7);
    	System.out.println(" - Test 7 completed");
    }
    
    public void test8Xray() {
    	System.out.println(" --- Test 8 Xray --- ");
    	System.out.println(" - Test 8 completed");
    }
    
    public void test9Xray() {
    	System.out.println(" --- Test 9 Xray --- ");
    	System.out.println(" - Test 9 completed");
    }
    
    public void test10Xray() {
    	System.out.println(" --- Test 10 Xray --- ");
    	Assert.assertEquals("Skipped in the test number 10 contemplated", 9, 9);
    	System.out.println(" - Test 10 completed");
    }
}