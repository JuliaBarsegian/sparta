package SpartaTests.pages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticeMainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String username = "seleniumtests@tut.by";
    private String password = "Test12345";

    public AutomationPracticeMainPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    private WebElement createEmailInput;

    @FindBy(xpath = "//i[@class='icon-user left']")
    private WebElement createAnAccountBtn;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;


    public AutomationPracticeMainPage fillGeneratedEmailInput(){
        String generatedString = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
        wait.until(ExpectedConditions.elementToBeClickable(createEmailInput));
        createEmailInput.sendKeys(generatedString);
        return this;
    }

    public CreateAccountPage submitCreateAccountBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(createAnAccountBtn)).click();
        return new CreateAccountPage(driver);
    }

    public MyAccountPage loginToAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(username);
        passwordInput.sendKeys(password);
        signInBtn.click();
        return new MyAccountPage(driver);
    }
}
