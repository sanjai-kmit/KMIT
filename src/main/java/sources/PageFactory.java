package sources;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactory {

    @FindBy(name = "firstName")
    public static WebElement firstname;

    @FindBy(name = "lastName")
    public static WebElement lastName;
}
