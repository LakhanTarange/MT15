package Day11May23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksDemo {
public static void main(String[] args) {
		
		String url = "https://jqueryui.com/";
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		List<WebElement> low = driver.findElements(By.xpath("//div[@class='dev-links']//li//a"));
		int cnt = 1;
		for(WebElement we: low)
		{
			low = driver.findElements(By.xpath("//div[@class='dev-links']//li//a"));
			System.out.println(cnt++ + " => " + we.getText());
			String hRef = we.getAttribute("href");
			we.click();
			String actUrl = driver.getCurrentUrl();
			System.out.println(hRef + " : " + actUrl);
			if (actUrl.equals(hRef))
				System.out.println("Link is working");
			else
				System.out.println("Link is NOT working");
			driver.navigate().back();
		}
		driver.quit();
	
	}
}
