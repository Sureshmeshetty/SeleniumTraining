package Pages;

import Utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LearnPage extends BaseClass {
    WebDriver driver;
    @FindBy(xpath = "//h1[text()='Learn BDD and Cucumber']")
    WebElement headerWomen;

    @FindBy(how= How.XPATH, using = "//a[text()='Documentation']")
    WebElement optionDocumentation;

    @FindBy(xpath = "//a[@class='navbar__brand']")
    WebElement homePageButton;

    public LearnPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        Assert.assertTrue(headerWomen.isDisplayed());
    }

    public HomePage goToHomePage(){
        homePageButton.click();
        return new HomePage(driver);
    }

    public DocumentationPage navigateToDocumentation(){
        optionDocumentation.click();
        return new DocumentationPage(driver);
    }
}
