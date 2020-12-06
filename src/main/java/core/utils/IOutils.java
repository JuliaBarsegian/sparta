package core.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

    public class IOutils {
        private WebDriver driver;

        public static String loadGenericProperties(String key, String fileName){
            Properties properties = new Properties();
            FileInputStream filePath;

            try {
                String filePathString = "src/main/resources/" + fileName + ".properties";
                filePath = new FileInputStream(filePathString);
                properties.load(filePath);
                filePath.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return properties.getProperty(key);
        }

        public void takeScreenshoot() {
            Date date = new Date();
            String fileName = date.toString().replace(":", "_").replace(" ", "_") + ".png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.moveFile(screenshot, new File("./target/screenshots/" + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
