package SpartaTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BanksPage {
    private WebDriver driver;

    public BanksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href$='/banks/belgazprombank/']")
    private WebElement BGPbank;

    public BGPbankPage clickBGPbankLink()  {
        BGPbank.click();
        return new BGPbankPage(driver);
    }
}
