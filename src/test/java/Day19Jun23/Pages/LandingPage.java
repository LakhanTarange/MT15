package Day19Jun23.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LandingPage {

	WebDriver driver;
	
	By labelMyAction = By.xpath("//p[text()='My Actions']");
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void verifyTitle(String expTitle)
	{
		Assert.assertEquals(driver.getTitle(),expTitle,"Exp Title does not match actual title");
	}
	
	public void verifyUrl(String expUrl)
	{
		Assert.assertEquals(driver.getCurrentUrl() ,expUrl,"Exp Url does not match actual Url");
	}
	
	public void verifyMyActions(String expMyActionsLabel)
	{
		String actMyActionsLable= driver.findElement(labelMyAction).getText();
		Assert.assertEquals(expMyActionsLabel, actMyActionsLable);
		
		
		
		
	}
	
	
	
}
