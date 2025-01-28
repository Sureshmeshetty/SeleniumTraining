import Pages.HomePage;
import Pages.DocumentationPage;
import Pages.LearnPage;
import Utils.BaseClass;
import org.testng.annotations.Test;

public class MyTest extends BaseClass {
    HomePage homePage;
    DocumentationPage documentationPage;
    LearnPage learnPage;

    @Test
    public void checkNavigations(){
        homePage = new HomePage(getDriver());
        documentationPage = homePage.navigateToDocumentation();
        homePage = documentationPage.goToHomePage();
        learnPage = homePage.navigateToLearnPage();
        documentationPage = learnPage.navigateToDocumentation();
        homePage=documentationPage.goToHomePage();

    }
}
