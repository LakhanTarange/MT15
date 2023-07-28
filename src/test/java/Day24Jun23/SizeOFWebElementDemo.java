package Day24Jun23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeOFWebElementDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// get elemeent's getHeightand width
		WebElement element1 = driver.findElement(By.xpath("(//p/img)[1]"));
		// H:16 W:17
		System.out.println("getRect.getDimension.getHeight: " + element1.getRect().getDimension().getHeight());
		System.out.println("getRect.getDimension.getWidth : " + element1.getRect().getDimension().getWidth());

		System.out.println("element1.getRect.getDimension.height: " + element1.getRect().getDimension().height);
		System.out.println("element1.getRect.getDimension.width : " + element1.getRect().getDimension().width);

		System.out.println("element1.getRect.height : " + element1.getRect().height);
		System.out.println("element1.getRect().width: " + element1.getRect().width);

		System.out.println("element1.getRect.getHeight  : " + element1.getRect().getHeight());
		System.out.println("element1.getRect().getWwidth: " + element1.getRect().getWidth());

		WebElement element2 = driver.findElement(By.xpath("(//p/img)[2]"));
		// H:119, W:180
		System.out.println("getRect().height: " + element2.getRect().height);
		System.out.println("getRect().width : " + element2.getRect().width);

		System.out.println("getHeight: " + element2.getRect().getHeight());
		System.out.println("getWidth : " + element2.getRect().getWidth());

		System.out.println(
				"element2.getRect().getDimension().getHeight() : " + element2.getRect().getDimension().getHeight());
		System.out.println(
				"element2.getRect().getDimension().getWidth()  : " + element2.getRect().getDimension().getWidth());

	}

}
