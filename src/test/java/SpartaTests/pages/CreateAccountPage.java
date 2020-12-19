package SpartaTests.pages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String state = "[value=5]";
    private String password = "Test12345";

    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='navigation_page']")
    private WebElement createAccountPageHeading;

    @FindBy(id = "uniform-id_gender2")
    private WebElement mrsGenderCheckbox;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private Select states;

    @FindBy(id = "postcode")
    private WebElement postcodeInput;

    @FindBy(id = "id_country")
    private WebElement countryDropdown;

    @FindBy(id = "phone_mobile")
    private WebElement mobileInput;

    @FindBy(id = "alias")
    private WebElement addressAliasInput;

    @FindBy(id = "submitAccount")
    private WebElement registerBtn;

    public String getPageHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(createAccountPageHeading));
        return createAccountPageHeading.getText();
    }

    public CreateAccountPage selectMrsGenderCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(mrsGenderCheckbox)).click();
        return this;
    }

    public CreateAccountPage fillFirstNameInput() {
        firstNameInput.sendKeys("TestName");
        return this;
    }

    public CreateAccountPage fillLastNameInput() {
        lastNameInput.sendKeys("TestLastName");
        return this;
    }

    public CreateAccountPage fillGenegatedPasswordInput() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        passwordInput.sendKeys(generatedString);
        return this;
    }

    public CreateAccountPage selectNewsletterCheckbox() {
        newsletterCheckbox.click();
        return this;
    }

    public CreateAccountPage fillAddressInput() {
        addressInput.sendKeys("Lenina Street 15");
        return this;
    }

    public CreateAccountPage fillCityInput() {
        cityInput.sendKeys("TestCity");
        return this;
    }

    public CreateAccountPage fillStateDropdown() {
        Select states = new Select(driver.findElement(By.id("id_state")));
        states.selectByValue("5");
     return this;
    }

    public CreateAccountPage fillPostcodeInput() {
        postcodeInput.sendKeys("13456");
        return this;
    }

    public CreateAccountPage fillMobileInput() {
        mobileInput.sendKeys("798-564-526");
        return this;
    }

    public CreateAccountPage fillAddressAliasInput() {
        addressAliasInput.sendKeys("TestAlias");
        return this;
    }

    public MyAccountPage submitAccount() {
        registerBtn.click();
        return new MyAccountPage(driver);
    }

}
