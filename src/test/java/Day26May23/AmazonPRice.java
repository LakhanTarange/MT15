package Day26May23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPRice {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		String url = "https://www.amazon.in";
		driver.get(url);

		driver.manage().window().maximize();
		// clicking on best seller
		driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_2']")).click();

		// get header label
		String hdrLabel = driver.findElement(By.id("zg_banner_text")).getText();
		System.out.println(hdrLabel);

		driver.findElement(By.xpath("//div[@id='B07Q7CNPMV']/a[2]")).click();

		String price = driver.findElement(By.xpath("(//div[@id='corePriceDisplay_desktop_feature_div']//span)[6]"))
				.getText();
		System.out.println("price: " + price);
		Thread.sleep(4000l);
		driver.quit();

	}
}
