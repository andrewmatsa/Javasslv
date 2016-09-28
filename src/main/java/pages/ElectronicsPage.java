package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectronicsPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "a[href='/ru/electronics/search/']")
    WebElement clickOnSearch;

    public ElectronicsPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    public void clickOnSearchButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/ru/electronics/search/']")));
        clickOnSearch.click();
    }

}
