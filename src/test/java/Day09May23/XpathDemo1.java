package Day09May23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo1 {
		public static void main(String[] args) throws InterruptedException {
			String url = "https://www.letskodeit.com/practice";
			WebDriver driver = new ChromeDriver();
			driver.get(url);
			
		WebElement ele = driver.findElement(By.xpath("//*[@data-uniqid='1621702280245']"));
		String actLblValue  = ele.getText();
		String expLblValue = "practice Page";
		if (actLblValue.equals(expLblValue))
			System.out.println("Test case Passed !!!!");
		else
			System.out.println("Test case Failed, expValue: " + expLblValue + " : " + " actValue: " + actLblValue);
			
		driver.quit();
	}
}
