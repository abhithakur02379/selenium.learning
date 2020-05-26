package selenium.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.utilities.InputRead;


public class Login {



    @BeforeClass
    public void m1(){
        System.out.println("Test Started");
    }



    @Test
    public void Setup() throws InterruptedException
    {

        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\login\\Tools\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(InputRead.getProperty("baseURI"));
        Thread.sleep(5000);
        if (driver.findElement(By.xpath("//a[contains(text(),'ParaBank')]")).isDisplayed())
        {
            System.out.println("Home Page Loaded");
            if (driver.findElement(By.xpath("//*[contains(text(),'Customer Login')]")).isDisplayed())
            {
                driver.findElement(By.xpath("//*[contains(@name,'username')]")).sendKeys(InputRead.getProperty("username"));
                driver.findElement(By.xpath("//*[contains(@name,'password')]")).sendKeys(InputRead.getProperty("password"));
                driver.findElement(By.xpath("//*[contains(@value,'Log In')]")).click();
                Thread.sleep(2000);
                if (driver.findElement(By.xpath("//*[contains(text(),'Log Out')]")).isDisplayed())
                {
                    System.out.println("User Login Successfull");

                }
                else
                {
                    System.out.println("User Login NOT Successfull");
                }
            }
        }
        else
        {
            System.out.println("Home Page Not Loaded");
        }
    }




}