package steps;

import io.cucumber.java.en.*;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^Navegamos hacia Google$")
    public void NavigateToGoogle(){
    google.NavigateToGoogle();
    }

    @When("^Buscamos contenido$")
    public void enterSearchCriteria(){

    }

    @And("^Hacemos Click sobre el boton de buscar$")
    public void clickSearchButton(){

    }

    @Then("^Obtenemos los resultados de la busqueda$")
    public void validateResults(){

    }

}
