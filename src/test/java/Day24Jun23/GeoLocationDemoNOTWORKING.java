package Day24Jun23;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocationDemoNOTWORKING {

	public static void main(String[] args) throws InterruptedException {

	 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		
		  Map<String, Object> coordinates = new HashMap<String, Object>();
		  //spain
		  coordinates.put("latitude",  40.463667 ); 
		  coordinates.put("longitude",  3.74922);
		  coordinates.put("accuracy", 1);
		 
			/*
			 * Map<String, Object> params = new HashMap<>(); params.put("latitude",
			 * 51.5055); params.put("longitude", 0.0754); params.put("accuracy", 1);
			 
		driver.executeCdpCommand("Emulation.setGeolocationOverride", params);
*/
		  

		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("https://google.com");

		
		//		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
//		driver.findElement(By.xpath("(//*[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
		
		driver.findElement(By.name("q")).sendKeys("amazon prime", Keys.ENTER);
		Thread.sleep(5000l);
		driver.findElement(By.xpath("//*[@id='tads']/div[1]/div/div/div/div[1]/a/div[1]/div/span")).click();
		System.out.println("header: " + driver.findElement(By.xpath("(//h1)[1]")).getText());
	}
}
