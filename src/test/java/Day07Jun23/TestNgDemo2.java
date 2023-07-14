package Day07Jun23;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNgDemo2 {
	@Test(priority = 2)
	public void timepass() {
		System.out.println("User has lot of time, killing time......");
	}
	@Test(priority = -1)
	public void reg() {
		System.out.println("User registered...");
	}
	@Test(priority = 0)
	public void login() {
		System.out.println("User logged in...");
		throw new SkipException("Intentionally skipping a test script1");
	}
	@Test(priority = 1)
	public void logout() {
		System.out.println("user logged out...");
		throw new SkipException("Intentionally skipping a test script2");
	}
}
