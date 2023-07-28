package Day24Jun23;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementPArtialScreenshotDemo {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement ddl = driver.findElement(By.xpath("//*[@id='multiple-select-example']"));

		fileCreationUsingFile(ddl, "dropdownlist1File");

		fileCreationUsingByte(ddl, "dropdownlist2Byte");

		fileCreationUsingBase64(ddl, "dropdownlist3Base64");

		driver.quit();
	}

	static void fileCreationUsingBase64(WebElement ddl, String fileName) throws IOException {
		String fName1 = ddl.getScreenshotAs(OutputType.BASE64);
		byte[] bfile = Base64.getDecoder().decode(fName1.getBytes(StandardCharsets.UTF_8));
		OutputStream stream = new FileOutputStream(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\ScreenshotPkg\\" + fileName + "_" + System.currentTimeMillis() + ".bmp");
		stream.write(bfile);
		stream.close();
	}

	static void fileCreationUsingByte(WebElement ddl, String fileName) throws IOException {

		byte[] fName = ddl.getScreenshotAs(OutputType.BYTES);
		String destFName = System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenshotPkg\\" + fileName + "_"
				+ System.currentTimeMillis() + ".png";
		OutputStream os = new FileOutputStream(destFName);
		os.write(fName);
		os.close();
	}

	static void fileCreationUsingFile(WebElement ddl, String fileName) throws IOException {
		File fName2 = ddl.getScreenshotAs(OutputType.FILE);
		String destFName2 = System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenshotPkg\\" + fileName + "_"
				+ System.currentTimeMillis() + ".png";
		FileUtils.copyFile(fName2, new File(destFName2));
	}
}
