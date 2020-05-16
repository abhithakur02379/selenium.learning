package selenium.learning;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Login {


    @Test
    public void Setup() throws InterruptedException {
        //System.out.println("Hello World");

        //WebDriver driver;

//        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("useAutomationExtension", false);
//        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
//
//        WebDriver driver = new ChromeDriver(options);
//        //WebDriverWait Wait = new WebDriverWait(driver,15);
//        driver.manage().window().maximize();
//        //Thread.sleep(2000);
//
//        driver.get("https://google.com");

        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "C:\\Tools\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(15000);
        driver.get("https://www.google.com/");
        



    }

}
