package code;

import org.junit.*;
import org.junit.jupiter.api.AfterAll;
// import logs.Log;
import io.cucumber.java.en.*;
import pages.ordere2e.OrderE2E;

public class OrderE2ESteps {
	OrderE2E orderE2E = new OrderE2E();
	
	@Before
    @Given("We access a completed OM order with the Commercial order: <{string}>")
    public void navigateOrder(String comerOrder) {
        // Log.info("We access a completed OM order");
        orderE2E.navigateOrder(comerOrder);
    }
	
	@Test
    @When("The order has status <{string}>")
    public void statusService(String orderStatus) {
    	// Log.info("The order has status " + orderStatus);
        orderE2E.statusService(orderStatus);
    }
    
	@Test
	@When("Item of type <items> have status <{string}> in OM")
    public void itemsCompleted(String orderStatus, io.cucumber.datatable.DataTable dataTable) {
        orderE2E.itemsCompleted(dataTable, orderStatus);
    }
	
	@Test
    @When("The services have <{string}> status in IF")
    public void servicesSI(String serviceStatus) {
		// Log.info("The services have " + serviceStatu + " status in IF");
        orderE2E.servicesSI(serviceStatus);
    }
    
	@AfterAll
    @Then("^End the test and close the test battery$")
    public void endTest() {
		// Log.info(" --- END TEST --- ");;
        orderE2E.endTest();
    }
}
