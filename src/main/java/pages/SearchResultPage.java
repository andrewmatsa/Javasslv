package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SearchResultPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = ".filter_opt_dv:last-of-type select")
    WebElement sortingPrice;

    @FindBy(css = "a[href='/ru/electronics/search/']")
    WebElement clickAdvancedSearchElement;

    @FindBy(css = ".msga2.pp0 > *:first-child")
    WebElement clickOnCheckboxes;

    @FindBy(id = "a_fav_sel")
    WebElement clickAddToMemo;

    @FindBy(css = "a[href='/ru/favorites/']")
    WebElement clickBookmarks;

    public SearchResultPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    public void sortByPrice(){
        Select select = new Select(sortingPrice);
        select.selectByValue("/ru/electronics/search-result/sell/");
    }

    public void clickAdvancedSearch(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/ru/electronics/search/']")));
        clickAdvancedSearchElement.click();
    }

    public void selectCheckboxes(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".msga2.pp0 > *:first-child")));
        List<WebElement> listings = webDriver.findElements(By.cssSelector(".msga2.pp0 > *:first-child"));
        Random r = new Random();

        for (int i = 0; i < 3; i++) {
            int randomValue = r.nextInt(listings.size());
            listings.get(randomValue).click();
        }
    }

    public void addToMemo(){
        ((JavascriptExecutor)webDriver).executeScript("scroll(0,400)");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("a_fav_sel")));
        clickAddToMemo.click();
    }

    public void clickBookmarks(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[href='/ru/favorites/']")));
        clickBookmarks.click();
    }

}
