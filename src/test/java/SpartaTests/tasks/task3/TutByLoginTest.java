package SpartaTests.tasks.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TutByLoginTest {


        private static String loginInput = "//a[@class = 'enter']";
        private static String UsernameInput = "//div[@class='b-hold']/input[@name='login']";
        private static String PasswordInput = "//div[@class='b-hold']/input[@name='password']";
        private static String EnterButton = "//div[@class='b-hold']/input[@value='Войти']";
        private static String ConfirmUser = "//span[@class='uname'][text()='Selenium Test']";
        private static final String TUT_BY_URL = "https://www.tut.by/";
        private static final String PASSWORD = "123456789zxcvbn";

        private WebDriver driver;

        @BeforeMethod
        public void OpenStartPage(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //Неявное
            driver.get(TUT_BY_URL);
        }


        @AfterMethod
        public void CloseBrowser(){
            driver.quit();
        }

        @Test(dataProvider = "provideUsername")
        public void loginToAccount1(String data) throws InterruptedException {
            driver.findElement(By.xpath(loginInput)).click();
            driver.findElement(By.xpath(UsernameInput)).sendKeys(data);
            driver.findElement(By.xpath(PasswordInput)).sendKeys(PASSWORD);
            driver.findElement(By.xpath(EnterButton)).click();
            Thread.sleep(5);  //Explicit Wait Явное
            WebElement ConfirmUserLoggedIn = (new WebDriverWait(driver, 5, 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ConfirmUser)));
            Assert.assertTrue(ConfirmUserLoggedIn.isDisplayed());
        }

        @DataProvider(name = "provideUsername")
        public Object[][] provideUsername(){
            return new Object[][]{{"seleniumtests@tut.by"}, {"seleniumtests2@tut.by"}};
        }
        }


