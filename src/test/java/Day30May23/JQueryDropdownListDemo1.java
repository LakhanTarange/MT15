package Day30May23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDropdownListDemo1 {

	static void clickOnDropdownList(List<WebElement> low, String... choices) {
		for (WebElement element : low) {
			String option = element.getText();
			if (choices[0].equals("ALL"))
				element.click();
			else {
				for (String s : choices)
					if (s.equals(option))
						element.click();
			}
		}
	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//button[@class='comboTreeArrowBtn'])[1]")).click();
		List<WebElement> low = driver.findElements(
				By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//span[@class='comboTreeItemTitle']"));
		System.out.println("low.size : " + low.size());
		clickOnDropdownList(low, "choice 5", "choice 6 1", "choice 6 2 3", "choice 2");

		// clickOnDropdownList(low,"ALL");

	}
}
