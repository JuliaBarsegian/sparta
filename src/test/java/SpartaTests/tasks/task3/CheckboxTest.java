package SpartaTests.tasks.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckboxTest {
    public static final String URL = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
    private static final String checkbox1 = "[value=California]";
    private static final String checkbox2 = "[value=Florida]";
    private static final String checkbox3 = "[value=Texas]";

    private WebDriver driver;

    @BeforeMethod
    public void OpenStartPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //Неявное
        driver.get(URL);
    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }

    @Test
    public void checkboxTest(){
        Select states = new Select(driver.findElement(By.name("States")));
        states.selectByValue("California");
        states.selectByValue("Florida");
        states.selectByValue("Texas");

        List<WebElement> selectedStates = states.getAllSelectedOptions();
        List<WebElement> finallySelectedStates = new ArrayList<>();
        finallySelectedStates.add(driver.findElement(By.cssSelector(checkbox1)));
        finallySelectedStates.add(driver.findElement(By.cssSelector(checkbox2)));
        finallySelectedStates.add(driver.findElement(By.cssSelector(checkbox3)));
        Assert.assertEquals(selectedStates, finallySelectedStates);
    }


























}
