package Day18May23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDispalyDemo {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement txtElement = driver.findElement(By.id("displayed-text"));
		txtElement.clear();
		txtElement.sendKeys("Tarun");
		boolean res = txtElement.isDisplayed();
		System.out.println("res: Display? " + res); // true
		Thread.sleep(3000l);

		driver.findElement(By.id("hide-textbox")).click();
		res = txtElement.isDisplayed();
		System.out.println("res: Display? " + res); // false
		Thread.sleep(3000l);

		driver.findElement(By.id("show-textbox")).click();
		res = txtElement.isDisplayed();
		System.out.println("res: Display? " + res); // true
		Thread.sleep(3000l);

		txtElement.clear();
		txtElement.click();
		Thread.sleep(3000l);
		driver.quit();

	}
}
