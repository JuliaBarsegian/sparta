package SpartaTests.tests;

import SpartaTests.pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;
import java.util.Date;

public class AutomationPracticeTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private AutomationPracticeMainPage automationPracticeMainPage;
    private CreateAccountPage createAccountPage;
    private MyAccountPage myAccountPage;
    private DressesPage dressesPage;
    private CartPage cartPage;


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        wait = new WebDriverWait(driver, 15, 50);
        automationPracticeMainPage = new AutomationPracticeMainPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
        dressesPage = new DressesPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void submitEmailForAccountTest() {
        automationPracticeMainPage.fillGeneratedEmailInput().submitCreateAccountBtn();
        String expectedPageHeader = createAccountPage.getPageHeaderText();
        Assert.assertEquals(expectedPageHeader, "Authentication");
    }

    @Test(description = "Verify the ability to create an account")
    public void createAccountTest()  {
        automationPracticeMainPage.fillGeneratedEmailInput().submitCreateAccountBtn();
        createAccountPage.selectMrsGenderCheckbox().fillFirstNameInput().fillLastNameInput().fillGenegatedPasswordInput().selectNewsletterCheckbox().fillAddressInput().
                fillCityInput().fillStateDropdown().fillPostcodeInput().fillMobileInput().fillAddressAliasInput().submitAccount();
        String expectedPageHeader = myAccountPage.getMyAccountPageHeaderText();
        Assert.assertEquals(expectedPageHeader, "MY ACCOUNT");
    }

    @Test(description = "Verify the ability to login in account")
    public void loginToAccountTest(){
        automationPracticeMainPage.loginToAccount();
    String expectedPageHeader = myAccountPage.getMyAccountPageHeaderText();
    Assert.assertEquals(expectedPageHeader, "MY ACCOUNT");
    }

    @Test(description = "Verify the ability to add to auto-created Wishlist")
    public void getWishListTest(){
        automationPracticeMainPage.loginToAccount();
        myAccountPage.addItemTotWishList();
        String expectedWishlistTable = myAccountPage.getMyWishListText();
        Assert.assertEquals(expectedWishlistTable, "TestWishlist");
        myAccountPage.removeMyWishList();
    }


    @DataProvider(name = "items")
    public Object[][] addToCart(){
        return new Object[][]{{"(//div[@class='product-container'])[1]"}};
        //, {"(//div[@class='product-container'])[2]"}, {"(//div[@class='product-container'])[3]"}
    }

    @Test(dataProvider = "items")
    public void addItemsToCart(String  items){
        automationPracticeMainPage.loginToAccount();
        dressesPage.addItemToCart(items);
        myAccountPage.goToCart();
        String expectedCartHeader = cartPage.getCartPageHeaderText();
        Assert.assertEquals(expectedCartHeader, "SHOPPING-CART SUMMARY\n" +
                "Your shopping cart contains: 1 Product");
    }


    @AfterMethod
    public void tearDown(){
                Date date = new Date();
        String fileName = date.toString().replace(":", "_").replace(" ", "_") + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.moveFile(screenshot, new File("./target/screenshots/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
