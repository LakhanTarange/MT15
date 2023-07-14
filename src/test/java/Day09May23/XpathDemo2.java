package Day09May23;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo2 {
	public static void main(String[] args) {
		String url = "https://www.letskodeit.com/practice";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
	
		List<String> expAl = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("Radio Button Example1");
			add("Checkbox Example2");
			add("Switch Window Example3");
			add("Switch Tab Example");
			add("Select Class Example");
			add("Multiple Select Example");
			add("Auto Suggest Example");
			add("Enabled/Disabled Example");
			add("Element Displayed Example");
			add("Switch To Alert Example");
			add("Mouse Hover Example");
			add("Web Table Example");
			add("iFrame Example");
		}
	};
		
	List<WebElement> lwe = driver.findElements(By.xpath("//legend"));
	List<String> actAl = new ArrayList<String>();
	for(WebElement we : lwe)
	{
		actAl.add(we.getText());
		System.out.println(we.getText()); 
	}
	
	boolean res = actAl.equals(expAl);
	if (res)
		System.out.println("test case passed !!");
	else
	{	
		System.out.println("test case failed !!");
		actAl.retainAll(expAl);
		expAl.removeAll(actAl);
		System.out.println(expAl);
	}
	
	
	driver.quit( );
	}
}
