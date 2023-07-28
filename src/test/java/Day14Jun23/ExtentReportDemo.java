package Day14Jun23;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	public static void main(String[] args) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\src\\test\\resources\\reports" + "\\extentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		ExtentTest test1 = extent.createTest("VerifyTestForPayment", "Verification of total payment");
		test1.assignAuthor("CyberTester1", "Tarun");
		test1.assignCategory("Smoke", "Regression");

		test1.log(Status.INFO, "Browser opened : Chrome");
		test1.log(Status.INFO, "Opened URL");
		test1.log(Status.INFO, "window maximized");
		test1.info("Logged in successful");
		test1.pass("verification of FirstName passed");
		test1.pass("Verification of LastName passed");
		test1.pass("Sample pass test step3");
		test1.pass("Sample pass test step4");
		test1.fail("Test case failed !");

		extent.flush(); // write entire report to a file
	}

}
