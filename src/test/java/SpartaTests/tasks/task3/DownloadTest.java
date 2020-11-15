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

public class DownloadTest {
    public static final String URL = "https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html";
    private static final By downloadBtn = By.id("cricle-btn");
    private static final By percentage = By.xpath("//div[contains( text(),'50%')]");
    private static final By percentage1 = By.xpath("//div[contains( text(),'0%')]");
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
    public void DownloadPercentageTest(){  //Element is NOT present in DOM by default
        driver.findElement(downloadBtn).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(percentage));
        driver.navigate().refresh();  //рефреш страницы
        Assert.assertTrue(driver.findElement(percentage1).isDisplayed());
    }
}
