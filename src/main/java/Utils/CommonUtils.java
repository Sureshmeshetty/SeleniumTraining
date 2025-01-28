package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CommonUtils extends BaseClass{

    static WebDriverWait wait;

    public static boolean isElementVisible(WebElement element){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Long.parseLong(getPropertyValue("simpleWait"))));
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isElementClickable(WebElement element){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Long.parseLong(getPropertyValue("simpleWait"))));
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isElementClickable(WebElement element,long duration){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(duration));
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public static boolean isElementInvisible(WebElement element,long duration){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(duration));
        try{
            wait.until(ExpectedConditions.invisibilityOf(element));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void safeClick(WebElement element){
        if(isElementVisible(element)) {
            if (isElementClickable(element))
                element.click();
            else
                Assert.fail(element.toString() + " is not clickable");
        }
        else
            Assert.fail(element.toString() + " is not visible");
    }

    public void SafeEdit(WebElement ele,String valueToEnter){

    }



}
