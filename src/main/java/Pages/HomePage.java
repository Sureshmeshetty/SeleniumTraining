package Pages;

import Utils.BaseClass;
import Utils.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends CommonUtils{
    WebDriver driver;

    @FindBy(how=How.XPATH, using = "//a[text()='Documentation']")
    WebElement optionDocumentation;

    @FindBy(xpath = "//a[text()='Learn']")
    WebElement optionLearn;

    @FindBy(xpath = "//a[text()='Get Started']")
    WebElement getStartedButton;

    public HomePage(WebDriver driver){
        System.out.println("Home Page");
        this.driver = driver;
        PageFactory.initElements(driver,this);
        Assert.assertTrue(getStartedButton.isDisplayed());
    }

    public DocumentationPage navigateToDocumentation(){
        CommonUtils.safeClick(optionDocumentation);
        return new DocumentationPage(driver);
    }

    public LearnPage navigateToLearnPage(){
        optionLearn.click();
        return new LearnPage(driver);
    }


}
