package Day30May23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JQueryDropdownListDemo {

	private static void clickOnDDOptions(List<WebElement> low, String... value) {
		for (WebElement ele : low) {
			for (String val : value) {
				if (ele.getText().equalsIgnoreCase(val))
					ele.click();
			}
		}
	}

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='justAnInputBox']/following-sibling::button")).click();

		List<WebElement> low = driver
				.findElements(By.xpath("(//div[@class='comboTreeWrapper'])[1]//span[@class='comboTreeItemTitle']"));
		clickOnDDOptions(low, "choice 6", "choice 4", "choice 6 2 1");

	}
}
