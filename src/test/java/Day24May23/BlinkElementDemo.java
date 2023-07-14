package Day24May23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlinkElementDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement txtFirstName = driver.findElement(By.name("firstname"));
	 	js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 15px solid blue;');", txtFirstName);
	 	txtFirstName.sendKeys("Cyber"); Thread.sleep(2000l);
	 	js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 1px solid grey;');", txtFirstName);

	 	WebElement txtLastName = driver.findElement(By.name("lastname"));
		js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 10px dashed red;');", txtLastName);
	 	txtLastName.sendKeys("success");Thread.sleep(2000l);
	 	js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 1px solid grey;');", txtLastName);
		
		
		WebElement txtEmail = driver.findElement(By.name("reg_email__"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid red;');", txtEmail);
		txtEmail.sendKeys("Deccan@pune.com");Thread.sleep(3000l);
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 1px solid grey;');", txtEmail);

		String val= driver.findElement(By.name("firstname")).getAttribute("value");
		System.out.println("value: " + val);

		String txt = driver.findElement(By.name("firstname")).getText();
		System.out.println("txt: " + txt); //will not have any value

		
		System.out.println(txtFirstName.getCssValue("background-color"));
		System.out.println(txtLastName.getCssValue("background-color"));
		System.out.println(txtEmail.getCssValue("background-color"));
		
		
		//js.executeScript("arguments[0].style.backgroundColor='red'",txtFirstName);
		
	}


}
