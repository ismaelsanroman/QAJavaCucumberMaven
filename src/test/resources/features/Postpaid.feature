@tag
Feature: Test product functionality: X

	We test the functionality of the project for the product X

 	@tag1
 	Scenario: Title of your scenario
		Given prepare the environment
    
# ------------------------------

# <--- OrderE2E --->
	@OrderE2E
	Scenario: Alvatross Order-E2E
	    Given We access a completed OM order with the Commercial order: <"25393">
	    When The order has status <"Completed">
	    When Item of type <items> have status <"completed"> in OM
      |TelenorIPTVRFS|
      |TelenorIPTVCFS|
      
      When The services have <"active"> status in IF
	    Then End the test and close the test battery
