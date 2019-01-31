package basePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import sources.EmailAddress;
import sources.Highligher;
import sources.ScreenShot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

@Listeners(basePack.Listeners.class)

public class BaseClass {

    public static String site_name;
    public static String base_url;

    public static WebDriver driver;
    public static EmailAddress email;
    public static String email_id;
    public static ResourceBundle element;
    public static ResourceBundle property;
    public static ScreenShot print_screen;

    public static DateTimeFormatter date_time;
    public static LocalDateTime name;

    public static Highligher highlight;


    @Parameters({"site", "url"})
    @BeforeSuite(alwaysRun = true)
    public void openSetup(String site, String url) throws Exception {

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium WebDriver\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.site_name = site.toLowerCase();
        this.base_url = url;
        driver.get(this.base_url);

        date_time = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        name = LocalDateTime.now();

        print_screen = new ScreenShot();
        email = new EmailAddress();
        email.setEmail_id(date_time.format((name)) + "test@kmitsolutions.com");
        email_id = email.getEmail_id();

//        get Resources File
        element = ResourceBundle.getBundle(site.toUpperCase() + "\\" + site.toLowerCase() + "_elements");
        property = ResourceBundle.getBundle(site.toUpperCase() + "\\" + site.toLowerCase() + "_property");
    }


    //    @AfterSuite(alwaysRun = true)
    public void close_driver() {
        driver.quit();
    }
}
