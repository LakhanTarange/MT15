package Day11Jun23;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo1 {

	@Test(dataProvider = "DP")
	public void verifyLogin(HashMap<String, String> map) {
		System.out.println(map.get("userName") + " : " + map.get("password"));
	}

	@DataProvider(name = "DP")
	public Object[] getData() {

		Object[] data = new Object[4]; // rows

		Map<String, String> m1 = new HashMap<>();
		m1.put("userName", "Sharad");
		m1.put("password", "Pawar@123");
		data[0] = m1;

		Map<String, String> m2 = new HashMap<>();
		m2.put("userName", "Modi");
		m2.put("password", "Modi@456");
		data[1] = m2;

		Map<String, String> m3 = new HashMap<>();
		m3.put("userName", "Yogi");
		m3.put("password", "Yogi@678");
		data[2] = m3;

		Map<String, String> m4 = new HashMap<>();
		m4.put("userName", "Amit");
		m4.put("password", "Amit@910");
		data[3] = m4;

		return data;
	}
}
