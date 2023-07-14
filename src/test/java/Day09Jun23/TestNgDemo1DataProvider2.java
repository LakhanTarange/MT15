package Day09Jun23;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDemo1DataProvider2 {
	WebDriver driver;

	private final By un 		= By.name("username");
	private final By pw 		= By.name("password");
	private final By login 		= By.xpath("//button[@type='submit']");
	private final By errorMsg 	= By.xpath("//p[text()='Invalid credentials']");
	String expErrorMsg			= "Invalid credentials";
	Properties prop;

	/**
	 * Read config.properties file containing environment variable
	 * 
	 * @throws IOException
	 */
	private void readConfig() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/configday09jun.properties");
		prop.load(fis);
	}

	/**
	 * finds webelement
	 * 
	 * @param by - xpath, cssSelector, id, name, className, tagName
	 * @return webelement
	 */
	private WebElement getWebElement(By by) {
		return driver.findElement(by);
	}

	/**
	 * sends keys to a web element
	 * 
	 * @param by
	 * @param String data
	 */
	private void type(By by, String data) {
		getWebElement(by).sendKeys(data);
	}

	/**
	 * clickiing on web element
	 * 
	 * @param by
	 */
	private void elementClick(By by) {
		getWebElement(by).click();
	}

	/**
	 * inputs username and password in username and password text field
	 * 
	 * @param username
	 * @param password
	 */
	private void formInput(String username, String password) {
		type(un, username);
		type(pw, password);
		elementClick(login);
	}

	/**
	 * getText from webelement
	 * 
	 * @return stringmessage
	 */
	private String getTextMethod() {
		return driver.findElement(errorMsg).getText();
	}

	/**
	 * launches a specified browser, maximize window and set implicite wait by using
	 * config.properties file
	 * 
	 * @throws IOException
	 */
	private void launchBrowser() throws IOException {
		readConfig();
		String br 		= prop.getProperty("browser");
		switch (br.toUpperCase()) {
		case "CHROME":
			driver 		= new ChromeDriver();
			break;
		case "EDGE":
			driver 		= new EdgeDriver();
			break;
		case "FIREFOX":
			driver 		= new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Invalid browser : " + br);
		}
		driver.get(prop.getProperty("url"));
		String maxWindow = prop.getProperty("maxWindow");
		if (Boolean.parseBoolean(maxWindow))
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeOut"))));
	}

	@Test(description = "Verifying login functionality using data provider", dataProvider = "ICT")
	public void validateLogin(String username, String password) throws InterruptedException {
		formInput(username, password);
		String actErrorMsg = getTextMethod();
		Assert.assertEquals(expErrorMsg, actErrorMsg, "Login failed");

		/*
		 * if (expErrorMsg.equals(actErrorMsg))
		 * System.out.println("validateLogin: Test case passed"); 
		 * else
		 * System.out.println("validateLogin: Test case failed");
		 */

		Thread.sleep(2000l);
	}

	@BeforeMethod
	public void setUp() throws IOException {
		launchBrowser();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "ICT")
	public Object[][] getData() {
		Object[][] data = { 
						{ "Harbhajan", "Bhajji@123" }, 
						{ "Ashish", "nehra@456" }, 
						{ "Saurabh", "Dada@789" },
						{ "Yuvraj", "Yuvi@101" } };
		return data;
	}
}
