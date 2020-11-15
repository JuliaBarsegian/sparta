package SpartaTests.tasks.task3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest {
    public static final String URL = "https://www.seleniumeasy.com/test/javascript-alert-box-demo.html";
    private static final By ClickMeBtn = By.xpath("//button[@class=\"btn btn-default btn-lg\"][text()='Click me!']");
    private  static final By OkBtn = By.xpath("//p[@id=\"confirm-demo\"][text()='You pressed OK!']");
    private  static final By CancelBtn = By.xpath("//p[@id=\"confirm-demo\"][text()='You pressed Cancel!']");
    private static  final By PromptBtn = By.xpath("//button[@class=\"btn btn-default btn-lg\"][text()='Click for Prompt Box']");
    private  static  final By ConfirmPromptBtn = By.xpath("//p[@id=\"prompt-demo\"][text()=\"You have entered 'Julia' !\"]");
    private static final String ExpectedMessage1 = "You pressed OK!";
    private static final String ExpectedMessage2 = "You pressed Cancel!";
    private static final String ExpectedMessage3 = "You have entered 'Julia' !";

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
    public void alertAcceptTest(){
        driver.findElement(ClickMeBtn).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String actualResult = driver.findElement(OkBtn).getText();
        Assert.assertEquals(actualResult, ExpectedMessage1);

    }

    @Test
    public void alertDeclineTest(){
        driver.findElement(ClickMeBtn).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        String actualResult2 = driver.findElement(CancelBtn).getText();
        Assert.assertEquals(actualResult2, ExpectedMessage2);
    }


    @Test
    public void alertPromptBoxTest(){
        driver.findElement(PromptBtn).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Julia");
        alert.accept();

        String actualResult3 = driver.findElement(ConfirmPromptBtn).getText();
        Assert.assertEquals(actualResult3, ExpectedMessage3);
    }
}
