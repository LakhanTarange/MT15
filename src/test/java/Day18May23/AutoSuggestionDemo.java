package Day18May23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionDemo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.id("autosuggest")).sendKeys("Res");
		driver.findElement(By.xpath("//ul[@id='ui-id-1']//li[3]/a[@id='ui-id-4']")).click();

		String val = driver.findElement(By.id("autosuggest")).getAttribute("value");
		System.out.println("value : " + val);

	}
}
