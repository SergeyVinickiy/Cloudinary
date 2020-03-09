package pages;

import report.ExtentTestManager;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Login extends BaseWebPage{

    private String emailPath = "user_session[email]";
    private String passwordPath = "user_session[password]";
    private String signInButton = "sign in";


    public void navigate() {
        ExtentTestManager.getTest().info("Go to Cloudinary");
        open(getCloudinaryUrl() + "/users/login");
    }

    public void signIn(String userName, String password){
        ExtentTestManager.getTest().info("Signing in with user: "+ userName+ ", Password: " + password);
        $(byName(emailPath)).setValue(userName);
        $(byName(passwordPath)).setValue(password);
        $(byText(signInButton)).click();
    }
}
