package pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ElectronicsPage;

import java.util.List;
import java.util.Random;

public class HomePageTests {
    WebDriver webDriver;
    SslvSite website;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.ss.lv/lv/");
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }

    @Test
    public void testElectronicsUrl() {
        WebDriverWait wait = new WebDriverWait(webDriver, 30, 500);
        website = new SslvSite(webDriver);

        System.out.println("Step 1: Switch to the Rus language");
        website.mainPage().SwitchLanguage();

        System.out.println("Step 2: Go to Electronics category and verify that url is correct");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".a1[href='/ru/electronics/']")));
        website.mainPage().goToCategory();
        website.electronicsPage().clickOnSearchButton();

        System.out.println("Step 3: Type in the search filed 'Computer' and select different parameter");
        website.searchPage().searchFor("Computer");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmp_4")));
        website.searchPage().selectParameter();

        System.out.println("Step 4: And I click Search button");
        website.searchPage().clickSearchButton();

        System.out.println("Step 5: Sort the results by price and select option");
        website.searchResultPage().sortByPrice();
        website.searchResultPage().clickAdvancedSearch();

        System.out.println("Step 6: Enter search option price between 160 and 300.Enter search option price between 160 and 300.");
        website.searchPage().selectMinPrice("160");
        website.searchPage().selectMaxPrice("300");
        website.searchPage().clickSearchButton();

        System.out.println("Step 7: Choose at least 3 random ads.");
        website.searchResultPage().selectCheckboxes();

        System.out.println("Step 8: Add to memo");
        website.searchResultPage().addToMemo();

        System.out.println("Step 9: Open memo and check that the ads on the page match the previously selected");
        website.searchResultPage().clickBookmarks();
        website.favoritesPage().verifyFavoriteUrl();
    }

}
