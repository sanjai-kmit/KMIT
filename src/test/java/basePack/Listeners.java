package basePack;

import org.testng.*;
import sources.ScreenShot;

public class Listeners implements ITestListener, ISuiteListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("\nName of the testcase started: " + result.getName() + "\n");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("\nName of the testcase got success: " + result.getName() + "\n");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("\nThe name of the testcase failed is: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("\nThe name of the testcase skipped is: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("\nAbout to begin executing Suite: " + suite.getName() + "\n");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("\nAbout to end executing Suite: " + suite.getName() + "\n");
    }

//    ****
}
