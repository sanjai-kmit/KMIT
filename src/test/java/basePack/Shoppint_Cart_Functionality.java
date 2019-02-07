package basePack;

import org.openqa.selenium.By;

public class Shoppint_Cart_Functionality extends BaseClass{

//    Discount functions to be added


    public  void check_out()throws Exception{
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(element.getString("shopping_cart_checkout"))).click();
    }
}
