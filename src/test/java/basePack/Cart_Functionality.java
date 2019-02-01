package basePack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class Cart_functionality extends BaseClass{

    public void go_to_cart(){

        driver.findElement(By.id(element.getString("cart"))).click();

        driver.findElement(By.id(element.getString("checkout"))).click();
    }
}
