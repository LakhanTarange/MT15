package Day01Jun23;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopertiesFileUsage {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;

		String fileName = System.getProperty("user.dir") + "/src/test/java/Day01Jun23/configactitime.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(fileName);
		prop.load(fis);

		String br = (String) prop.get("browser");
		if (br.equalsIgnoreCase("CHROME"))
			driver = new ChromeDriver();
		else if (br.equalsIgnoreCase("EDGE"))
			driver = new EdgeDriver();
		else if (br.equalsIgnoreCase("FIREFOX"))
			driver = new FirefoxDriver();

		String url = (String) prop.get("url");
		driver.get(url);
		String max = (String) prop.get("maximizeWindow");
		if (max.equalsIgnoreCase("true"))
			driver.manage().window().maximize();

		String timeout = (String) prop.get("timeout");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(timeout)));

	} 
}
