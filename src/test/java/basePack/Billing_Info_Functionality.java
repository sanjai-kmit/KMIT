package basePack;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Billing_Info_Functionality extends BaseClass{

    public void billing_info(){

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        if (driver.findElement(By.className(element.getString("pencil"))).isEnabled()){
            driver.findElement(By.cssSelector(element.getString("pay_now"))).click();
            System.out.println("inside: " + this.getClass());
        } else {
            System.out.println("Edit the fields");
        }
    }
}
