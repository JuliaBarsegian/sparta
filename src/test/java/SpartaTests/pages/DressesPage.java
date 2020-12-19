package SpartaTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DressesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DressesPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='submenu-container clearfix first-in-line-xs']/preceding-sibling::a[@title='Dresses']")
    private WebElement dressesLink;

    @FindBy(xpath = "(//div[@class='product-container'])[1]")
    private WebElement item1;

    @FindBy(xpath = "(//div[@class='product-container'])[2]")
    private WebElement item2;

    @FindBy(xpath = "(//div[@class='product-container'])[3]")
    private WebElement item3;

    @FindBy(xpath = "(//div[@class='product-container'])[1]//div[@class='button-container']")
    private WebElement addToCartBtn;


    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']")
    private WebElement continueShoppingBtn;



    public DressesPage addItemToCart(String items){
        dressesLink.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(items))).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn)).click();
        return this;
    }
}
