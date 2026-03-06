package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import test_Base.base_class;

public class reports implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;
    private String reportName;

    @Override
    public void onStart(ITestContext context) {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        reportName = "TestReport_" + timeStamp + ".html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter("reports/" + reportName);

        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Execution Results");
        reporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Application", "TalentTurbo");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("OS",
                context.getCurrentXmlTest().getParameter("os"));
        extent.setSystemInfo("Browser",
                context.getCurrentXmlTest().getParameter("browser"));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.fail(result.getThrowable());

        try {
            String screenshot = new base_class()
                    .captureScreen(result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshot);
        } catch (IOException e) {
            test.warning("Screenshot capture failed");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
