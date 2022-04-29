package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CI_DemoTest {

    WebDriver driver;

    @BeforeClass
    public void setUp()
    {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
    }


    @Test
    public void linkExistence()
    {
        boolean linkExistence=driver.findElement(By.linkText("Sell")).isDisplayed();

        if (linkExistence == true) {
            System.out.println("Sell Link Exists – Passed");
        }
        else
        {
            System.out.println("Sell Link Not Exists – Failed");

        }
    }



    @AfterClass
    public void teardown()
    {
        driver.close();
    }

}


