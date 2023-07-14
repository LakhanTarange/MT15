package Day16May23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement frameEle = driver.findElement(By.id("courses-iframe"));

		// driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe-name");
		// driver.switchTo().frame("courses-iframe");

		driver.switchTo().frame(frameEle);

		WebElement element = driver.findElement(By.xpath("//div[@class='col-md-4']//h1"));
		System.out.println(element.getText());

		driver.switchTo().defaultContent();

		String label = driver.findElement(By.xpath("(//fieldset/legend)[1]")).getText();
		System.out.println("label : " + label);

		driver.quit();

	}
}
