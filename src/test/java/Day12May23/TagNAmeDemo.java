package Day12May23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagNAmeDemo {
	public static void main(String[] args) {
		String url = "https://demo.openmrs.org/openmrs/login.htm";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		List<WebElement> low = driver.findElements(By.tagName("a"));

		System.out.println(low.size());
		low.get(0).click();
		String expUrl = "https://demo.openmrs.org/openmrs/login.htm";
		String actUrl = driver.getCurrentUrl();
		if (expUrl.equals(actUrl))
			System.out.println("First link is working");
		else
			System.out.println("First link is NOT working");

		low = driver.findElements(By.tagName("a"));
		low.get(1).click();
		String actText = driver.findElement(By.xpath("//div[@class='dialog-content']/p")).getText();
		String expText = "Please contact your System Administrator.";

		if (actText.equals(expText))
			System.out.println("Second link is working");
		else
			System.out.println("Second link is NOT working");

		driver.quit();

	}
}
