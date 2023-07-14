package Day26May23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDemoExplicitWait {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("q")).sendKeys("facebook");

// kept for implicitly wait 
//		String txt = driver.findElement(By.xpath("(//div[@role='presentation'])[1]//span")).getText();
//		System.out.println("txt : " + txt);

// explicit wait	
// 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

// 		String txt = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@role='presentation'])[1]//span"))).getText();

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@role='presentation'])[1]//span")));
		System.out.println("txt: " + element.getText());

		
		
		/*
		 * //fluent wait FluentWait wait = new FluentWait(driver);
		 * wait.withTimeout(Duration.ofSeconds(5));
		 * wait.pollingEvery(Duration.ofMillis(500));
		 * wait.ignoring(NoSuchElementException.class);
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.
		 * xpath("(//div[@role='presentation'])[1]//span ")));
		 * 
		 * String txtFirstOption =
		 * driver.findElement(By.xpath("(//div[@role='presentation'])[1]//span")).
		 * getText(); System.out.println("txtFirstOption : "+ txtFirstOption );
		 */

	}

}
