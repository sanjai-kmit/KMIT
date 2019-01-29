package projects;

import basePack.BaseClass;
import basePack.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Sign_In extends BaseClass{

    public void signin(String userName, String password) throws Exception{
        driver.get(base_url + element.getString("signin"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        check for Sign up page title
        String actual_page_title = driver.getTitle();
        String expected_page_title = property.getString("sign_in_page_title");
        try {
            Assert.assertEquals(actual_page_title, expected_page_title);
        }catch (Exception e){
            System.out.println(e);
        }

//        Sign up field functionality
        CommonMethods method = new CommonMethods(driver);

        method.login_validation(userName, password);


    }
}
