package Day06Jun23;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationWindowDemo {
	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/basic_auth");
		Thread.sleep(1000l);
// this Runtime class allows you to run any executable file
		Runtime.getRuntime().exec("C:\\Users\\taran\\OneDrive\\Desktop\\AutoIT\\Login");
		// AUTOIT FILE EXTENSION IS .au3

		Thread.sleep(4000l);
		// verify we have reached to a appropriate page
		String expMsg = "Congratulations! You must have the proper credentials.";
		String actMsg = driver.findElement(By.xpath("//*[@id='content']/div/p")).getText();
		if (expMsg.equals(actMsg))
			System.out.println("Test Case Passed!!!");
		else
			System.out.println("Test Case Failed!!!");

		Thread.sleep(3000l);
		driver.quit();

	}
}
