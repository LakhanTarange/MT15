package Day09May23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownListDemo {
	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.letskodeit.com/practice";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		WebElement ddl = driver.findElement(By.id("carselect"));
		Select select = new Select(ddl);
		
		select.selectByVisibleText("Honda"); Thread.sleep(2000l);
		select.selectByVisibleText("BMW");Thread.sleep(2000l);
		select.selectByVisibleText("Benz");Thread.sleep(5000l);
		
		select.selectByIndex(0);Thread.sleep(2000l);
		select.selectByIndex(1);Thread.sleep(2000l);
//		select.selectByIndex(23);Thread.sleep(2000l);  // NoSuchElementException
	
		
		select.selectByValue("honda");Thread.sleep(2000l);
		select.selectByValue("bmw");Thread.sleep(2000l);
		select.selectByValue("benz");Thread.sleep(2000l);
		
		/// check the options present in the list
		List<WebElement> lw = select.getOptions();
		for(WebElement element: lw)
			System.out.println(element.getText());
		
		driver.quit();
	}
}
