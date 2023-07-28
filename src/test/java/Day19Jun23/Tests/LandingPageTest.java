package Day19Jun23.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Day19Jun23.Pages.LandingPage;
import Day19Jun23.Pages.LoginPage;

public class LandingPageTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@Test
	public void verifyUrlTest() {
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String expMyActionsLabel = "My Actions";
		LoginPage lp = new LoginPage(driver);
		LandingPage landingPage = lp.login("admin", "admin123");
		landingPage.verifyUrl(expUrl);
		landingPage.verifyMyActions(expMyActionsLabel);
	}
}
