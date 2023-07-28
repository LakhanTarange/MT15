package Day17Jun23;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

 class GroupsDemo {

	@Parameters({ "browser", "env", "responseCodes" })
	@Test(groups = { "cars" })
	public void testBMW(String browserName, String envName, String rcs) {
		System.out.println("browserName   : " + browserName);
		System.out.println("envName       : " + envName);
		System.out.println("response codes: " + rcs);

		String[] rc = rcs.split(",");
		for (String s : rc)
			System.out.println(Integer.parseInt(s) + 100);

		System.out.println("BMW method...");
	}

	@Test(groups = { "cars" })
	public void testBenz() {
		System.out.println("Benz method...");
	}

	@Test(groups = { "cars", "bikes" })
	public void testHonda() {
		System.out.println("Honda method...");
	}

	@Test(groups = { "bikes" })
	public void testYamaha() {
		System.out.println("Yamha method...");
	}

	@Test(groups = { "bikes" })
	public void testBajaj() {
		System.out.println("Bajaj method...");
	}
}
