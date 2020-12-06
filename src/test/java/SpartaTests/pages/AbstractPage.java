package SpartaTests.pages;

import core.FrameworkCore;
import core.utils.PauseLenght;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage extends FrameworkCore {
    private static WebDriver driver = getInstance();

    Actions actions = new Actions(driver);

    public WebDriver getDriver() {
        return driver;
    }

    public void openUrl(String url) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    public void closeBrowser(){
        driver.quit();
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLenght.AJAX.value());
            waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLenght.AJAX.value());
            waiter.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    public static By getElementBy(String element) {
        return By.xpath(element);
    }

    public WebElement getElement(String element) {
        return driver.findElement(By.xpath(element));
    }

    public static By getElementById(String id) {
        return By.id(id);
    }

    public WebElement getWebElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public List<WebElement> getElements(String element) {
        return driver.findElements(By.xpath(element));
    }

    public void setCursorOnElement(String locator) {
        actions.moveToElement(driver.findElement(By.xpath(locator)));
        actions.perform();
    }

    public String getCategoryText(String str) {
        String[] transfer = str.split(" ");
        return transfer[0];
    }

    public int getNumber(String element) {
        String str = getElement(element).getText();
        String[] transfer = str.split(" ");
        return Integer.valueOf(transfer[0]);
    }

    public float getNumber(WebElement element) {
        String str = element.getText();
        String transfer = str.split(" ")[0];
        return Float.parseFloat(transfer);
    }

    public int randomInt(){
        return obj.nextInt(10);
    }

    public void refresh(){driver.navigate().refresh();}
}
