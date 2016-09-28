package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = ".menu_lang")
    WebElement languageButton;

    @FindBy(css = ".a1[href='/ru/electronics/']")
    WebElement goToCategoryLink;


    public MainPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    public void SwitchLanguage(){
        languageButton.click();
    }

    public void goToCategory(){
        goToCategoryLink.click();
    }

}
