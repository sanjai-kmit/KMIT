package projects;

import basePack.BaseClass;
import org.testng.Assert;

public class Home extends BaseClass {

    public void home_page(){
        String page_title = driver.getTitle();

        try { Assert.assertEquals(page_title, property.getString("home_title")); }catch (Throwable t){ t.printStackTrace(); }
    }
}
