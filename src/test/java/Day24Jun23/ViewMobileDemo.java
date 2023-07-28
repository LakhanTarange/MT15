package Day24Jun23;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewMobileDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
			
		Map<String, Object> deviceMetrics = new  HashMap<>();
		deviceMetrics.put("width", 300);
		deviceMetrics.put("height", 500);
		deviceMetrics.put("deviceScaleFactor", 25);
		deviceMetrics.put("mobile", true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		
	 	driver.get("https://www.w3schools.com/");
		//	driver.get("https://amazon.com");
		
	}
}
