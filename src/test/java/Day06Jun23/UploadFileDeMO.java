package Day06Jun23;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileDeMO {
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to(
				"https://www.monsterindia.com/seeker/registration?spl=IN-Acq-SEM-Google-Core_Brand_Old_BMM_Web_S-GSN-Core_Brand_Old-%2Bmonster-desktop-Brand---388396137523---CPC-6645446156&utm_campaign=IN_Acq_SEM-Google-Core_Brand_Old_BMM_Web_S-GSN-Core_Brand_Old-%2Bmonster-&utm_medium=SEM&utm_source=Google-GSN-CPC&utm_term=SEM_%2Bmonster&gclid=CjwKCAjw8KmLBhB8EiwAQbqNoC6kJ8TSNKOabGn59JegPBGPFv5h_qYAoyom5vp17qUnmWk7fLsT3xoCG2QQAvD_BwE");

		// click on "Choose CV" button
		driver.findElement(By.xpath("//div[@class='uploadResumeCont']")).click();

		Thread.sleep(4000l);
		// Enter file to upload using window's Open dialogue window
		try {
			Process p = Runtime.getRuntime().exec("C:\\Users\\taran\\OneDrive\\Desktop\\AutoIT\\FileUp");
			Thread.sleep(4000l);
			int retValue = p.waitFor();
			System.out.println("retValue: " + retValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("File was not uploaded properly");
		}

		String txtOkay = driver.findElement(By.xpath("//div[@id='popup-card']//div[2]/div")).getText();
		System.out.println("txtOkay: " + txtOkay);

		Thread.sleep(2000l);
		driver.quit();
	}
}
