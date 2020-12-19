package SpartaTests.tests;

import SpartaTests.pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class TutByLoginTest {
    private static final String USERNAME = "seleniumtests@tut.by";
    private static final String PASSWORD = "123456789zxcvbn";
    private WebDriver driver;
    private WebDriverWait wait;
    private TutByPage tutByPage;
    private FinancePage financePage;
    private BanksPage banksPage;
    private PosterPage posterPage;
    private MoviesPage moviesPage;
    private StranaGrezPage stranaGrezPage;
    private PriceCatalogPage priceCatalogPage;
    private IphonePage iphonePage;

    @BeforeMethod
    public void setup() throws IOException {
        ChromeOptions options = new ChromeOptions(); //Task5
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.tut.by/");
        wait = new WebDriverWait(driver, 15, 50);
        tutByPage = new TutByPage(driver);
        financePage = new FinancePage(driver);
        banksPage = new BanksPage(driver);
        posterPage = new PosterPage(driver);
        moviesPage = new MoviesPage(driver);
        stranaGrezPage = new StranaGrezPage(driver);
        priceCatalogPage = new PriceCatalogPage(driver);
        iphonePage = new IphonePage(driver);
    }

    @Test(priority = 0)    //Task4
    public void loginToAccountTest()  {
        tutByPage.clickloginUserBtn();
        tutByPage.fillUsernameField(USERNAME);
        tutByPage.fillPasswordFields(PASSWORD);
        tutByPage.clickEnterBtn();
        String expectedAccountName = tutByPage.getAccountNameText();
        Assert.assertEquals(expectedAccountName, "Selenium Test");
    }

    @Test(priority = 1)   //Task4
    public void LogoutFromAccount()  {
        tutByPage.LoginUser().logoutUser();
        WebElement ConfirmUserLoggedOut = (new WebDriverWait(driver, 5, 100)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class = 'enter']")));
        Assert.assertTrue(ConfirmUserLoggedOut.isDisplayed());
    }

    @Test(priority = 2)   //Task6-1
    public void navigateToBGPbank(){
        tutByPage.clickFinanceBtn();
        financePage.clickBanksLink();
        banksPage.clickBGPbankLink();
        WebElement ConfirmBGPbankIsOpened = (new WebDriverWait(driver, 5, 100)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='crumbs-i'][text()='Белгазпромбанк']")));
        Assert.assertTrue(ConfirmBGPbankIsOpened.isDisplayed());
    }

    @Test(priority = 3)   //Task6-2
    public void navigateToMovies(){
        tutByPage.clickPostersLink();
        posterPage.clickFilmsLink();
        moviesPage.clickStranaGrezLink();
        String expectedMovieName = stranaGrezPage.getMovieNameText();
        Assert.assertEquals(expectedMovieName, "Страна грез");
    }


    @Test(priority = 4)   //Task6-3
    public void navigateToIphone8()  {
       tutByPage.clickPriceCatalogPage();
       priceCatalogPage.clickSearchInputField().selectIphone8_64GB();
       String expectedPhoneName = iphonePage.getIphoneHeaderText();
       Assert.assertEquals(expectedPhoneName, "Смартфон Apple iPhone 8 64GB");
    }


    @AfterMethod
    public void tearDown(){
//        Date date = new Date();
//        String fileName = date.toString().replace(":", "_").replace(" ", "_") + ".png";
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.moveFile(screenshot, new File("./target/screenshots/" + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
       driver.quit();
        }
    }

