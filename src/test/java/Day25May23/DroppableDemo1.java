package Day25May23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DroppableDemo1 {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.xpath("(//div[@id='content']/following-sibling::div//ul//li[2]/a)[1]")).click();

		// switch to frame
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));

		Actions actions = new Actions(driver);
//		actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();

		actions.clickAndHold(draggable).moveToElement(droppable, 20, 20).release().build().perform();

	}
}
