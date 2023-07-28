package Day17Jun23;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// When test method starts
		System.out.println("onTestStart() -> Test Name: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// If test method is successful
		System.out.println("onTestSuccess() -> Test Name: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// If test method is failed
		System.out.println("onTestFailure() -> Test Name: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// If test method is failed
		System.out.println("onTestSkipped() -> Test Name: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Ignore this
	}
}
