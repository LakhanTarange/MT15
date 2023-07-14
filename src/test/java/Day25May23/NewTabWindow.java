package Day25May23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class NewTabWindow {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");
		String pWindow = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.amazon.com");
		String cWindow = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com");

		driver.close();
		driver.switchTo().window(cWindow);
		driver.close();
		driver.switchTo().window(pWindow);
		driver.close();

	}
}
