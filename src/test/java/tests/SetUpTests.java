package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testutilities.InputRead;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SetUpTests {



    @Test(priority = 1, description = "Test to verify application launched successfully")
    public void launch_ParaBank () throws InterruptedException
    {

        System.setProperty("webdriver.edge.driver", "C:\\Users\\login\\selenium.learning\\src\\Drivers\\msedgedriver.exe");
        System.setProperty("selenide.browser", "Edge");
        Thread.sleep(2000);
        Configuration.startMaximized = true;
        open(InputRead.getProperty("baseURI"));
        Thread.sleep(1000);
        if ($(By.xpath("//a[contains(text(),'ParaBank')]")).isDisplayed())
        {
            System.out.println("Home Page Loaded");
            Assert.assertEquals("Home Page Loaded","Home Page Loaded");
        }
        else
        {
            System.out.println("Home Page NOT Loaded");
            Assert.assertEquals("Home Page NOT Loaded","Home Page Loaded");
        }
    }



}
