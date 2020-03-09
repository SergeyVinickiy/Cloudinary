package pages;

import java.util.ResourceBundle;

/**
 * BaseWebPage will be base class for all pages
 * Initialise properties file and main methods
 *
 */

public class BaseWebPage {
    private String cloudinaryUrl;


    public BaseWebPage() {
        ResourceBundle testData = ResourceBundle.getBundle("testData/data");
        this.cloudinaryUrl = testData.getString("cloudinary.url");
    }

    public String getCloudinaryUrl(){
        return cloudinaryUrl;
    }
}
