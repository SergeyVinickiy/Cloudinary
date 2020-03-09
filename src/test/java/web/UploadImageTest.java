package web;

import org.testng.annotations.Test;
import pages.Dashboard;
import pages.Login;
import pages.ManageImage;
import pages.MediaLibrary;
import java.io.File;
import java.nio.file.Paths;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UploadImageTest extends BaseTest{

    private Login loginPage;
    private Dashboard dashboard;
    private MediaLibrary mediaLibrary;
    private ManageImage manageImage;
    private String publicId = "123";

    public UploadImageTest(){
        loginPage = new Login();
        dashboard = new Dashboard();
        mediaLibrary = new MediaLibrary();
        manageImage = new ManageImage();
    }

    @Test
    public void uploadPicture(){
        String pathToImage ="src/test/resources/testFiles/test_Image.jpg";

        loginPage.navigate();
        loginPage.signIn(testData.getString("sergey.email"), testData.getString("sergey.password"));

        dashboard.clickOnMediaLibraryButton();

        //Upload image with public id
        mediaLibrary.clickOnUploadButton();
        getWebDriver().switchTo().frame(0);
        mediaLibrary.clickOnAdvancedButton();
        mediaLibrary.setPublicId(publicId);
        File pngFile = Paths.get(pathToImage).toFile();
        mediaLibrary.uploadImage(pngFile);
        getWebDriver().switchTo().defaultContent();

        //Validate image appear
        mediaLibrary.validateImageExistByPublicId(publicId);
    }

    @Test
    public void validateNameInManageImageScreen(){
        loginPage.navigate();
        loginPage.signIn(testData.getString("sergey.email"), testData.getString("sergey.password"));

        dashboard.clickOnMediaLibraryButton();
        mediaLibrary.rightClickOnImageByPublicId(publicId);
        mediaLibrary.clickManageImageButton();

        //Validate image appear on ManageScreen
        manageImage.getItemTitle().shouldHave(value("123"));
        manageImage.closeManageScreen();

        //delete image after the test
        mediaLibrary.rightClickOnImageByPublicId(publicId);
        mediaLibrary.clickDeleteButton();
        mediaLibrary.approveDeleteImage();

    }

}
