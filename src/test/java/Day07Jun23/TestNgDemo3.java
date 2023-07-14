package Day07Jun23;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgDemo3 {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before Suite...");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after Suite...");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test...");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After test...");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class...");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class...");
	}

	@BeforeMethod
	public void tearUp() {
		System.out.println("BEFORE script/method...");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("AFTER test script/method...");
	}

	@Test
	public void reg() {
		System.out.println("user is being registered...");
	}

	@Test
	public void login() {
		System.out.println("user is logged in...");
	}

	@Test
	public void logout() {
		System.out.println("user is logged out...");
	}
}
