package Day01Jun23;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFielREadingDemo {

	public static void main(String[] args) throws IOException {

		String fileName = "H:/CSBatch4849Selenium/SeleniumBatch4849WorkSpace/JaguarNewSeleniumCSTBatch5354/src/test/java/day1Jun23/config.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(fileName);

		prop.load(fis);

		String browser = (String) prop.get("browser");
		System.out.println("Browser : " + browser);

		String maxWindow = (String) prop.get("maximizeWindow");
		System.out.println("maxWindow: " + maxWindow);

		String to = (String) prop.get("timeout");
		String city = (String) prop.get("city");
		String age = (String) prop.get("age");
		String wt = (String) prop.get("weight");
		System.out.println("timeout : " + to);
		System.out.println("city    : " + city);
		System.out.println("age     : " + age);
		System.out.println("wt      : " + wt);
		float wt1 = Float.parseFloat(wt) + 100;
		System.out.println(wt1);

	}
}
