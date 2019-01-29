package sources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenShot {

    public static void takeScreenShot(WebDriver driver, String name) throws Exception{
        File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String username = System.getProperty("user.name");
        File directory_path = new File("C:\\Users\\" + username + "\\Desktop\\Selenium_images");

        if (!directory_path.exists()){
            new File("C:\\Users\\" + username + "\\Desktop\\Selenium_images").mkdirs();
        }

        FileUtils.copyFile(screenshotfile, new File(directory_path + "\\" + name + ".png"));
    }
}
