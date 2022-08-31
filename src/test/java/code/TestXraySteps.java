package code;

import io.cucumber.java.en.*;

import pages.testxray.TestXray;

public class TestXraySteps {
	TestXray testXray = new TestXray();
	
    @Given("^i want to write a step with precondition one$")
    public void Test1Xray() {
        testXray.test1Xray();
    }
    
    @Given("^i want to write a step with precondition two$")
    public void Test2Xray() {
        testXray.test2Xray();
    }
    
    @Given("^i want to write a step with precondition three$")
    public void Test3Xray() {
        testXray.test3Xray();
    }
    
    @Given("^i want to write a step with precondition four$")
    public void Test4Xray() {
        testXray.test4Xray();
    }
    
    @Given("^i want to write a step with precondition five$")
    public void Test5Xray() {
        testXray.test5Xray();
    }
    
    @Given("^i want to write a step with precondition six$")
    public void Test6Xray() {
        testXray.test6Xray();
    }
    
    @Given("^i want to write a step with precondition seven$")
    public void Test7Xray() {
        testXray.test7Xray();
    }
    
    @Given("^i want to write a step with precondition eight$")
    public void Test8Xray() {
        testXray.test8Xray();
    }
    
    @Given("^i want to write a step with precondition nine$")
    public void Test9Xray() {
        testXray.test9Xray();
    }
    
    @Given("^i want to write a step with precondition ten$")
    public void Test10Xray() {
        testXray.test10Xray();
    }
}