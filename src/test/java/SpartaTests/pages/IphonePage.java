package SpartaTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IphonePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public IphonePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "big")
    private WebElement iphone8Header;

    public String getIphoneHeaderText(){
        wait.until(ExpectedConditions.visibilityOf(iphone8Header));
        return iphone8Header.getText();
    }

}
