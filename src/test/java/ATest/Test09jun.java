package ATest;

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
import org.openqa.selenium.support.ui.Select;

public class Test09jun {
	static WebDriver driver;

	static WebDriver openBrowserAndUrl(String url, String browser) {
		switch (browser.toUpperCase()) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println(browser + " brower is not installed or wrong browser Name");
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	static WebElement findingElement(By elementName) {
		return driver.findElement(elementName);

	}

	static void forSendingValues(By by, String value) {
		findingElement(by).sendKeys(value);
	}

	static void forClick(By by) {

		findingElement(by).click();
	}

	static void closeBrowser() {
		driver.quit();
	}

	static String fileReading(String key) throws IOException 
	{
		String fileloc = System.getProperty("user.dir") + "/src/test/java/ATest/Facebook.properties";
		Properties prop = new Properties();
		FileInputStream st = new FileInputStream(fileloc);
		prop.load(st);
		return prop.getProperty(key);
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		String url = fileReading("url");
		String browser = fileReading("browser");
		openBrowserAndUrl(url, browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		By createNewAcc = By.xpath("(//a[@role='button'])[2]");
		forClick(createNewAcc);

		By firstName = By.name("firstname");
		forSendingValues(firstName, fileReading("username"));

		By surName = By.name("lastname");
		forSendingValues(surName, fileReading("surname"));

		By moNo = By.name("reg_email__");
		forSendingValues(moNo, fileReading("mono"));

		By password = By.name("reg_passwd__");
		forSendingValues(password, fileReading("password"));

		By birthday = By.id("day");
		WebElement bir = findingElement(birthday);
		Select select = new Select(bir);
		select.selectByVisibleText(fileReading("birthdate"));

		By birthmonth = By.id("month");
		WebElement birm = findingElement(birthmonth);
		Select select1 = new Select(birm);
		select1.selectByValue(fileReading("birthmonth"));

		By birthyear = By.id("year");
		WebElement biry = findingElement(birthyear);
		Select select2 = new Select(biry);
		select2.selectByVisibleText(fileReading("birthyear"));

		if (fileReading("gender").equalsIgnoreCase("male")) {
			By gender = By.xpath("//span[2]");
			forClick(gender);
		}

		By signUp = By.name("websubmit");
		forClick(signUp);

		Thread.sleep(5000l);
		closeBrowser();

	}

}
