package basePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import sources.*;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

@Listeners(basePack.Listeners.class)

public class BaseClass {

    public static String site_name;
    public static String base_url;
    public static String user;

    public static WebDriver driver;
    public static EmailAddress email;
    public static String email_id;
    public static ResourceBundle element;
    public static ResourceBundle property;
    public static ScreenShot print_screen;

    public static DateTimeFormatter date_time;
    public static LocalDateTime name;

    public static Highligher highlight;

    public static CreateResult result = new CreateResult();

    String username = System.getProperty("user.name");


//    this is to open the driver to start the test
    @Parameters({"site", "url", "user"})
    @BeforeSuite(alwaysRun = true)
    public void openSetup(String site, String url, String user) throws Exception {


        date_time = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        name = LocalDateTime.now();

//      set the driver (browser) path
        System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getAbsolutePath());

//        open & maximize the driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

//        get the site name and url
        this.site_name = site.toLowerCase();
        this.base_url = url;
        this.user = user.toLowerCase();

//        pass the url to the driver
        driver.get(this.base_url);

//        create an object to get the screenshot method / refer -> D:\gradleProject\workfolder\KMIT\src\main\java\sources\ScreenShot.java
        print_screen = new ScreenShot();

//        create an object to get the email id / refer -> D:\gradleProject\workfolder\KMIT\src\main\java\sources\EmailAddress.java
        email = new EmailAddress();
        email.setEmail_id(date_time.format((name)) + "test@kmitsolutions.com");
        email_id = email.getEmail_id();

//        get Resources File
        element = ResourceBundle.getBundle(site.toUpperCase() + "\\" + site.toLowerCase() + "_elements");
        property = ResourceBundle.getBundle(site.toUpperCase() + "\\" + site.toLowerCase() + "_property");
    }


//    this is to close the driver after test completes
        @AfterSuite(alwaysRun = true)
    public void close_driver()throws Exception{
        result.create_mail(username, site_name, base_url);
        driver.quit();
    }
}
