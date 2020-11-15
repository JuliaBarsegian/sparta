package SpartaTests.tasks.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataTableTest {
    public static final String URL = "https://www.seleniumeasy.com/test/table-sort-search-demo.html";
    private WebDriver driver;

    @BeforeMethod
    public void OpenStartPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterMethod
    public void CloseBrowser() {
        driver.quit();
    }

    @Test
    public void printCustomerNameTest() {
        List<WebElement> elements = driver.findElements(By.xpath("//tbody/tr"));  //get all rows
        List<Customer> customers = new ArrayList<>();
        for (WebElement el : elements) {
            String name = el.findElement(By.xpath(".//td[1]")).getText();
            Customer customer = new Customer(name);
            customers.add(customer);

        }
        System.out.println(customers);

    }

            @Test
            public void getAllDataTest () {

                //Get all rows
                List<WebElement> rows = driver.findElements(By.tagName("tr"));

                //Print data from each row
                for (WebElement row : rows) {
                    List<WebElement> cols = row.findElements(By.tagName("td"));
                    for (WebElement col : cols) {
                        System.out.print(col.getText() + "\t");
                    }
                    System.out.println();
                }
            }
}



//    String position = el.findElement(By.xpath(".//td[2]")).getText();
//    String office = el.findElement(By.xpath(".//td[3]")).getText();
//    String salary = el.findElement(By.xpath(".//td[6]")).getText();

//            List<CustomerAge> ageColumn = new ArrayList<>();
//            for (WebElement el4 : elements) {
//                String age = el4.findElement(By.xpath(".//td[4]")).getText();
//                CustomerAge customerAge = new CustomerAge(age);
//                customerAge.getAge();
//            }
//            System.out.println(ageColumn);




