package pages;

public class GooglePage extends BasePage {
    
    public GooglePage (){
        super(driver);
    }

    public void NavigateToGoogle (){
        navigateTo("https://www.google.es");
    }

}
