package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import testutilities.InputRead;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SetUpTests {




//    @BeforeMethod(description = "Test to verify application launched successfully")
    public void launch_ParaBank () throws InterruptedException
    {

        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\msedgedriver.exe");
        System.setProperty("selenide.browser", "Edge");
        Thread.sleep(1000);
        Configuration.startMaximized = true;
        Configuration.reportsFolder = System.getProperty("user.dir") + "\\test-output";
        open(InputRead.getProperty("baseURI"));
        Thread.sleep(1000);
        if ($(By.xpath("//a[contains(text(),'ParaBank')]")).isDisplayed())
        {
            Reporter.log("Home Page Loaded");
            Assert.assertEquals("Home Page Loaded","Home Page Loaded");
        }
        else
        {
            Reporter.log("Home Page NOT Loaded");
            Assert.assertEquals("Home Page NOT Loaded","Home Page Loaded");
        }
    }



}
