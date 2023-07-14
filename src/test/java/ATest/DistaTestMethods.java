package ATest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DistaTestMethods {
	static WebDriver driver;
	
	static WebElement getWebElement(By by) {
		return driver.findElement(by);
	}
	static void type(By by, String value) {
		getWebElement(by).sendKeys(value);
	}
	static void verificationTestCase(String name, String actMsg, String expMsg) {
		if (actMsg.equals(expMsg)) {
			System.out.println(name + ":- Test case Passed!!!");
		}
		else {
			System.out.println(name + ":- Test Case Faild!!!");
		}
	}
	static String getActualText(By by, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait.until(ExpectedConditions.presenceOfElementLocated(by)).getText();
	}
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.navigate().to("https://dista.ai/");
		
//		WebElement element = getWebElement(By.xpath("//div[@data-id= '40a364e5']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoview(true);", element);
	  js.executeScript("window.scrollBy(0,1500);","");
	  Thread.sleep(5000l);
		  
		  String fieldActText = getActualText(By.xpath("(//div//span[@class='elementor-counter-number'])[1]"), 15);
		  String fieldExpText = "50";
		  verificationTestCase("field 50",fieldActText,fieldExpText);
		  fieldActText = getActualText(By.xpath("(//div//span[@class='elementor-counter-number-suffix'])[1]"), 15);
		  fieldExpText = "K+";
		  verificationTestCase("field K+",fieldActText,fieldExpText);
		  fieldActText = getActualText(By.xpath("(//div[@class='elementor-counter-title'])[1]"), 15);
		  fieldExpText = "Field assets managed";
		  verificationTestCase("field Field assets managed",fieldActText,fieldExpText);
		  
		  String jobActText = getActualText(By.xpath("(//div//span[@class='elementor-counter-number'])[2]"), 15);
		  String jobExpText = "15";
		  verificationTestCase("job 15",jobActText,jobExpText);
		  jobActText = getActualText(By.xpath("(//div//span[@class='elementor-counter-number-suffix'])[2]"), 15);
		  jobExpText = "M+"; 
		  verificationTestCase("job M+",jobActText,jobExpText);
		  jobActText = getActualText(By.xpath("(//div[@class='elementor-counter-title'])[2]"), 15);
		  jobExpText = "Jobs scheduled/month";
		  verificationTestCase("job Jobs scheduled/month",jobActText,jobExpText);
		  
		  String customerActText = getActualText(By.xpath("(//div//span[@class='elementor-counter-number'])[3]"), 15);
		  String customerExpText = "35";
		  verificationTestCase("customer 35",customerActText,customerExpText);
		  customerActText = getActualText(By.xpath("(//div//span[@class='elementor-counter-number-suffix'])[3]"), 15);
		  customerExpText = "+";
		  verificationTestCase("customer +",customerActText,customerExpText);
		  customerActText = getActualText(By.xpath("(//div[@class='elementor-counter-title'])[3]"), 15);
		  customerExpText = "Customers";
		  verificationTestCase("customer Customers",customerActText,customerExpText);
		  
		  driver.quit();
	}
}
