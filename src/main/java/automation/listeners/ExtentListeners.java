package automation.listeners;

import automation.properties.PropertyManager;
import automation.testbase.Page;
import automation.utilities.ExtentManager;
import automation.utilities.MessageUtils;
import automation.utilities.ProjectUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <b>LISTENERS</b> [Extent]: Extent Listener
 */
public class ExtentListeners implements ITestListener, ISuiteListener {
    public static ExtentTest test;
    static String fileName = "Extent_Jenkins";
    private static final ExtentReports extent = ExtentManager.createInstance(".\\target\\surefire-reports\\html\\" + fileName);
    File archiveFolder = new File(".\\target\\surefire-reports\\html\\archive\\");
    File sourceFolder = new File(".\\target\\surefire-reports\\html\\");
    ProjectUtils archiveReport = new ProjectUtils();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime currentDateTime = LocalDateTime.now();
    String currentDate = dateTimeFormatter.format(currentDateTime);
    String[] currentDateArray = currentDate.split(" ");
    File archiveSubFolder = new File(archiveFolder + "/" + currentDateArray[0].replace("/", "-"));
    File destinationFolder = new File(archiveFolder + "/" + currentDateArray[0].replace("/", "-") + "/" + currentDateArray[1].replace(":", "-"));

    /**
     * <b>[Method]</b> - On Test Start<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality ...<br>
     *
     * @param result ITestResult
     */
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        // initialize property file and store value before test start
        PropertyManager property = new PropertyManager();
        try {
            property.ConfigFileReader();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - On Test Success<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality writes Success log into report.<br>
     *
     * @param result ITestResult
     */
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        test.pass(markup);
    }

    /**
     * <b>[Method]</b> - On Test Failure<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality writes Error log into report. Also captures screenshot from the error.<br>
     *
     * @param result ITestResult
     */
    public void onTestFailure(ITestResult result) {
        try {
            ExtentManager.captureScreenshot(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String methodName = result.getMethod().getMethodName();
        String logText = MessageUtils.getLogText(methodName, " FAILED");
        String reportErrorMessage = MessageUtils.getReportErrorResultText(result);
        test.fail(reportErrorMessage, MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.fileName).build());
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
        test.log(Status.FAIL, markup);
    }

    /**
     * <b>[Method]</b> - On Test Skipped<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality writes Warning log into report for tests that are skipped.<br>
     *
     * @param result ITestResult
     */
    public void onTestSkipped(ITestResult result) {
        try {
            ExtentManager.captureScreenshot(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String methodName = result.getMethod().getMethodName();
        String logText = MessageUtils.getLogText(methodName, " SKIPPED");
        String reportErrorMessage = MessageUtils.getReportErrorResultText(result);
        test.skip(reportErrorMessage, MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.fileName).build());
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
        test.log(Status.SKIP, markup);
        Page.quit(); // Close current browser
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext context) {
        //test = extent.createTest(context.getClass().getName());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public void onStart(ISuite suite) {
        archiveReport.fileCleanUp(sourceFolder);
    }

    public void onFinish(ISuite suite) {
        archiveReport.archiveReport(destinationFolder, sourceFolder);
        archiveReport.directoryCleanUp(archiveFolder, 10);
        archiveReport.directoryCleanUp(archiveSubFolder, 10);
    }

}