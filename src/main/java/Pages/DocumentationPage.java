package Pages;

import Utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DocumentationPage extends BaseClass {
    WebDriver driver;
    @FindBy(xpath = "//h1[text()='Introduction']")
    WebElement headerIntroduction;

    @FindBy(xpath = "//a[@class='navbar__brand']")
    WebElement homePageButton;

    @FindBy(xpath = "//a[text()='Guides']")
    WebElement guideLink;

    @FindBy(xpath = "//h2[@title='API automation']")
    WebElement apiAutomatonSubHeader;

    public DocumentationPage(WebDriver driver) {

        System.out.println("Documentation Page");
        this.driver = driver;
        PageFactory.initElements(driver,this);
        Assert.assertTrue(headerIntroduction.isDisplayed());
    }

    public  void navigateToGuide(){
        guideLink.click();
        Assert.assertTrue(apiAutomatonSubHeader.isDisplayed());
    }

    public HomePage goToHomePage(){
        homePageButton.click();
        return new HomePage(driver);
    }
}
