package ListenerPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClass implements ITestListener
{
  
    private ExtentReports extent;
    private ExtentTest test;

   
    public void onStart(ITestContext context)
    {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report1.html");
        htmlReporter.config().setDocumentTitle("ITCPrject");
        htmlReporter.config().setReportName("ITC_report");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
//        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("test-output/spark-report1.html");
//        extent.attachReporter(extentSparkReporter);
    }
     
    
    public void onFinish(ITestContext context)
    {
        extent.flush();
    }

    public void onTestStart(ITestResult result)
    {
        test = extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test sucessful");
    }

    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failure");
        test.log(Status.FAIL, result.getThrowable());
        test.log(Status.FAIL, "Test '" + result.getName() + "' has failed");
        test.log(Status.FAIL, "Class: " + result.getTestClass().getName());
        test.log(Status.FAIL, "Method: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, "Timestamp: " + result.getEndMillis());

    }

    public void onTestSkipped(ITestResult result)
    {
        test.log(Status.SKIP, "Test '" + result.getName() + "' has been skipped");
        test.log(Status.SKIP, "Class: " + result.getTestClass().getName());
        test.log(Status.SKIP, "Method: " + result.getMethod().getMethodName());
        test.log(Status.SKIP, "Timestamp: " + result.getEndMillis());
    }
}
