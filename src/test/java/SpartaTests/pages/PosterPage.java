package SpartaTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PosterPage {

    private WebDriver driver;

    public PosterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href$='/film/']")
    private WebElement filmLink;

    public MoviesPage clickFilmsLink(){
        filmLink.click();
        return new MoviesPage(driver);
    }

}
