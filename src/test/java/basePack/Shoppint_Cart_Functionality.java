package basePack;

import org.openqa.selenium.By;

public class Shoppint_Cart_Functionality extends BaseClass{

//    Discount functions to be added


    public  void check_out()throws Exception{
        Thread.sleep(2000);
        driver.navigate().to(base_url + element.getString("shoppingCart"));
        log.info("Navigated: to shoppingCart page");
    }
}
