package core;

import core.utils.BrowserConstants;
import core.utils.IOutils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Random;

public class FrameworkCore {
    private static WebDriver webDriver;
    private static String browser = IOutils.loadGenericProperties("browser", "configuration");

    public Random obj = new Random();

    public static WebDriver getInstance(){
        if(browser.equals(BrowserConstants.CHROME)){
            webDriver= new ChromeDriver();
        }else{
            if(browser.equals(BrowserConstants.FIREFOX)){
                webDriver = new FirefoxDriver();
            }else{
                throw new IllegalArgumentException("Browser value from property file is incorrect!");
            }
        }
        return webDriver;
    }
}
