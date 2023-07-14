package Day11Jun23;

import org.testng.annotations.Test;

public class PaymentDemo {

	@Test(dataProvider = "DP1", dataProviderClass = DP.class)
	public void verifyPayment(String userName, String password) {
		System.out.println(userName + " : " + password);
	}
}
