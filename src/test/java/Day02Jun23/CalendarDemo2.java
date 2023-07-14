package Day02Jun23;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDemo2 {

	static WebDriver driver;

	static WebElement getWebElement(By by) {
		return driver.findElement(by);
	}

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1/login.do");

		By txtUserName = By.name("username");
		By txtPassword = By.name("pwd");
		By btnLogin = By.id("loginButton");

		By prevMonth = By.xpath("((//table[@class='mainSidesPadding'])[1]//tr[1]/td/table/tbody/tr/td)[13]/a");
		By nextMonth = By.xpath("((//table[@class='mainSidesPadding'])[1]//tr/td[3])[2]/a");

		getWebElement(txtUserName).sendKeys("admin");
		getWebElement(txtPassword).sendKeys("manager");
		getWebElement(btnLogin).click();

		LocalDate todaysDate = LocalDate.now();
		LocalDate selectedDate = LocalDate.of(2023, 9, 15);
		// y m d 15-Sep-2023

		int todaysDay = todaysDate.getDayOfMonth(); // 2
		int todaysMonth = todaysDate.getMonthValue(); // 6
		int todaysYear = todaysDate.getYear(); // 2023
		System.out.println("todaysDay   : " + todaysDay);
		System.out.println("todaysMonth : " + todaysMonth);
		System.out.println("todaysYear  : " + todaysYear);

		int selectedDay = selectedDate.getDayOfMonth(); // 2
		int selectedMonth = selectedDate.getMonthValue(); // 12
		int selectedYear = selectedDate.getYear(); // 2023
		System.out.println("selectedDay   : " + selectedDay);
		System.out.println("selectedMonth : " + selectedMonth);
		System.out.println("selectedYear  : " + selectedYear);

		boolean goNextMonths = true;
		int monthsDiff = 0;
		if (selectedDate.isAfter(todaysDate)) {
			goNextMonths = true;
			monthsDiff = selectedMonth - todaysMonth;
		} else {
			goNextMonths = false;
			monthsDiff = todaysMonth - selectedMonth;
		}
		System.out.println("monthsDiff: " + monthsDiff);

		while (monthsDiff > 0) {
			if (goNextMonths) {
				System.out.println("going in next month");
				getWebElement(nextMonth).click();
			} else {
				System.out.println("going in previous month");
				getWebElement(prevMonth).click();
			}
			monthsDiff--;
		}

		int day = selectedDate.getDayOfMonth(); // 2
		System.out.println("day: " + day);

		String part1 = "//table[@id='calendar_table']//tr//td//span[text()='";
		String part2 = "']";
		WebElement element = getWebElement(By.xpath(part1 + day + part2));
		element.click();
		driver.quit();
		

	}
}
