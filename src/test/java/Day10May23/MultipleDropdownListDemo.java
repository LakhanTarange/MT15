package Day10May23;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleDropdownListDemo {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.letskodeit.com/practice";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement multipleDropdownList = driver.findElement(By.id("multiple-select-example"));

		// Control+shift+o
		Select select = new Select(multipleDropdownList);

		System.out.println("isMultiple: " + select.isMultiple());

//			select.selectByIndex(0);
//			select.selectByIndex(1);
//			select.selectByIndex(2);

		List<WebElement> low = select.getOptions();
		for (int i = 0; i < low.size(); i++)
			select.selectByIndex(i);
		Thread.sleep(4000l);
		select.deselectByIndex(0);

		List<WebElement> selectedOptionsList = select.getAllSelectedOptions(); // 3
		System.out.println("selected options zie : " + selectedOptionsList.size());
		System.out.println("selected options ->");
		for (WebElement x : selectedOptionsList)
			System.out.println(x.getText());

		System.out.println("---------------------");
//			for(int i=0; i<low.size(); i++)
//				select.deselectByIndex(i);
		select.deselectAll();

		// want to print all options present in the list
		List<String> actList = new ArrayList<>();

		for (WebElement x : low) // enhanced for loop/modern for loop/forEach loop
		{
			System.out.println(x.getText());
			actList.add(x.getText());
		}
/*
		// Verify all the options present in the list with explist
		List<String> expList = new ArrayList<>(List.of("Apple","Orange","Peach"));
		if (expList.equals(actList))
			System.out.println("Test case#1 passed !!!!");
		else
			System.out.println("Test case#1 failed !!!!");

		if (expList.containsAll(actList))
			System.out.println("Test case#2 passed !!!!");
		else
			System.out.println("Test case#2 failed !!!!");

		// getAllSelectedOptions
		 
		 */
		Thread.sleep(4000l);
		driver.quit();
	}

}
