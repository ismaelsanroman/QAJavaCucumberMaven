package pages;

// Usamos la herencia de las funciones de FunctionsPage reutilizando codigo.
public class PruebaPage extends FunctionsPage {

    public PruebaPage() {
        super(driver);
    }

    public void navigateToWeb() {
        navigateTo("www.google.es");
        endTest();

    }
}
