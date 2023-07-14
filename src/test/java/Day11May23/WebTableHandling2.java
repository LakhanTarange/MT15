package Day11May23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling2 {
	public static void main(String[] args) throws InterruptedException {

		String url = "https://www.letskodeit.com/practice";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		String part1 = "//table[@id='product']//tr[";
		String part2 = "]/td[";
		String part3 = "]";
		String nXpath;
		for (int r = 2; r < 5; r++) {
			for (int c = 1; c < 4; c++) {
				nXpath = part1 + r + part2 + c + part3;
				String ele = driver.findElement(By.xpath(nXpath)).getText();
				System.out.print(String.format("%-35s", ele));
			}
			System.out.println();
		}

		driver.quit();

	}
}
