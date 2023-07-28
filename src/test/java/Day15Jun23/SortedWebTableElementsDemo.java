package Day15Jun23;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortedWebTableElementsDemo {

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
		driver.findElement(By.xpath("//div[@id='app']//ul/li[1]/a")).click(); // admin click

		driver.findElement(By.xpath("//div[@id='app']//div[4]/div/i")).click(); // button

		driver.findElement(By.xpath("//div[@id='app']//div[4]//ul/li[1]/span")).click(); // ascending

		List<WebElement> low = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div/div/div[4]"));

		List<Object> empNameList = low.stream().map(new Function<WebElement, Object>() {
			@Override
			public Object apply(WebElement s) {
				return s.getText();
			}
		}).collect(Collectors.toList());

		List<Object> loString = empNameList.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(empNameList, loString, "Both list are not equal !!!");

		// driver.quit();

	}
	
}
