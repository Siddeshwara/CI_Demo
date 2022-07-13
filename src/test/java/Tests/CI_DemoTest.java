package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        driver.get("http://the-internet.herokuapp.com/key_presses");
        //driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void KeyAction() throws InterruptedException {

        Actions action = new Actions(driver);

        action.sendKeys(Keys.CANCEL).build().perform();//Keys.ESCAPE, Keys.PAGE_DOWN,Keys.PAGE_UP,Keys.BACK_SPACE

        String text = driver.findElement(By.id("result")).getText();
        System.out.println(text);

        Thread.sleep(3000);
        if(text.contains("You entered: CANCEL"))
        {
            System.out.println("Test passed");
        }
        else
        {
            System.out.println("Test Failed");
        }
    }



    @AfterClass
    public void teardown()
    {
        driver.close();
        System.out.println("Everything okay!");
    }

}


