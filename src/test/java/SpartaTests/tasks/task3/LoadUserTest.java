package SpartaTests.tasks.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoadUserTest {
    public static final String URL = "https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html";
    private static final By GetNewUserBtn = By.id("save");
    private static final By Result = By.xpath("//div[contains( text(),'First')]");
    private WebDriver driver;

    @BeforeMethod
    public void OpenStartPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }

    @Test
    public void loadUserTest(){  //element is hidden in DOM by default
        driver.findElement(GetNewUserBtn).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(Result));

        Assert.assertTrue(driver.findElement(Result).isDisplayed(), "User wasn't loaded, try again");

    }
}
