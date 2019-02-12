package basePack;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Cart_Functionality extends BaseClass{

    public void go_to_cart() throws Exception {
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.findElement(By.id(element.getString("cart"))).click();
        Thread.sleep(2000);
        driver.findElement(By.id(element.getString("checkout"))).click();
    }
}
