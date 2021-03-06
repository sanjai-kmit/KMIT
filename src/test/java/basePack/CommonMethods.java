package basePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends BaseClass{

    WebDriver driver;

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(name = "phoneNumber")
    WebElement phoneNumber;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "address")
    WebElement address;

    @FindBy(name = "City")
    WebElement city;

    @FindBy(name = "ZIPCODE")
    WebElement zipcode;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(name = "customerCode")
    WebElement customerCode;

//    for login page fields
    @FindBy(name = "userName")
    WebElement user_name;


    public CommonMethods(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
     * below
     * is
     * for
     * Sign Up page
     */

//    for firstname
    public void firstName() throws Exception{

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Validate for empty field
        firstName.clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("firstName_error"))).getText().toLowerCase(), property.getString("firstName_error").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, firstName);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }
        firstName.clear();
        firstName.sendKeys(property.getString("firstName"));

        log.info("Tested: First Name field - given value is: " + property.getString("firstName"));
    }

//    for lastname
    public void lastName() throws Exception{

    //Validate for empty field
        lastName.clear();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("lastName_error"))).getText().toLowerCase(), property.getString("lastName_error").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, lastName);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }
        lastName.clear();
        lastName.sendKeys(property.getString("lastName"));

        log.info("Tested: Last Name field - given value is: " + property.getString("lastName"));
    }

//    for phoneNumber
    public void phoneNumber() throws Exception{

            phoneNumber.clear();
            phoneNumber.sendKeys("123456789");
            driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

            try {
                Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("phoneNumber_error"))).getText().toLowerCase(), property.getString("phonNumber_error").toLowerCase());
            }catch (Throwable t){
                log.error(t);
            highlight.highLightElement(driver, phoneNumber);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }
        phoneNumber.clear();
        phoneNumber.sendKeys(property.getString("phoneNumber"));

        log.info("Tested: Phone Number field - given value is: " + property.getString("phoneNumber"));
    }


//    for email
    public void email() throws  Exception{
        email.clear();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("email_error_empty"))).getText().toLowerCase(), property.getString("email_error_empty").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, email);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        email.sendKeys("test");
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("email_error_invalid"))).getText().toLowerCase(), property.getString("email_error_invalid").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, email);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }
        email.clear();
        email.sendKeys(email_id);

        log.info("Tested: Email field - given value is: " + email_id);
    }

//    for address
    public void address(){
        address.clear();
        address.sendKeys(property.getString("addressLine_1"));

        log.info("Tested: Address field - given value is: " + property.getString("addressLine_1"));
    }

//    for city
    public void city(){
        city.clear();
        city.sendKeys(property.getString("city"));

        log.info("Tested: City field - given value is: " + property.getString("city"));
    }

//    for zipcode
    public void zipCode() throws Exception{
        zipcode.clear();
        zipcode.sendKeys("1");
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("zipcode_error"))).getText().toLowerCase(), property.getString("zipcode_error").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, zipcode);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }
        zipcode.clear();
        zipcode.sendKeys(property.getString("zipcode"));

        log.info("Tested: Zipcode field - given value is: " + property.getString("zipcode"));
    }

// for password
    public void password_confirmPassword() throws Exception{
//  validation for empty field
        password.clear();
        confirmPassword.clear();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("password_error"))).getText().toLowerCase(), property.getString("password_error").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, password);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("confirmPassword_error"))).getText().toLowerCase(), property.getString("confirmPassword_error").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, confirmPassword);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }


//   validation for invalid password
        String j = "s";
        for (int i = 2; i < 6; i++){
            password.clear();
            confirmPassword.clear();
            password.sendKeys(j);
            confirmPassword.sendKeys(j);
            j += Integer.toString(i);

            driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

            if (i == 2) {
                Thread.sleep(2000);
            }
            try {
                Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("password_limit_error"))).getText().toLowerCase(), property.getString("password_limit_error").toLowerCase());
            }catch (Throwable t){
                log.error(t);
                highlight.highLightElement(driver, password);
                print_screen.takeScreenShot(driver, date_time.format(name));
            }
        }

        password.clear();
        confirmPassword.clear();

//        validation for password not match
        password.sendKeys("01234567");
        confirmPassword.sendKeys("987654321");
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("password_not_match_error"))).getText().toLowerCase(), property.getString("password_not_match_error").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, password);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        password.clear();
        confirmPassword.clear();

        password.sendKeys(property.getString("password"));
        log.info("Tested: Password field - given value is: " + property.getString("password"));

        confirmPassword.sendKeys(property.getString("confirmPassword"));
        log.info("Tested: Confirm Password field - given value is: " + property.getString("confirmPassword"));

        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        Thread.sleep(10000);
    }

    /*
    * below
    * is
    * for
    * login page
    */

    public void login_validation(String userName, String userPassword) throws Exception{

//        for empty user name and password field
        user_name.clear();
        password.clear();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_name_empty_error"))).getText().toLowerCase(), property.getString("user_name_empty_error").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, user_name);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_password_empty_error"))).getText().toLowerCase(), property.getString("user_password_empty_error").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, password);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        user_name.clear();
        password.clear();

//        for invalid password
        user_name.sendKeys("sanjaim@kmitsolutions.com");
        password.sendKeys("12587865");

        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        Thread.sleep(2000);

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_invalid_error"))).getText().toLowerCase(), property.getString("user_password_invalid_error").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, password);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        user_name.clear();
        password.clear();

//        for invalid user
        user_name.sendKeys("testemailid@kmitsolutions.com");
        password.sendKeys("12587865");

        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        Thread.sleep(2000);

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_invalid_error"))).getText().toLowerCase(), property.getString("user_name_invalid_error").toLowerCase());
        }catch (Throwable t){
            log.error(t);
            highlight.highLightElement(driver, user_name);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        user_name.clear();
        user_name.sendKeys(userName);
        log.info("Tested: User Name field - given value is: " + userName);

        password.clear();
        password.sendKeys(userPassword);
        log.info("Tested: Password Field - given value is: " + userPassword);

        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        Thread.sleep(2000);
    }

//    for calendar
    public void select_calendar()throws Exception{
        driver.findElement(By.cssSelector(element.getString("calendar"))).click();

        SimpleDateFormat format_date = new SimpleDateFormat("dd");
        SimpleDateFormat formate_month = new SimpleDateFormat("MM");
        SimpleDateFormat formate_year = new SimpleDateFormat("yyyy");
        Date date = new Date();

        String to_date = format_date.format(date);
        int current_date = Integer.parseInt(to_date);

        String to_month = formate_month.format(date);
        int current_month = Integer.parseInt(to_month);

        String to_year = formate_year.format(date);
        int current_year = Integer.parseInt(to_year);

/*        System.out.println("current_date: " + current_date);
        System.out.println("current_month: " + current_month);
        System.out.println("current_year: " + current_year);*/

        int numDays = 0;

        switch (current_month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                if (current_year % 4 == 0){
                    numDays = 29;
                } else if(!(current_year % 4 == 0)){
                    numDays = 28;
                }

        }

        List<WebElement> event_available = driver.findElements(By.cssSelector(element.getString("event_available")));
        int no_of_event_available = event_available.size();

//        System.out.println("numDays: " + numDays);

        Random random = new Random();

        int min_date = current_date;
        int max_date = numDays;
        int select = random.nextInt(max_date - min_date) + min_date;

//        System.out.println("select: " + select);

//        String select_date = Integer.toString(select);

//        driver.findElement(By.linkText(select_date)).click();
        int event = (select - no_of_event_available) + 1;
/*        System.out.println("no_of_event_available: " + no_of_event_available);
        System.out.println("event: " + event);*/
        for (int i = event; i == event; i++){
            event_available.get(i).click();
        }

        log.info("Ticket: Date selected for : " + current_year + "-" + current_month + "-" + current_date);
        Thread.sleep(2000);


//        *********

//        below is to get the day of the date
/*        String dateString = String.format("%d-%d-%d", current_date, current_month, current_year);
        Date date1 = new SimpleDateFormat("d-M-yyyy").parse(dateString);

        String current_day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date1);
        System.out.println("current_day: " + current_day);*/


//        *********

    }
}
