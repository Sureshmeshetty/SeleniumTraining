package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {


    static private WebDriver driver;
    static public Properties prop;

    public static WebDriver getDriver() {
        return driver;
    }

    void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeSuite
    @Parameters("browser")
    public void setUp(String browserName){
        //Initialize the driver
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                Assert.fail("Invalid Browser. Please check the browser name");
                break;
        }
        String url = getPropertyValue("applicationURL");
        System.out.println(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Launch Application
        driver.get(url);
    }

    public static String getPropertyValue(String key){
        prop = new Properties();
        if(key!=null){
            try {
                prop.load(new FileInputStream("src/test/resources/Properties/testData.properties"));
                System.out.println(prop);
                String value =  prop.getProperty(key);
                System.out.println(key+" : "+value);
                return value;
            } catch (IOException e) {
                Assert.fail("Properties File is not found");
                return null;
            }
        }
        else
            return null;
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
