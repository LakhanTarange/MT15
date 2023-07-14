package Day11Jun23;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionsDemo2 {

	@Test
	public void verifyHardAssrtion() {
		int actualI = 101;
		System.out.println("Begin test ");

//		Assert.assertTrue(actualI==expectedJ,"Error Msg");

//		Assert.assertFalse(actualI==expectedJ,"Error Msg");
//		if (actualI == 10)
//		Assert.fail("Intentionally failing test case becuase there is a associated defect ");

//		Assert.assertNotEquals(actualI, expectedJ, "Error Msg");

		if (actualI == 101)
			Assert.fail();

		System.out.println("End test ");
	}
}
