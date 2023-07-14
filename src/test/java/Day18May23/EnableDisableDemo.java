package Day18May23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnableDisableDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement txtElement = driver.findElement(By.id("enabled-example-input"));
		txtElement.clear();
		txtElement.sendKeys("Heetarth");
		boolean res = txtElement.isEnabled();
		System.out.println("res: Enable?" + res); // true
		Thread.sleep(3000l);

		WebElement btnDisable = driver.findElement(By.id("disabled-button"));
		btnDisable.click();
		res = txtElement.isEnabled();
		System.out.println("res: Enable?" + res); // false
		Thread.sleep(3000l);

		WebElement btnEnable = driver.findElement(By.id("enabled-button"));
		btnEnable.click();
		res = txtElement.isEnabled();
		txtElement.click();
		System.out.println("res: Enable?" + res); // true
		Thread.sleep(3000l);

		txtElement.clear();

		Thread.sleep(2000l);
		driver.quit();

	}
}
