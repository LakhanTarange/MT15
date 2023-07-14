package Day09May23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLablesDemo {
	public static void main(String[] args) {
		String url = "https://www.letskodeit.com/practice";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		  String expLblValue = "Radio Button example"; String actLblValue =
		  driver.findElement(By.xpath("(//legend)[1]")).getText();
		  
		  if (expLblValue.equals(actLblValue))
		  System.out.println("Test case passed!!!"); else System.
		 out.println("Test case failed, expValue:" + expLblValue + " : " + "actValue:" + actLblValue);
		
		driver.quit();
	}
}