package selenium.learning;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Login {


    @Test
    public void Setup() throws InterruptedException {

        System.out.println("Test Started");

        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "C:\\Tools\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        Thread.sleep(15000);
        driver.get("https://www.google.com/");




        System.out.println("Test Ended");



    }

}
