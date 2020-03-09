package pages;

import com.codeborne.selenide.SelenideElement;
import report.ExtentTestManager;
import java.io.File;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MediaLibrary extends BaseWebPage{

    private SelenideElement uploadButton = $(byText("Upload"));
    private SelenideElement advancedButton = $(byCssSelector("button[data-test=\"btn-advanced\"]"));
    private SelenideElement publicIdInput = $(byCssSelector("input[data-test=public-id]"));
    private SelenideElement inputImage = $(byCssSelector("input[class=cloudinary_fileupload]"));
    private SelenideElement manageImageButton = $(byCssSelector("div[data-test=\"action-manage-btn\"]"));
    private SelenideElement deleteButton = $(byCssSelector("div[data-test=\"action-delete-btn\"]"));
    private SelenideElement approveDeleteButton = $(byCssSelector("button[data-test=\"confirm-dialog-confirm-btn\"]"));
    private SelenideElement frame = $(byCssSelector("iframe[data-test=\"uw-iframe\"]"));

    public void clickOnUploadButton(){
    ExtentTestManager.getTest().info("Clicking on \"Upload\" button");
    uploadButton.should(appear).click();
    }


    public void clickOnAdvancedButton(){
        ExtentTestManager.getTest().info("Clicking on \"Advanced\" button");
        advancedButton.should(appear).click();
    }

    public void setPublicId(String id){
        ExtentTestManager.getTest().info("Set public Id be: "+ id);
        publicIdInput.setValue(id);
    }

    public void uploadImage(File file){
        ExtentTestManager.getTest().info("Upload new image");
        inputImage.uploadFile(file);
    }

    public void validateImageExistByPublicId(String id){
        $(byCssSelector("div[data-test=asset-loader] img[alt=\""+id+"\"]")).shouldBe(visible);
        ExtentTestManager.getTest().info("Image with id: "+id+ " appear on screen");
    }

    public void rightClickOnImageByPublicId(String id){
        $(byCssSelector("div[data-test=asset-loader] img[alt=\""+id+"\"]")).should(appear).contextClick();
    }

    public void clickManageImageButton(){
        ExtentTestManager.getTest().info("Clicking on \"Manage\" button");
        manageImageButton.should(appear).click();
    }

    public void clickDeleteButton(){

        deleteButton.should(appear).click();
    }

    public void approveDeleteImage() {
        approveDeleteButton.should(appear).click();
    }

    public void waitTillFrameLoaded() {
        frame.should(appear);
    }
}
