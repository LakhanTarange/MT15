package Day30May23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDropdownListDemo2 {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//button[@class='comboTreeArrowBtn'])[1]")).click();
		List<WebElement> low = driver.findElements(
				By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//span[@class='comboTreeItemTitle']"));
		System.out.println("low.size : " + low.size());
		for (WebElement element : low) {
			String option = element.getText();
			if (option.equals("choice 3") || option.equals("choice 2 1"))
				element.click();
			System.out.println(option);
		}

	}
}
