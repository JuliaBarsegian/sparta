package SpartaTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancePage {

    private WebDriver driver;

    public FinancePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/banks/']")
    private WebElement banksLink;


    public BanksPage clickBanksLink()  {
        banksLink.click();
        return new BanksPage(driver);
    }

}
