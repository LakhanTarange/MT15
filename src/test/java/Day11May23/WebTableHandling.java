package Day11May23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {
	public static void main(String[] args) {

		String url = "https://www.letskodeit.com/practice";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		/*
		 * //table[@id='product']/tbody/tr[3]/td[2]
		 * 
		 * (//table[@id='product']//td[2])[2]
		 * 
		 * //tr[3]/td[2]
		 */
		WebElement elementWt = driver.findElement(By.xpath("//tr[3]/td[2]"));

		System.out.println(elementWt.getText());
		driver.quit();

	}
}
