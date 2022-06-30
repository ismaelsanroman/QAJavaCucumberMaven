package steps;

import io.cucumber.java.en.*;
import pages.PruebaPage;

public class PruebaSteps {
    PruebaPage pruebaPage = new PruebaPage();

    @Given("^Navego hacia la web$")
    public void navigateToWeb() {
        System.out.println(" --- navigateToWeb --- ");
        // pruebaPage.navigateToWeb();
    }

    @When("^Buscamos en la web: Y$")
    public void searchToWeb() {
        System.out.println(" --- searchToWeb --- ");
    }

    @And("^Clicamos sobre el boton$")
    public void clickTo() throws Exception {
        System.out.println(" --- clickTo --- ");
        throw new Exception();
    }

    @Then("^Obtengo de la web los resultados: Y$")
    public void dataToWeb() {
        System.out.println(" --- dataToWeb --- ");
    }
}
