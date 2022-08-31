package pages.ordere2e;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FunctionsPage;

public class OrderE2E extends FunctionsPage {
	

	public OrderE2E() {
        super(driver);
    }

    public void navigateOrder(String comerOrder){

	   	navigateTo("https://order-management-frontend.lab36.int.satec.es"); // Accedemos a la siguiente URL
	    	
	   	specialClick("//p[contains(text(),'Product orders')]"); // Seleccionamos Product Orders
	   	
	    // Enviamos el número de pedido
	    sendTo("//body/app-root[1]/app-layout[1]/div[2]/div[1]/div[1]/app-filters-container[1]/aside[1]/app-filters-product-orders[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]", comerOrder); 
	   
	    	
	    clickDesp("navbarDropdownStatus", "COMPLETED"); // Seleccionamos pedidos Completados
	    	
	    new WebDriverWait(driver, Duration.ofSeconds(5))
	    	.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tbody")));
	    	
	    specialClick("//span[contains(text(),'Search')]"); // Pulsamos sobre buscar
	    
	    specialClick("//tbody/tr[1]"); //Buscamos y clicamos en el Body
	    
    }
	
    public void statusService(String orderStatus) {
    	System.out.println(" -- Start of operation");
    	String orderStatusMayus = orderStatus.toUpperCase(); //Modificamos variable de cucumber a mayusculas.
    	String getStatus="";
    	int sleep=15000;
    	try {
    		for (int i=0;i<sleep;i=i+5000) {
    			new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("app-status")));
    			getStatus = driver.findElement(By.tagName("app-status")).getText().toUpperCase();
    			System.out.println(" -- Order satus 1: "+getStatus);
    			if (getStatus.equals(orderStatusMayus)) {
    				System.out.println(" -- Order satus 2: "+getStatus);
    				break;
    			}
    			Thread.sleep(3000);
    			driver.navigate().refresh();   
    		}
			driver.navigate().refresh();    	
    	} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	if (!orderStatusMayus.equals(getStatus)) {
    		Assert.fail("The status does not match the order.");
    	}	
    }
    
	public void itemsCompleted(io.cucumber.datatable.DataTable dataTable, String orderStatus) {
    	
		//Nos traemos la lista de cucumber y la pasamos como lista
		List<String> items = dataTable.asList();
        for (int i=0;i<items.size();i++) {
        }
		
    	//Accedemos a "Mas opciones"
    	specialClick("//span[contains(text(),'Options')]");
    	specialClick("//tbody/tr[1]/td[4]/ul[1]/li[1]/div[1]/a[1]");
    	
    	
    	String orderStatusMayus = orderStatus.toUpperCase(); //Modificamos variable de cucumber a mayusculas.
    	
    	//Esperamos a que aparezca el siguiente "objeto" antes de realizar la busqueda y continuar
    	new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Order item')]")));
    	
    	// Generamos variable para almacenar los parámetros encontrados en lista
    	ArrayList<String> output_webelement = new ArrayList<String>();
    	
    	// Obtenemos y almacenamos en variable los objetos deseados
    	WebElement element = driver.findElement(By.className("tbody-related-order"));
        List<WebElement> elements = element.findElements(By.tagName("td"));
        for (WebElement e : elements) {
        	output_webelement.add(e.getText());
        }
        
        // Utilizamos un for para recorrer los parámetros con las listas obtenidas y comprobamos
        try {
        	for(int X = 0, Y = 1, Z=3; X < items.size(); X++, Y=Y+5, Z=Z+5){
	        	if (items.get(X).equals(output_webelement.get(Y))) {
	            	System.out.println(" -- The service " + items.get(X) + " is correct.");
	    		} else {
	    			Assert.fail("Order status is incorrect 1.");
	    	    }
	            
	            if (output_webelement.get(Z).equals(orderStatusMayus)) {
	    			System.out.println(" -- The status of "+ output_webelement.get(Y) +" is correct: "+ output_webelement.get(Z));
	    		} else {
	    			Assert.fail("Order status is incorrect 2.");
	    	    }
            }
        	
        } catch(Exception e) {
        	System.out.println("No service associated with the order.");
        }
	}
    
	public void servicesSI(String serviceStatus){

		ArrayList<String> output_webelement = new ArrayList<String>();
		
		WebElement element = driver.findElement(By.className("tbody-related-order"));
        List<WebElement> elements = element.findElements(By.tagName("tr"));

        for (WebElement e : elements) {
        	output_webelement.add(e.getText());
        }
        
        // Generamos bucle según los servicios que haya
        for(int X = 0, Y = 1; X < output_webelement.size(); X++, Y++) {
     
	    	// Clicamos sobre el "radio button"
	    	specialClick("//body[1]/app-root[1]/app-layout[1]/div[2]/div[1]/div[1]/div[1]/div[2]/app-product-orders-detail[1]/app-product-order[1]/div[3]/div[2]/app-service-orders-detail-modal[1]/div[1]/div[2]/div[2]/div[1]/section[1]/div[1]/div[1]/table[1]/tbody[1]/tr["+ Y + "]/td[5]");
	    	
	    	// Clicamos sobre el servicio de la orden
	    	specialClick("//body/app-root[1]/app-layout[1]/div[2]/div[1]/div[1]/div[1]/div[2]/app-product-orders-detail[1]/app-product-order[1]/div[3]/div[2]/app-service-orders-detail-modal[1]/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/p[1]/a[1]/i[1]");
	    	
	    	//Generamos una lista de pestañas y seleccionamos la pestaña siguiente
	    	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	        driver.switchTo().window(tabs.get(1));
	    	
	        // Comprobamos que estemos sobre la pestaña "Service Inventory"
	        if (driver.getTitle().equals("Service Inventory")) {
	        	
	        	//String state = getText("//strong[contains(text(),'active')]"); // Modificar por otro tag, active no sirve
	        	
	        	String state = getText("//strong[contains(text(),'" + serviceStatus + "')]");
	        	
	        	if (serviceStatus.equals(state)) {
	            	System.out.println(" -- Correct service status: " + state);
	
	            	driver.close();
	            	driver.switchTo().window(tabs.get(0));
	            	
	            	specialClick("//span[contains(text(),'Change order item')]");
	            	
	    		} else {
	    			Assert.fail("Wrong service status ");
	    	    }
	        	
			} else {
				Assert.fail("Wrong browser tab.");
		    }
        }
	}
	
	public void endTest() {
        driver.close();
        driver.quit();
	}
}
