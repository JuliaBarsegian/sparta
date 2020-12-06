package SpartaTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BGPbankPage {
    private WebDriver driver;

    public BGPbankPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='crumbs-i'][text()='Белгазпромбанк']")
    private WebElement headerText;
}
