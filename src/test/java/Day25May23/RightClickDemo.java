package Day25May23;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickDemo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement imageElement = driver.findElement(By.xpath("(//p[@align='center']/img)[2]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(imageElement).contextClick().build().perform();
		driver.findElement(By.id("dm2m1i1tdT")).click();
		driver.findElement(By.id("dm2m2i1tdT")).click();
		driver.findElement(By.id("dm2m3i1tdT")).click();

		Set<String> windIds = driver.getWindowHandles();

		System.out.println("no of windows :" + windIds.size());

		Iterator<String> iter = windIds.iterator();
		String pWind = iter.next();
		String cWind = iter.next();
		System.out.println("pWind: " + pWind);
		System.out.println("cWind: " + cWind);

		driver.switchTo().window(cWind);
		String actUrl = driver.getCurrentUrl();
		String expUrl = "http://deluxe-menu.com/installation-info.html";
		if (actUrl.equals(expUrl))
			System.out.println("Test case#1 passed !");
		else
			System.out.println("Test case#1 failed !");

		String actHdr = driver.findElement(By.xpath("//strong")).getText();
		String expHdr = "Menu Script Installation";
		if (actHdr.equals(expHdr))
			System.out.println("Test case#2 passed !");
		else
			System.out.println("Test case#2 failed !");

		driver.quit();

	}
}
