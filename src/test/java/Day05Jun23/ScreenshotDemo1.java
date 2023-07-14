package Day05Jun23;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotDemo1 {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		driver = new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		capturescreenshot();
		driver.quit();
	}

	public static void capturescreenshot() throws IOException {
		Screenshot screenShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		ImageIO.write(screenShot.getImage(), "png",
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenshotPkg\\error.jpg"));
	}
}
