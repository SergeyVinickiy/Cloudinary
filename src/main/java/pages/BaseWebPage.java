package pages;

import java.util.ResourceBundle;

public class BaseWebPage {
    private String cloudeneryUrl;


    public BaseWebPage() {
        ResourceBundle testData = ResourceBundle.getBundle("testData/data");
        this.cloudeneryUrl = testData.getString("cloudinary.url");
    }

    public String getCloudinaryUrl(){
        return cloudeneryUrl;
    }
}
