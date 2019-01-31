package projects;

import basePack.BaseClass;
import basePack.Cart_functionality;
import basePack.Tickets_Functionality;

public class Tickets extends BaseClass {

    public void tickets() throws Exception {

        driver.navigate().to(base_url + element.getString("ticket"));

        Tickets_Functionality tickets = new Tickets_Functionality();
        tickets.tickets();

        Cart_functionality cart = new Cart_functionality();
        cart.go_to_cart();
    }

}
