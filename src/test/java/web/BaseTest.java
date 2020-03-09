package web;

/**
 * BaseTest will be base class for all test classes with main configuration
 *
 *
 **/

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import java.util.ResourceBundle;

public abstract class BaseTest {

    protected ResourceBundle testData;

    @BeforeClass
    public void setUpBrowser() {
        testData = ResourceBundle.getBundle("testData/data");
        //Selenide configuration
        Configuration.timeout = 40000;
    }
}
