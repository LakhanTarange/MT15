package Day01Jun23;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesFielREadingDemo1 {
	WebDriver driver = null;
	static Properties readPropertiesFile(String fileName, Properties prop) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(fileName);
		prop.load(fis);
		return prop;
	}
	static WebElement getWebElement(By by, WebDriver driver) {
		return driver.findElement(by);
	}
	static void type(By by, String key, WebDriver driver, Properties prop) {
		getWebElement(by, driver).sendKeys(prop.getProperty(key));
	}
	static void ElementClick(By by, WebDriver driver) {
		getWebElement(by, driver).click();
	}
	private static void OpenUrl(WebDriver driver, Properties prop) {
		String url;
		url 				= prop.getProperty("url");
		driver.get(url);
	}
	private static WebDriver LaunchBrowser(WebDriver driver, String browser) {
		switch (browser.toUpperCase()) {
		case "CHROME":
			driver			= new ChromeDriver();
			break;
		case "EDGE":
			driver  		= new EdgeDriver();
			break;
		case "FIREFOX":
			driver 			= new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Invalid browser : " + browser);
		}
		return driver;
		
	}
	
	private static void VerifyUrls(WebDriver driver, String expUrl) {
		if (expUrl.equals(getActualURL(driver)))
			System.out.println("Test case passed");
		else
			System.out.println("Test case failed, actUrl " + getActualURL(driver) + "  expUrl : " + expUrl);
	}
	private static String getActualURL(WebDriver driver) {
		String actUrl 		= driver.getCurrentUrl();
		return actUrl;
	}
	public static void main(String[] args) throws IOException {

		WebDriver driver 	= null;
		Properties prop 	= null; // local variable propr defined
		String fileName 	= System.getProperty("user.dir") + "/src/test/java/Day01Jun23/configactitime.properties";
		String expUrl 		= "http://127.0.0.1/user/submit_tt.do";
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		// reading a properties file
		prop = readPropertiesFile(fileName, prop);

		// getting values from properties file
		String browser 		= (String) prop.get("browser");
		String to 			= (String) prop.get("timeout");
		String city 		= (String) prop.get("city");
		String age 			= (String) prop.get("age");
//		String wt  			= (String) prop.get("weight");
		String wt 			= prop.getProperty("weigth");

		System.out.println("timeout : " + to);
		System.out.println("city    : " + city);
		System.out.println("age     : " + age);
		System.out.println("wt      : " + wt);
//		float wt1 = Float.parseFloat(wt) + 100;
//		System.out.println(wt1);

		driver = LaunchBrowser(driver, browser);

		OpenUrl(driver, prop);

		// username
		type(By.name("username"), "username", driver, prop);

		// password
		type(By.name("pwd"), "password", driver, prop);

		// click on Login button
		ElementClick(By.id("loginButton"), driver);

		// 127.0.0.1 : loop back address or localhost
		VerifyUrls(driver, expUrl);

		driver.quit();
	}
}
