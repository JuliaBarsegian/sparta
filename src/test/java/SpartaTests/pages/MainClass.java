//package SpartaTests.pages;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//public class MainClass {
//
//
//    public static void main(String[] arg) throws InterruptedException, IOException {
//        final String TUT_BY_URL = "https://www.tut.by/";
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get(TUT_BY_URL);
//
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("d:\\tmp\\screenshot.png"));
//
//        TutByPage page = PageFactory.initElements(driver, TutByPage.class);
////        page.LoginUser();
//        driver.quit();
//    }
//}
