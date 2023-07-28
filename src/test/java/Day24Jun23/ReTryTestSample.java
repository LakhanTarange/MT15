package Day24Jun23;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReTryTestSample {

	@Test(retryAnalyzer=MyRetry.class)
	public void Test1()
	{
		System.out.println("Test1 executed");
		Assert.assertTrue(1==1, "Test1 Failed due to mismatch of condition");
	}
	
	@Test(retryAnalyzer=MyRetry.class)
	public void Test2()
	{
	 	Random rn = new Random();
		int x = rn.nextInt(5);
		System.out.println("x = " + x);
		System.out.println("Test2 executed");
		Assert.assertTrue(4==x, "Test2 Failed due to mismatch of condition");
	 
//		Assert.assertTrue(4==5, "Test2 Failed due to mismatch of condition");	
	}
}
