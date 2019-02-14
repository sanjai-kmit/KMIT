package projects;

import basePack.*;

import java.util.concurrent.TimeUnit;

public class Tickets extends BaseClass {

    public void tickets() throws Exception {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(base_url + element.getString("ticket"));

        Tickets_Functionality tickets = new Tickets_Functionality();
        tickets.tickets();

        Thread.sleep(2000);

        Cart_Functionality cart = new Cart_Functionality();
        cart.go_to_cart();

        Thread.sleep(2000);

        Shoppint_Cart_Functionality checkout = new Shoppint_Cart_Functionality();
        checkout.check_out();

        Thread.sleep(2000);

        Billing_Info_Functionality billing = new Billing_Info_Functionality();
        billing.billing_info();
    }

}
