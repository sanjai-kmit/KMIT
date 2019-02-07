package basePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CommonMethods extends BaseClass{

    WebDriver driver;

    @FindBy(name = "firstName")
    WebElement firstName;

/*    @FindBy(css = "div.signup-form:nth-child(1) > div:nth-child(2) > span:nth-child(2) > span:nth-child(1)")
    WebElement firstName_error;*/

    @FindBy(name = "lastName")
    WebElement lastName;
/*
    @FindBy(css = ".login-panel > div:nth-child(2) > div:nth-child(2) > span:nth-child(2) > span:nth-child(1)")
    WebElement lastName_error;*/

    @FindBy(name = "phoneNumber")
    WebElement phoneNumber;

/*    @FindBy(css = "div.col-md-6:nth-child(3) > div:nth-child(2) > span:nth-child(2) > span:nth-child(1)")
    WebElement phoneNumber_error;*/

    @FindBy(name = "email")
    WebElement email;

/*    @FindBy(css = "div.col-md-6:nth-child(4) > div:nth-child(2) > span:nth-child(2) > span:nth-child(1)")
    WebElement email_error_empty;

    @FindBy(css = "div.col-md-6:nth-child(4) > div:nth-child(2) > span:nth-child(2) > span:nth-child(2)")
    WebElement email_error_invalid;*/

    @FindBy(name = "address")
    WebElement address;

    @FindBy(name = "City")
    WebElement city;

    @FindBy(name = "ZIPCODE")
    WebElement zipcode;

/*    @FindBy(css = "div.col-md-6:nth-child(9) > div:nth-child(2) > span:nth-child(2) > span:nth-child(1)")
    WebElement zipcode_error;*/

    @FindBy(name = "password")
    WebElement password;

/*    @FindBy(css = "div.col-md-6:nth-child(10) > div:nth-child(2) > span:nth-child(2) > span:nth-child(1)")
    WebElement password_error;*/

    @FindBy(name = "confirmPassword")
    WebElement confirmPassword;

/*    @FindBy(css = "div.col-md-6:nth-child(11) > div:nth-child(2) > span:nth-child(2) > span:nth-child(1)")
    WebElement confirmPassword_error;

    @FindBy(className = "alert")
    WebElement password_limit_error;

    @FindBy(css = "div.col-md-6:nth-child(11) > div:nth-child(2) > span:nth-child(2) > span:nth-child(3)")
    WebElement password_not_match_error;*/

    @FindBy(name = "customerCode")
    WebElement customerCode;

//    @FindBy(css = "button.margin-t5p")
//    WebElement create_btn;

//    for login page fields
    @FindBy(name = "userName")
    WebElement user_name;

/*    @FindBy(css = ".loginView-panel > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2) > span:nth-child(1)")
    WebElement user_name_empty_error;

    @FindBy(css = ".loginView-panel > div:nth-child(2)")
    WebElement user_invalid_error;

    @FindBy(css = "span.col-sm-12 > span:nth-child(1)")
    WebElement user_password_empty_error;*/

/*    @FindBy(css = "div.padding-l-r-0:nth-child(4) > button:nth-child(1)")
    WebElement login_btn;*/


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
//        create_btn.click();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
//            Assert.assertEquals(firstName_error.getText(), property.getString("firstName_error").toUpperCase());
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("firstName_error"))).getText().toLowerCase(), property.getString("firstName_error").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, firstName);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }
        firstName.clear();
        firstName.sendKeys(property.getString("firstName"));
    }

//    for lastname
    public void lastName() throws Exception{

    //Validate for empty field
        lastName.clear();
//        create_btn.click();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
//            Assert.assertEquals(lastName_error.getText(), property.getString("lastName_error").toUpperCase());
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("lastName_error"))).getText().toLowerCase(), property.getString("lastName_error").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, lastName);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }
        lastName.clear();
        lastName.sendKeys(property.getString("lastName"));
    }

//    for phoneNumber
    public void phoneNumber() throws Exception{

            phoneNumber.clear();
            phoneNumber.sendKeys("123456789");
//        create_btn.click();
            driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

            try {
//            Assert.assertEquals(phoneNumber_error.getText(), property.getString("phonNumber_error").toUpperCase());
                Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("phoneNumber_error"))).getText().toLowerCase(), property.getString("phonNumber_error").toLowerCase());
            }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, phoneNumber);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }
        phoneNumber.clear();
        phoneNumber.sendKeys(property.getString("phoneNumber"));
    }


//    for email
    public void email() throws  Exception{
        email.clear();
//        create_btn.click();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
//            Assert.assertEquals(email_error_empty.getText(), property.getString("email_error_empty").toUpperCase());
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("email_error_empty"))).getText().toLowerCase(), property.getString("email_error_empty").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, email);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        email.sendKeys("test");
//        create_btn.click();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
//            Assert.assertEquals(email_error_invalid.getText(), property.getString("email_error_invalid").toUpperCase());
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("email_error_invalid"))).getText().toLowerCase(), property.getString("email_error_invalid").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, email);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }
        email.clear();
        email.sendKeys(email_id);
        System.out.println("Email Id used for Registration is: " + email_id);
    }

//    for address
    public void address(){
        address.clear();
        address.sendKeys(property.getString("addressLine_1"));
    }

//    for city
    public void city(){
        city.clear();
        city.sendKeys(property.getString("city"));
    }

//    for zipcode
    public void zipCode() throws Exception{
        zipcode.clear();
        zipcode.sendKeys("1");
//        create_btn.click();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
//            Assert.assertEquals(zipcode_error.getText(), property.getString("zipcode_error").toUpperCase());
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("zipcode_error"))).getText().toLowerCase(), property.getString("zipcode_error").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, zipcode);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }
        zipcode.clear();
        zipcode.sendKeys(property.getString("zipcode"));
    }

// for password
    public void password_confirmPassword() throws Exception{
//  validation for empty field
        password.clear();
        confirmPassword.clear();
//        create_btn.click();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
//            Assert.assertEquals(password_error.getText(), property.getString("password_error").toUpperCase());
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("password_error"))).getText().toLowerCase(), property.getString("password_error").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, password);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        try {
//            Assert.assertEquals(confirmPassword_error.getText(), property.getString("confirmPassword_error").toUpperCase());
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("confirmPassword_error"))).getText().toLowerCase(), property.getString("confirmPassword_error").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
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
//            create_btn.click();
            driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

            if (i == 2) {
                Thread.sleep(2000);
            }
            try {
//                Assert.assertEquals(password_limit_error.getText(), property.getString("password_limit_error"));
                Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("password_limit_error"))).getText().toLowerCase(), property.getString("password_limit_error").toLowerCase());
            }catch (Throwable t){
                t.printStackTrace();
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
//            Assert.assertEquals(password_not_match_error.getText(), property.getString("password_not_match_error").toUpperCase());
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("password_not_match_error"))).getText().toLowerCase(), property.getString("password_not_match_error").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, password);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        password.clear();
        confirmPassword.clear();
        password.sendKeys(property.getString("password"));
        confirmPassword.sendKeys(property.getString("confirmPassword"));
//        create_btn.click();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

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
//        login_btn.click();
        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        try {
//            Assert.assertEquals(user_name_empty_error.getText(), property.getString("user_name_empty_error").toUpperCase());
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_name_empty_error"))).getText().toLowerCase(), property.getString("user_name_empty_error").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, user_name);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        try {
//            Assert.assertEquals(user_password_empty_error.getText(), property.getString("user_password_empty_error").toUpperCase());
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_password_empty_error"))).getText().toLowerCase(), property.getString("user_password_empty_error").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, password);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        user_name.clear();
        password.clear();

//        for invalid password
        user_name.sendKeys("sanjaim@kmitsolutions.com");
        password.sendKeys("12587865");
//        login_btn.click();
        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        Thread.sleep(2000);

        try {
//            Assert.assertEquals(user_invalid_error.getText(), property.getString("user_password_invalid_error"));
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_invalid_error"))).getText().toLowerCase(), property.getString("user_password_invalid_error").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, password);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        user_name.clear();
        password.clear();

//        for invalid user
        user_name.sendKeys("testemailid@kmitsolutions.com");
        password.sendKeys("12587865");
//        login_btn.click();
        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        Thread.sleep(2000);

        try {
//            Assert.assertEquals(user_invalid_error.getText(), property.getString("user_name_invalid_error"));
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_invalid_error"))).getText().toLowerCase(), property.getString("user_name_invalid_error").toLowerCase());
        }catch (Throwable t){
            t.printStackTrace();
            highlight.highLightElement(driver, user_name);
            print_screen.takeScreenShot(driver, date_time.format(name));
        }

        user_name.clear();
        user_name.sendKeys(userName);
        password.clear();
        password.sendKeys(userPassword);
//        login_btn.click();
        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        Thread.sleep(2000);
    }
}
