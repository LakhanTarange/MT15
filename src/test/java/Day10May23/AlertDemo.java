package Day10May23;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://www.letskodeit.com/practice";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement txtName = driver.findElement(By.xpath("//input[@id='name'][@name='enter-name']"));
		txtName.sendKeys("Rahul");

		/*
		 * Alert button ->
		 * //div[@data-uniqid='1621628043299']/div/div/div/div[3]/div[3]/fieldset/input[
		 * 2]
		 * 
		 * //div[@data-uniqid='1621628043299']/div/div/div/div[3]/div[3]//input[2]
		 * 
		 * //div[@data-uniqid='1621628043299']//div[3]/div[3]//input[2]
		 * 
		 * //div[3]/div[3]//input[3]
		 * 
		 */

		WebElement btnAlert = driver
				.findElement(By.xpath("//div[@data-uniqid='1621628043299']//div[3]/div[3]//input[2]"));

		btnAlert.click();
		Thread.sleep(4000l);
//		driver.switchTo().alert().accept();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

		alert.accept();

// confirm button 
		txtName.sendKeys("Lakhan");
		driver.findElement(By.xpath("//div[3]/div[3]//input[3]")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(4000l);
		System.out.println(alert.getText());
//		alert.accept();
		alert.dismiss();
		driver.quit();

	}
}
