package pages;

import com.codeborne.selenide.SelenideElement;
import report.ExtentTestManager;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Dashboard extends BaseWebPage{

    private SelenideElement mediaLibraryButton= $(byText("Media Library"));

    public void clickOnMediaLibraryButton(){
        ExtentTestManager.getTest().info("Click on Media Library button");
        mediaLibraryButton.should(appear).click();
    }

}
