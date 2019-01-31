package basePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tickets_Functionality extends BaseClass {


    public void tickets() throws Exception {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<String> type_1 = new ArrayList<String>();
        type_1.add("yale");

        Thread.sleep(2000);

        List<WebElement> counter_plus = driver.findElements(By.cssSelector(".counter-plus"));

        Random select = new Random();

        for (int i = 0; i <= counter_plus.size(); i++) {
            int j = select.nextInt(counter_plus.size());
            if (type_1.contains(site_name)) {
                if (j % 2 != 0) {
                    counter_plus.get(j).click();
                }
            }
        }

        driver.findElement(By.id(element.getString("add_to_cart"))).click();


    }
}
