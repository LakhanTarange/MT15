package ATest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DistaC {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://dista.ai/");
	//	driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1500);","");
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;  
//        js.executeScript("scrollBy(0, 1500)"); 
        Thread.sleep(5000l);
	  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		System.out.println("-------------------------------- Start ExecuteField assets managed ----------------------------------------");
		String expFieldValue = "50";
		String actFieldValue = driver.findElement(By.xpath("(//div//span[@class='elementor-counter-number'])[1]")).getText();

		if (expFieldValue.equals(actFieldValue))
			System.out.println("Test case passed!!! " + actFieldValue + " : " + expFieldValue);
		else
			System.out.println("Test case failed, expValue: " + expFieldValue + " : " + "actValue: " + actFieldValue);

		expFieldValue = "K+";
		actFieldValue = driver.findElement(By.xpath("(//div//span[@class='elementor-counter-number-suffix'])[1]")).getText();
		
		if (expFieldValue.equals(actFieldValue))
			System.out.println("Test case passed!!! " + actFieldValue + " : " + expFieldValue);
		else
			System.out.println("Test case failed, expValue: " + expFieldValue + " : " + "actValue: " + actFieldValue);

		expFieldValue = "Field assets managed";
		actFieldValue = driver.findElement(By.xpath("(//div[@class='elementor-counter-title'])[1]")).getText();
		
		if (expFieldValue.equals(actFieldValue))
			System.out.println("Test case passed!!! " + actFieldValue + " : " + expFieldValue);
		else
			System.out.println("Test case failed, expValue: " + expFieldValue + " : " + "actValue: " + actFieldValue);
		
		
		System.out.println("-------------------------------- Start Execute Jobs scheduled/month ----------------------------------------");
		String expJobValue = "15";
		String actJobValue = driver.findElement(By.xpath("(//div//span[@class='elementor-counter-number'])[2]")).getText();

		if (expJobValue.equals(actJobValue))
			System.out.println("Test case passed!!! " + actJobValue + " : " + expJobValue);
		else
			System.out.println("Test case failed, expValue: " + expJobValue + " : " + "actValue: " + actJobValue);

		expJobValue = "M+";
		actJobValue = driver.findElement(By.xpath("(//div//span[@class='elementor-counter-number-suffix'])[2]")).getText();
		
		if (expJobValue.equals(actJobValue))
			System.out.println("Test case passed!!! " + actJobValue + " : " + expJobValue);
		else
			System.out.println("Test case failed, expValue: " + expJobValue + " : " + "actValue: " + actJobValue);

		expJobValue = "Jobs scheduled/month";
		actJobValue = driver.findElement(By.xpath("(//div[@class='elementor-counter-title'])[2]")).getText();
		
		if (expJobValue.equals(actJobValue))
			System.out.println("Test case passed!!! " + actJobValue + " : " + expJobValue);
		else
			System.out.println("Test case failed, expValue: " + expJobValue + " : " + "actValue: " + actJobValue);

		System.out.println("-------------------------------- Start Execute Customers ----------------------------------------");
		String expCustomerValue = "35";
		String actCustomerValue = driver.findElement(By.xpath("(//div//span[@class='elementor-counter-number'])[3]")).getText();

		if (expCustomerValue.equals(actCustomerValue))
			System.out.println("Test case passed!!! " + actCustomerValue + " : " + expCustomerValue);
		else
			System.out.println("Test case failed, expValue: " + expCustomerValue + " : " + "actValue: " + actCustomerValue);

		expCustomerValue = "+";
		actCustomerValue = driver.findElement(By.xpath("(//div//span[@class='elementor-counter-number-suffix'])[3]")).getText();
		
		if (expCustomerValue.equals(actCustomerValue))
			System.out.println("Test case passed!!! " + actCustomerValue + " : " + expCustomerValue);
		else
			System.out.println("Test case failed, expValue: " + expCustomerValue + " : " + "actValue: " + actCustomerValue);

		expCustomerValue = "Customers";
		actCustomerValue = driver.findElement(By.xpath("(//div[@class='elementor-counter-title'])[3]")).getText();
		
		if (expCustomerValue.equals(actCustomerValue))
			System.out.println("Test case passed!!! " + actCustomerValue + " : " + expCustomerValue);
		else
			System.out.println("Test case failed, expValue: " + expCustomerValue + " : " + "actValue: " + actCustomerValue);
	
		driver.quit();
	}
}
