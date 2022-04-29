package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CI_DemoTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }


    @Test
    public void linkExistence()
    {
        boolean linkExistence=driver.findElement(By.linkText("Sell")).isDisplayed();

        if (linkExistence == true) {
            System.out.println("Sell Link Exists – Passed");
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("Sell Link Not Exists – Failed");
            Assert.assertTrue(false);

        }
    }



    @AfterClass
    public void teardown()
    {
        driver.close();
    }

}


