package Day11Jun23;

import org.testng.annotations.Test;

public class ShippingDemo {

	@Test(dataProvider = "DP2", dataProviderClass = DP.class)
	public void verifyPayment(String userName) {
		System.out.println(userName);
	}
}
