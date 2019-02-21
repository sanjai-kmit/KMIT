package projects;

import basePack.BaseClass;
import basePack.CommonMethods;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Sign_In extends BaseClass{

    public void signin(String userName, String password) throws Exception{
        driver.get(base_url + element.getString("signin"));
        log.info("Navigated: to signin page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        check for Sign up page title
        String actual_page_title = driver.getTitle();
        String expected_page_title = property.getString("sign_in_page_title");
        try { Assert.assertEquals(actual_page_title, expected_page_title); }catch (Exception e){ log.error(e); }

//        Sign up field functionality
        CommonMethods method = new CommonMethods(driver);
        method.login_validation(userName, password);

        log.info("Tested: Sign In page functionality");
    }
}
