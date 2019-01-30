package projects;

import basePack.BaseClass;
import basePack.CommonMethods;
import org.testng.Assert;

public class Sign_Up extends BaseClass {


    public void signup() throws Exception{

        driver.navigate().to(base_url + element.getString("signup"));

//        check for Sign up page title
/*        String actual_page_title = driver.getTitle();
        String expected_page_title = property.getString("sign_up_page_title");*/
        try {
            Assert.assertEquals(driver.getTitle(), property.getString("sign_up_page_title"));
        }catch (Exception e){
            System.out.println(e);
        }

//        Sign up field functionality
        CommonMethods method = new CommonMethods(driver);

        if (site_name.equals("erie")) {
            method.firstName();
            method.lastName();
            method.phoneNumber();
            method.email();
            method.address();
            method.city();
            method.zipCode();
            method.password_confirmPassword();
        }else if (site_name.equals("cwma")){
            method.firstName();
            method.lastName();
            method.phoneNumber();
            method.email();
            method.password_confirmPassword();
        }
    }
}
