package Day26May23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ORangeHRMImplicitWait {
	static By userName = By.name("username");
	static By password = By.name("password");
	static By login = By.xpath("//button[@type='submit']");

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// login
		driver.findElement(userName).sendKeys("Admin");
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(login).click();

	}
}
