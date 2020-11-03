package SpartaTests.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class By {
    private WebDriver driver;
    private static final String TUT_BY_URL = "https://www.tut.by/";

    @BeforeMethod
    public void OpenStartPage(){
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
    public void checkAllTypesOfLocators(){
        WebElement id = driver.findElement(org.openqa.selenium.By.id("authorize"));
        WebElement name = driver.findElement(org.openqa.selenium.By.name("search"));
        WebElement className =  driver.findElement(org.openqa.selenium.By.className("enter"));
        WebElement tagName = driver.findElement(org.openqa.selenium.By.tagName("li"));
        WebElement linkText = driver.findElement(org.openqa.selenium.By.linkText("ТV-программа"));
        WebElement partLinkText = driver.findElement(org.openqa.selenium.By.partialLinkText("Каталог"));  //Полное название - Каталог цен
        WebElement css = driver.findElement(org.openqa.selenium.By.cssSelector("[class=header-logo]"));
        WebElement xpath = driver.findElement(org.openqa.selenium.By.xpath("//a[@class = 'enter']"));

        Assert.assertTrue(id.isDisplayed());
        Assert.assertTrue(name.isDisplayed());
        Assert.assertTrue(className.isDisplayed());
        Assert.assertTrue(tagName.isDisplayed());
        Assert.assertTrue(linkText.isDisplayed());
        Assert.assertTrue(partLinkText.isDisplayed());
        Assert.assertTrue(css.isDisplayed());
        Assert.assertTrue(xpath.isDisplayed());
    }

}
