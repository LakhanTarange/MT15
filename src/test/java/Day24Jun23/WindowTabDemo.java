package Day24Jun23;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowTabDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> windHandles = driver.getWindowHandles();
		Iterator<String> windIds = windHandles.iterator();
		String pWindId = windIds.next();
		String cWindId = windIds.next();
		driver.switchTo().window(cWindId);
		driver.get("https://www.letskodeit.com/courses");
		String newWindowUrl = driver.getCurrentUrl();
		System.out.println("newWindowUrl: " + newWindowUrl);
		driver.switchTo().window(pWindId);
		String homeWindowUrl = driver.getCurrentUrl();
		System.out.println("homeWindowUrl: " + homeWindowUrl);

		driver.quit();
	}
}
