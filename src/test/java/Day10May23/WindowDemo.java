package Day10May23;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowDemo {
	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.letskodeit.com/practice";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		/*
		 * //fieldset/button / -> immediate child // -> Indirect child
		 */
		WebElement btnOpenWindow = driver.findElement(By.xpath("//fieldset/button"));
		btnOpenWindow.click();

		Set<String> windIds = driver.getWindowHandles();
		Iterator<String> iter = windIds.iterator();
		String pWindId = iter.next();
		System.out.println("Parent wind Id : " + pWindId);
		String cWindId = iter.next();
		System.out.println("Child wind Id : " + cWindId);

		driver.switchTo().window(cWindId);
		String childActUrl = driver.getCurrentUrl();
		String childExpUrl = "https://www.letskodeit.com/courses";
		Thread.sleep(4000l);

		driver.close();
		driver.switchTo().window(pWindId);
		String parentActUrl = driver.getCurrentUrl();
		String parentExpUrl = "https://www.letskodeit.com/practice";

		if (childActUrl.equals(childExpUrl))
			System.out.println("test case#1 passed !!!");
		else
			System.out.println("test case#1 failed!!!");

		if (parentActUrl.equals(parentExpUrl))
			System.out.println("test case#2 passed !!!");
		else
			System.out.println("test case#2 failed!!!");

		Thread.sleep(4000l);
		driver.quit();

	}
}
