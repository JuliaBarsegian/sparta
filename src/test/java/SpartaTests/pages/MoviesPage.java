package SpartaTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoviesPage {
    private WebDriver driver;

    public MoviesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[alt='Страна грез']")
    private WebElement movieName;

    public StranaGrezPage clickStranaGrezLink(){
        movieName.click();
        return new StranaGrezPage(driver);
    }

}
