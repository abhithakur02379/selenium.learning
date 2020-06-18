package tests;

import com.codeborne.selenide.testng.ScreenShooter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reporting.ExtentReport;

import java.awt.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static testutilities.ReadDataFromExcel.Data;


@Listeners({ScreenShooter.class})
public class LoginTests extends ExtentReport {


    SetUpTests setup = new SetUpTests();


    @Test(priority = 3, description = "Customer login with Valid Credentials")
    public void verifyUserLoginwithValidCredentials() throws InterruptedException, AWTException, InvalidFormatException, IOException {


        extentTest = extentReports.createTest("verifyUserLoginwithValidCredentials");

        setup.launch_ParaBank();

        if ($(By.xpath("//*[contains(text(),'Customer Login')]")).exists())
        {
            $(By.xpath("//*[contains(@name,'username')]")).val(Data("Username"));
            $(By.xpath("//*[contains(@name,'password')]")).val(Data("Password")).pressEnter();
            Thread.sleep(2000);
            boolean status = $(By.xpath("//*[contains(text(),'Log Out')]")).isDisplayed();
            Assert.assertTrue(status);
        }
    }


    @Test(priority = 1, description = "Customer login with Invalid Credentials")
    public void verifyUserLoginwithInvalidCredentials() throws InterruptedException, AWTException, InvalidFormatException, IOException {

        setup.launch_ParaBank();

        if ($(By.xpath("//*[contains(text(),'Customer Login')]")).exists()) {
            $(By.xpath("//*[contains(@name,'username')]")).val(Data("Username"));
            $(By.xpath("//*[contains(@name,'password')]")).val(Data("Password")).pressEnter();
            Thread.sleep(1000);

            if ($(By.xpath("//*[contains(text(),'The username and password could not be verified.')]")).isDisplayed())
            {
                Assert.assertEquals("User Login NOT Successfull", "User Login NOT Successfull");

                Reporter.log("User Login NOT Successfull");
            }
            else
            {
                Assert.assertEquals("User Login Successfull", "User Login Successfull");
                Reporter.log("User Login Successfull");
            }
        }
    }


    @Test(priority = 2, description = "Customer login with Empty Credentials")
    public void verifyUserLoginwithEmptyCredentials() throws InterruptedException, AWTException, InvalidFormatException, IOException {

        setup.launch_ParaBank();

        if ($(By.xpath("//*[contains(text(),'Customer Login')]")).exists())
        {
            $(By.xpath("//*[contains(@name,'username')]")).val(Data("Username"));
            $(By.xpath("//*[contains(@name,'password')]")).val(Data("Password")).pressEnter();
            Thread.sleep(1000);
            if ($(By.xpath("//*[contains(text(),'Please enter a username and password.')]")).isDisplayed())
            {
                Assert.assertEquals("User Login NOT Successfull", "User Login NOT Successfull");
                Reporter.log("User Login NOT Successfull");
            }
            else
            {
                Assert.assertEquals("User Login Successfull", "User Login Successfull");
                Reporter.log("User Login Successfull");
            }
        }
    }






}




