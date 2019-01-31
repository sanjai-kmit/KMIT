package basePack;

import org.testng.annotations.Test;
import projects.Home;
import projects.Sign_In;
import projects.Sign_Up;
import org.testng.annotations.Listeners;
import projects.Tickets;

@Listeners(basePack.Listeners.class)

public class MainClass {

    private Sign_In signin = new Sign_In();
    private Sign_Up signup = new Sign_Up();
    private Tickets ticket = new Tickets();

    @Test(groups = {"test.home"})
    public void test_home() {
        Home home = new Home();
        home.home_page();
    }

    @Test(groups = {"test.sign_in"}, parameters = {"userName", "password"})
    public void test_sign_in(String userName, String password) throws Exception {
        signin.signin(userName, password);
    }

    @Test(groups = {"test.sign_up"})
    public void test_sign_up() throws Exception {
        signup.signup();
    }

    @Test(groups = {"test.tickets"})
    public void test_tickets() throws Exception {
        ticket.tickets();
    }
}
