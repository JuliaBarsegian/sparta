package SpartaTests.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TutByPage {

    private static final String USERNAME = "seleniumtests@tut.by";
    private static final String PASSWORD = "123456789zxcvbn";

    private WebDriver driver;

    public TutByPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "enter")
    private WebElement loginIBtn;

    @FindBy(xpath = "//div[@class='b-hold']/input[@name='login']")
    private WebElement username;

    @FindBy(xpath = "//div[@class='b-hold']/input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//div[@class='b-hold']/input[@value='Войти']")
    private WebElement enterBtn;

    @FindBy(xpath = "//span[@class='uname'][text()='Selenium Test']")
    private WebElement confirmUserText;

    @FindBy(css = "[class$='auth__reg']")
    private  WebElement logoutBtn;

    @FindBy(xpath = "//div[@class='b-auth-title'][text()='Вход']")
    private WebElement enterPopupText;

    @FindBy(linkText = "Финансы")
    private  WebElement financeLink;

    @FindBy(linkText = "Афиша")
    private  WebElement posterLink;

    @FindBy(linkText = "Каталог цен")
    private WebElement priceCatalog;

    public FinancePage clickFinanceBtn(){
        financeLink.click();
        return new FinancePage(driver);
    }

    public PosterPage clickPostersLink(){
        posterLink.click();
        return new PosterPage(driver);
    }

    public PriceCatalogPage clickPriceCatalogPage(){
        priceCatalog.click();
        return new PriceCatalogPage(driver);
    }


    public TutByPage clickloginUserBtn()  {
        loginIBtn.click();
        return this;
    }

    public TutByPage fillUsernameField(String username)  {
        this.username.sendKeys(USERNAME);
        return this;
    }

    public TutByPage fillPasswordFields(String password)  {
       this.password.sendKeys(PASSWORD);;
        return this;
    }

    public TutByPage clickEnterBtn()  {
        enterBtn.click();
        return this;
    }

    public String getAccountNameText(){
        return confirmUserText.getText();
    }


    public TutByPage logoutUser(){
        confirmUserText.click();
        logoutBtn.click();
        return this;
    }

    public TutByPage LoginUser()  {
      clickloginUserBtn();
      fillUsernameField(USERNAME);
      fillPasswordFields(PASSWORD);
      return clickEnterBtn();
    }
}
