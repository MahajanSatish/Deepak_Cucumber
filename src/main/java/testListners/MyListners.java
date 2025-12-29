package testListners;

import org.testng.ITestResult;

public class MyListners {


    
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
       
    }

   
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }
}
