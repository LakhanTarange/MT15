package Day08May23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.letskodeit.com/practice";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement rBtnBmw = driver.findElement(By.xpath("//input[@id='bmwradio']"));
	rBtnBmw.click();
	//	driver.findElement(By.xpath("//input[@value='benz' and @type='radio']")).click();
		Thread.sleep(4000l);
		driver.quit();
		}	
}
