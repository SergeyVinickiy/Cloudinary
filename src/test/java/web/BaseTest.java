package web;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import java.util.ResourceBundle;

public abstract class BaseTest {

    protected ResourceBundle testData;

    @BeforeClass
    public void setUpBrowser() {
        testData = ResourceBundle.getBundle("testData/data");
        Configuration.timeout = 40000;
    }
}
