package Day11Jun23;

import org.testng.annotations.DataProvider;

public class DP {

	/**
	 * 
	 * @return
	 */
	@DataProvider(name = "DP1")
	public Object[][] getData1() {
		Object[][] data = { { "Sharukh", "Shah@123" }, { "Salman", "Sala@456" } };
		return data;
	}

	/**
	 * 
	 * @return
	 */
	@DataProvider(name = "DP2")
	public Object[][] getData2() {
		Object[][] data = { { "Hritik" }, { "Kartik" } };
		return data;
	}
}
