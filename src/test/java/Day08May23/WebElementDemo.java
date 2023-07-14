package Day08May23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo {
	static void verifyActualAndExpectedURLs(String hyperLinkName, String actUrl, String expUrl)
	{
		if(actUrl.equals(expUrl))
			System.out.println(hyperLinkName + " => Test case passed !");
		else
			System.out.println(hyperLinkName + " => Test case passed !");
	}
	
	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.letskodeit.com/practice";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement linkBlog = driver.findElement(By.linkText("BLOG"));
		linkBlog.click();
		String actUrl = driver.getCurrentUrl();
		System.out.println("Actual Blog actUrl ==> " + actUrl);
		String expUrl = "https://www.letskodeit.com/blog";
		verifyActualAndExpectedURLs("BLOG", actUrl, expUrl); 
	
		
		driver.findElement(By.linkText("SUPPORT")).click();
		String actSupportUrl = driver.getCurrentUrl();
		String expSupportUrl = "https://www.letskodeit.com/support";
		System.out.println("Support Actual URL ==> " + actSupportUrl);
		verifyActualAndExpectedURLs("SUPPORT", actSupportUrl, expSupportUrl); 
		
		driver.findElement(By.partialLinkText("PRACT")).click();
		String actPracticeUrl = driver.getCurrentUrl();
		String expPracticeUrl = "https://www.letskodeit.com/practice";
		System.out.println("PRACTICE Actual URL ==> " + actPracticeUrl);
		verifyActualAndExpectedURLs("PRACTICE", actPracticeUrl, expPracticeUrl);
		
		
		
		
		Thread.sleep(4000l);
		driver.quit();
	}
}
