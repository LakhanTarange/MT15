package Day09May23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsDemo {
	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.letskodeit.com/practice";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		List<WebElement> lwe =  driver.findElements(By.xpath("//input[@name='cars' and @type='radio']"));
		System.out.println("size : " + lwe.size());  //3
		
/*		for(int i=0;i<lwe.size();i++)
		{
			WebElement we = lwe.get(i);
			System.out.println(we.getAttribute("value"));
			we.click();
			Thread.sleep(3000l);
		}
*/
		for(WebElement we : lwe)
		{
			System.out.println(we.getAttribute("value"));
			we.click();
			Thread.sleep(3000l);
		}
		driver.quit();
	}
}
