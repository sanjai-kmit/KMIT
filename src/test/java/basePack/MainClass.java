package basePack;

import data_base.E_Comm_DB;
import org.testng.annotations.Test;
import projects.Home;
import projects.Sign_In;
import projects.Sign_Up;
import org.testng.annotations.Listeners;
import projects.Tickets;
import sources.DB_Connections;

@Listeners(basePack.Listeners.class)

public class MainClass extends BaseClass{

    private Sign_In signin = new Sign_In();
    private Sign_Up signup = new Sign_Up();
    private Tickets ticket = new Tickets();
    private E_Comm_DB e_comm_db = new E_Comm_DB();

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
        e_comm_db.aspNetUsers(email_id);
    }

    @Test(groups = {"test.tickets"}, parameters = {"userName", "password"})
    public void test_tickets(String userName, String password) throws Exception {

        if (user.equals("new")){
            signup.signup();
        } else if (user.equals("exist")){
            signin.signin(userName, password);
        }

        Thread.sleep(1000);

        ticket.tickets();
    }
}
