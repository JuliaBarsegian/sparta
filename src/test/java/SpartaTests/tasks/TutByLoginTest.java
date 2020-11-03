package SpartaTests.tasks;

import SpartaTests.pages.AbstractPage;
import core.utils.IOutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TutByLoginTest {

    private static String loginInput = "//a[@class = 'enter']";
    private static String UsernameInput = "//div[@class='b-hold']/input[@name='login']";
    private static String PasswordInput = "//div[@class='b-hold']/input[@name='password']";
    private static String EnterButton = "//div[@class='b-hold']/input[@value='Войти']";
    private static String ConfirmUser = "//span[@class='uname'][text()='Selenium Test']";

    private static final String TUT_BY_URL = "https://www.tut.by/";
    private static final String USERNAME = "seleniumtests@tut.by";
    private static final String PASSWORD = "123456789zxcvbn";
    private WebDriver driver;

    @BeforeMethod
    public void OpenStartPage(){
//        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(TUT_BY_URL);
    }


    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }

    @Test
    public void loginToAccount() throws InterruptedException {
        driver.findElement(By.xpath(loginInput)).click();
        driver.findElement(By.xpath(UsernameInput)).sendKeys(USERNAME);
        driver.findElement(By.xpath(PasswordInput)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(EnterButton)).click();
        WebElement ConfirmUserLoggedIn = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ConfirmUser)));
        Assert.assertTrue(ConfirmUserLoggedIn.isDisplayed());
    }
}

