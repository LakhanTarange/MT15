package Day14Jun23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FlashDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("(//ul/li[2])[1]")).click();

		driver.findElement(By.xpath("//div[@class='orangehrm-header-container']/button")).click();

		driver.findElement(By.name("firstName")).sendKeys("Rushikesh");

		driver.findElement(By.name("lastName")).sendKeys("patil");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// flash element
		String actFlashText = driver.findElement(By.xpath("//div[@id='oxd-toaster_1']//p[2]")).getText();

		String expFlashText = "Successfully Saved";

		Assert.assertEquals(expFlashText.toUpperCase(), actFlashText.toUpperCase(),
				"Exp Flash Text : " + expFlashText + " does not match with actual flash Text: " + actFlashText);

		System.out.println("Test case passed");

		driver.quit();
	}
}
