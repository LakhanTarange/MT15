package Day06Jun23;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITNotRequired {
	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		// Enter file to upload using window's Open dialogue window
		// NOT AT ALL REQUIRED AS CHOOSE FILE IS A INPUT TAG WITH TYPE=FILE, WE CAN NOT
		// CLICK ON
		// SUCH ELEMENT, CAN SENDKEYS A FILE ALONG WITH ITS PATH
		Thread.sleep(4000l);
		driver.findElement(By.xpath("//*[@id='file-upload']"))
				.sendKeys("C:\\Users\\taran\\Downloads\\DistaC.java");
		Thread.sleep(4000l);

		driver.findElement(By.xpath("//*[@id='file-submit']")).click();

		String actMsg = driver.findElement(By.xpath("//h3")).getText();
		if (actMsg.equals("File Uploaded!"))
			System.out.println("Test case passed !!!");
		else
			System.out.println("Test case failed !!!");

		Thread.sleep(4000l);
		driver.quit();
	}
}
