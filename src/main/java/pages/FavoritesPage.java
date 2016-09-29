package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FavoritesPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public FavoritesPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void verifyFavoriteUrl(){
        wait.until(ExpectedConditions.urlContains("/favorites/"));
    }

    public void verifyListingSize(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".msga2.pp0 > *:first-child")));
        List<WebElement> listings = webDriver.findElements(By.cssSelector(".msga2.pp0 > *:first-child"));
        if (listings.size() == 3) {
            System.out.println("There is 3 items in bookmarks");
        } else {
            System.err.println("Check bookmarks imtems!");
        }
    }

}
