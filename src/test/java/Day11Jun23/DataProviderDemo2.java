package Day11Jun23;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo2 {

	// Wrong example you should create different hashmap for every data set

	@Test(dataProvider = "DP")
	public void verifyLogin(HashMap<String, String> map) {
		System.out.println(map.get("userName") + " : " + map.get("password"));
	}

	@DataProvider(name = "DP")
	public Object[] getData() {
		// overwriting of m1

		Object[] data = new Object[4]; // rows

		Map<String, String> m1 = new HashMap<>();
		m1.put("userName", "Sharad");
		m1.put("password", "Pawar@123");
		data[0] = m1;

		m1.put("userName", "Modi");
		m1.put("password", "Modi@456");
		data[1] = m1;

		m1.put("userName", "Yogi");
		m1.put("password", "Yogi@678");
		data[2] = m1;

		m1.put("userName", "Amit");
		m1.put("password", "Amit@910");
		data[3] = m1;

		return data;
	}
}
