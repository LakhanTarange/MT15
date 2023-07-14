package Day18May23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassSendKeys {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement txtAutoSuggest = driver.findElement(By.id("autosuggest"));

		Actions action = new Actions(driver);
//		action.moveToElement(txtAutoSuggest).click().sendKeys("Shubham").build().perform();

		action.sendKeys(txtAutoSuggest, "Shubham").build().perform();

		// click using actions class

		WebElement btnOpenWindow = driver.findElement(By.id("openwindow"));

		action.click(btnOpenWindow).build().perform();

	}
}
