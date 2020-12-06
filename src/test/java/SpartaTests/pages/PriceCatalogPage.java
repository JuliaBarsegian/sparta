package SpartaTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PriceCatalogPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PriceCatalogPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Название товара']")
    private WebElement searchInputField;

    @FindBy(css = "[title='Смартфон Apple iPhone 8 64GB']")
    private WebElement iphone8_64GB;

    public PriceCatalogPage clickSearchInputField(){
        wait.until(ExpectedConditions.elementToBeClickable(searchInputField)).sendKeys("iphone 8 64GB");
        return this;
    }

    public IphonePage selectIphone8_64GB(){
       wait.until(ExpectedConditions.elementToBeClickable(iphone8_64GB)).click();
       return new IphonePage(driver);
    }
}
