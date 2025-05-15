package vtiger_genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--Started--");
		test = report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--passed--");
		test.log(Status.PASS, methodname + "success----------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--Fail--");
		WebDriverUtility wutil = new WebDriverUtility();
		JaveUtility jutil = new JaveUtility();
		String screenshotname = methodname + "." + jutil.toGetSystemDateAndTime();
		test.log(Status.FAIL, methodname + "Failed----------");
		try {
			String path = wutil.toTakeSceenshot(BaseClass.sDriver, screenshotname);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--Skipped--");
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("--Suit execution Started--");
		// create object of ExtentSpark Report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(
				"./ExtentReports/Report-" + new JaveUtility().toGetSystemDateAndTime() + ".html");
		htmlReport.config().setDocumentTitle("vtiger Execution report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Vtiger Execution report");

		// create object of ExtentReports
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("BaseUrl", "http://localhost:8888/");
		report.setSystemInfo("username", "admin");
		report.setSystemInfo("password", "password");
		report.setSystemInfo("Reporter Name", "sniksa");

	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("--Suit execution Finished--");
		report.flush();

	}

}
