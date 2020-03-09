package pages;

import com.codeborne.selenide.SelenideElement;
import report.ExtentTestManager;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class ManageImage extends BaseWebPage{
    private SelenideElement itemTitle = $(byCssSelector("input[data-test=\"item-title\"]"));
    private SelenideElement closeManageScreenButton = $(byCssSelector("button[data-test=\"back-arrow-button\"]"));

    public SelenideElement getItemTitle(){
       return itemTitle;
    }

    public void closeManageScreen(){
        ExtentTestManager.getTest().info("Closing manage screen");
        closeManageScreenButton.shouldBe(visible).click();
    }
}
