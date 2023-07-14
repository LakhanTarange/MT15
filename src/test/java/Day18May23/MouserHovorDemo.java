package Day18May23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouserHovorDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement btnMouserHover = driver.findElement(By.id("mousehover"));

		Actions action = new Actions(driver);
		action.moveToElement(btnMouserHover).perform();
		driver.findElement(By.xpath("//a[@href='#top']")).click();
		Thread.sleep(3000l);

		action.moveToElement(btnMouserHover).perform();
		driver.findElement(By.xpath("//div[@class='mouse-hover-content']/a[2]")).click();

	}	
}
