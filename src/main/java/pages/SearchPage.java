package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(id = "ptxt")
    WebElement SearchField;

    @FindBy(id = "cmp_4")
    WebElement selectingParameter;

    @FindBy(id = "sbtn")
    WebElement clickSearchButtonElement;

    @FindBy(css = ".in3:nth-child(1)")
    WebElement selectMinPrice;

    @FindBy(css = ".in3:nth-child(2)")
    WebElement selectMaxPrice;

    public SearchPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    public void searchFor(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ptxt")));
        SearchField.clear();
        SearchField.sendKeys(text);
    }

    public void selectParameter(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmp_4")));
        selectingParameter.click();
    }

    public void clickSearchButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sbtn")));
        clickSearchButtonElement.click();
    }

    public void selectMinPrice(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".in3:nth-child(1)")));
        selectMinPrice.clear();
        selectMinPrice.sendKeys(text);
    }

    public void selectMaxPrice(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".in3:nth-child(2)")));
        selectMinPrice.clear();
        selectMinPrice.sendKeys(text);
    }

}
