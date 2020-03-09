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
/**
 * Test try to upload image and validate it appear on manage screen
 */

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
/**
 * @Test - upload Picture
 *
 * 1.Login to https://cloudinary.com/users/login
 * 2.Open Media Library tab
 * 3.Click on upload button (right upper conner)
 * 4.In ‘My Files’ tab - upload an image with public ID (public ID can be set in advanced box)
 * 5.Validate successful upload
 */

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

/**
 *  @Test validate Name In Manage Image Screen
 *
 *  6.Hover the uploaded image and click on ‘Manage’ button
 *  7.Validate the correct image (by public ID) displayed in manage page
 */

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
