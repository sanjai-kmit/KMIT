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

    CommonMethods commonMethods = new CommonMethods(driver);

    public void tickets() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<String> type_1 = new ArrayList<String>();
        type_1.add("yale");

        Thread.sleep(5000);

        log.info("Navigated: to Admission Page");
        List<String> calendar = new ArrayList<String>();
        calendar.add("erie");
//        WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element.getString("calendar"))));

        if (calendar.contains(site_name)) {
            commonMethods.select_calendar();
        }


        List<WebElement> counter_plus = driver.findElements(By.cssSelector(".counter-plus"));

//        to get the position of the .counter-plus button, to avoid to click on hidden buttons
        Random select = new Random();

        for (int i = 0; i <= counter_plus.size(); i++) {
            int j = select.nextInt(counter_plus.size());
            if (type_1.contains(site_name)) {
                if (j % 2 != 0) {
                    counter_plus.get(j).click();
                }
            } else {
                counter_plus.get(j).click();
            }
        }
        WebElement add_to_cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element.getString("add_to_cart"))));
        add_to_cart.click();

        log.info("Added to Card: General Admission");
    }
}
