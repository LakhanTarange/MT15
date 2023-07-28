package Day15Jun23;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilteringElementsUsingSearchDemo {

	@Test
	public void VerifySortedElements() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[@id='app']//ul/li[1]/a")).click();

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("D");

		List<WebElement> low = driver.findElements(By.xpath("//ul[@class='oxd-main-menu']/li/a"));
		System.out.println("low.size" + low.size()); // 3

		List<Object> filteredList = low.stream().filter(new Predicate<WebElement>() {
			@Override
			public boolean test(WebElement s) {
				return s.getText().toUpperCase().contains("D");
			}
		})
				.collect(Collectors.toList());
		System.out.println("filtered.size" + filteredList.size());

		Assert.assertEquals(low, filteredList, "Both lists are not matching !!!");

	}

}
