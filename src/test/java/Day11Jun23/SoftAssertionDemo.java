package Day11Jun23;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionDemo {
	@Test
	public void verifySoftAssertion() {
		int i = 11, j = 10;
		String s1 = "Cyber1", s2 = "Cyber";
		float f1 = 1.3f, f2 = 1.2f;

		/*
		 * hard assertion stops the execution where validation fails
		 * Assert.assertEquals(i, j); Assert.assertEquals(s1, s2);
		 * Assert.assertEquals(f1, f2);
		 */
		
		System.out.println("Begin test");
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(i, j, "i is not equal to j");
		sa.assertEquals(s1, s2, "s1 is not equal to s2");
		sa.assertEquals(f1, f2, "f1 is not equal to f2");

		sa.assertAll();

		System.out.println("End test");

	}
}
