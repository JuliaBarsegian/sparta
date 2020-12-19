package SpartaTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StranaGrezPage {

    private WebDriver driver;

    public StranaGrezPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "event-name")
    private WebElement movieName;

    public String getMovieNameText(){

        return movieName.getText();
    }

}
