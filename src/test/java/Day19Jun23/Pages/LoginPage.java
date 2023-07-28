package Day19Jun23.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

// 1st component 	
	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

// 2nd component	
// WebElements locators
	By txtName = By.name("username");
	By txtpassword = By.name("password");
	By btnLogin = By.xpath("//button[@type='submit']");

// 3rd component	
	private void enterUserName(String data, By by) {
		enterText(data, by);
	}

	private void enterPassword(String data, By by) {
		enterText(data, by);
	}

	private void enterText(String data, By by) {
		driver.findElement(by).sendKeys(data);
	}

	private void clickLogin(By by) {
		driver.findElement(by).click();
	}

	public LandingPage login(String userName, String password) {
		enterUserName(userName, txtName);
		enterPassword(password, txtpassword);
		clickLogin(btnLogin);
		return new LandingPage(driver);

	}

	public void verifyUrl(String expUrl) {
		String actUrl = driver.getCurrentUrl();

		System.out.println("actUrl: " + driver.getCurrentUrl());
		System.out.println("expUrl: " + expUrl);

		Assert.assertEquals(expUrl, actUrl, "expUrl : " + expUrl + " does not match with actual Url:" + actUrl);

	}

	public void verifyLoginPageHeader(String expPageHeader) {
		Assert.assertEquals(expPageHeader, driver.findElement(By.xpath("//h5")).getText(),
				"Exp page header does not match with actual page header !");
	}

}
