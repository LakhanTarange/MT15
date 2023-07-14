package Day29May23;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardHAndling {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200);", "");

		// Enter the Full Name
		// WebElement fullName =
		driver.findElement(By.id("userName")).sendKeys("Mr Cyber Success");

		// Enter the Email
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("CyberSuccess@gmail.com");

		// Enter the Current Address
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("Deccan,Asmani Plaza, Pune 411 016");

		String k = Keys.chord(Keys.CONTROL, "a"); // pressing CONTRL+a
		currentAddress.sendKeys(k);

		// Copy into clipboard the Current Address by pressing CONTROL+A
		k = Keys.chord(Keys.CONTROL, "c");// press Contrl+c
		currentAddress.sendKeys(k);
		Thread.sleep(2000l);

		// Press the TAB Key to Switch Focus to Permanent Address
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000l);

		// Paste the Address in the Permanent Address field
		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
//      permanentAddress.clear();  // to set the focus
		permanentAddress.sendKeys(Keys.chord(Keys.CONTROL, "v"));

		Thread.sleep(5000l);
		driver.quit();
	}
}
