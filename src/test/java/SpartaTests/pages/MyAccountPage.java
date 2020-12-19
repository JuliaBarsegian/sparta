package SpartaTests.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement myAccountPageHeader;

    @FindBy(className = "lnk_wishlist")
    private WebElement myWishlistsLink;

    @FindBy(id = "name")
    private WebElement myWishlistName;

    @FindBy(id = "submitWishlist")
    private WebElement saveWishlistBtn;

    @FindBy(xpath = "//*[contains(text(),'TestWishlist')]")
    private WebElement wishlistTable;

    @FindBy(css = ".product-name[href*='id_product=7&controller=product'][title='']")
    private WebElement product;

    @FindBy(id = "wishlist_button")
    private WebElement wishlistBtn;

    @FindBy(css = "[title=Close]")
    private WebElement closeWishlistBtn;

    @FindBy(xpath = "//i[@class='icon-remove']")
    private WebElement removeWishlist;

    @FindBy(css = "[title='View my shopping cart']")
    private WebElement cartBtn;

    public String getMyAccountPageHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(myAccountPageHeader));
        return myAccountPageHeader.getText();
    }

    public MyAccountPage addItemTotWishList(){
        myWishlistsLink.click();
        myWishlistName.sendKeys("TestWishlist");
        saveWishlistBtn.click();
        product.click();
        wishlistBtn.click();
        driver.get("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
        wishlistTable.isDisplayed();
        return this;
    }

    public String getMyWishListText() {
        wait.until(ExpectedConditions.visibilityOf(wishlistTable));
        return wishlistTable.getText();
    }

    public MyAccountPage removeMyWishList() {
        wait.until(ExpectedConditions.visibilityOf(removeWishlist));
        removeWishlist.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public CartPage goToCart() {
        wait.until(ExpectedConditions.visibilityOf(cartBtn)).click();
        return new CartPage(driver);
    }
}
