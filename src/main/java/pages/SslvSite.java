package pages;

import org.openqa.selenium.WebDriver;

public class SslvSite {
    WebDriver webDriver;

    public SslvSite(WebDriver driver){
        webDriver = driver;
    }

    public MainPage mainPage() { return new MainPage(webDriver); }

    public ElectronicsPage electronicsPage() { return new ElectronicsPage(webDriver);}

    public SearchPage searchPage() { return new SearchPage(webDriver);}

    public SearchResultPage searchResultPage() { return new SearchResultPage(webDriver);}

}
