package basePack;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import sources.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

@Listeners(basePack.Listeners.class)

public class BaseClass extends DB_Connections{

    public static String site_name;
    public static String base_url;
    public static String user;
    public static String send_to;

    public static WebDriver driver;
    public static EmailAddress email;
    public static String email_id;
    public static ResourceBundle element;
    public static ResourceBundle property;
    public static ScreenShot print_screen;

    public static String customerType;

    public static DateTimeFormatter date_time;
    public static LocalDateTime name;

    public static Highligher highlight;

    public static CreateResult result = new CreateResult();

    String username = System.getProperty("user.name");

//    for access log file;
    public static Logger log = Logger.getLogger(BaseClass.class.getName());




//    this is to open the driver to start the test
    @Parameters({"site", "url", "user", "to_email", "E_comm_server", "E_comm_port", "E_comm_data_base_name", "E_comm_userName", "E_comm_password"})
    @BeforeSuite(alwaysRun = true)
    public void openSetup(String site, String url, String user, String to_email, String E_comm_server, String E_comm_port, String E_comm_data_base_name, String E_comm_userName, String E_comm_password) throws Exception {

        DOMConfigurator.configure("src\\log4j.xml");

//        for Data Base connection
        try {
            DB_Connections db_conn = new DB_Connections();
            db_conn.e_comm_connection(E_comm_server, E_comm_port, E_comm_data_base_name, E_comm_userName, E_comm_password);
            log.info("Data Base connection completed");
        } catch (Throwable t){
            log.error("Issue on Data Base Connection: " + t);
        }



//        get Resources File
        element = ResourceBundle.getBundle(site.toUpperCase() + "\\" + site.toLowerCase() + "_elements");
        property = ResourceBundle.getBundle(site.toUpperCase() + "\\" + site.toLowerCase() + "_property");

//        get the current date and time to create random email id
        date_time = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        name = LocalDateTime.now();

//        create an object to get the email id / refer -> D:\gradleProject\workfolder\KMIT\src\main\java\sources\EmailAddress.java
        email = new EmailAddress();
        email.setEmail_id(date_time.format((name)) + "automationEmail@kmitsolutions.com");
        email_id = email.getEmail_id();

//        create an object to get the screenshot method / refer -> D:\gradleProject\workfolder\KMIT\src\main\java\sources\ScreenShot.java
        print_screen = new ScreenShot();

//      set the driver (browser) path
        System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getAbsolutePath());

//        open & maximize the driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        log.info("Driver open got success");

//        get the site name and url
        this.site_name = site.toLowerCase();
        log.info("Site to Test: " + site_name);

        this.base_url = url;
        log.info("Url used for Testing: " + base_url);

        this.user = user.toLowerCase();
        log.info("Testing with " + user + " user");

        this.send_to = to_email;

//        pass the url to the driver
        driver.get(this.base_url);

    }


//    this is to close the driver after test completes
        @AfterSuite(alwaysRun = true)
    public void close_driver()throws Exception{
        result.create_mail(username, site_name, base_url, send_to);
        connection.close();
        driver.quit();
    }
}
