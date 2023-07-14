package Day13Jun23;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo1 {
	@Test(dataProvider = "DP")
	public void verifyLogin(HashMap<String, String> map) {
		System.out.println(map.get("username") + " : " + map.get("password"));
	}

	@DataProvider(name = "DP")
	public Object[] getData() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Credentials.xlsx");
		String sheetName = "PlayerInfo";
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		Object[] data = new Object[5]; // rows

		String header1 = sheet.getRow(0).getCell(0).getStringCellValue();
		String header2 = sheet.getRow(0).getCell(1).getStringCellValue();

		Map<String, String> m1 = new HashMap<>();
		String value1 = sheet.getRow(1).getCell(0).getStringCellValue();
		String value2 = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(header1 + " : " + value1);
		System.out.println(header2 + " : " + value2);
		m1.put(header1, value1);
		m1.put(header2, value2);
		data[0] = m1;

		Map<String, String> m2 = new HashMap<>();
		value1 = sheet.getRow(2).getCell(0).getStringCellValue();
		value2 = sheet.getRow(2).getCell(1).getStringCellValue();
		m2.put(header1, value1);
		m2.put(header2, value2);
		data[1] = m2;

		Map<String, String> m3 = new HashMap<>();
		value1 = sheet.getRow(3).getCell(0).getStringCellValue();
		value2 = sheet.getRow(3).getCell(1).getStringCellValue();
		m3.put(header1, value1);
		m3.put(header2, value2);
		data[2] = m3;

		Map<String, String> m4 = new HashMap<>();
		value1 = sheet.getRow(4).getCell(0).getStringCellValue();
		value2 = sheet.getRow(4).getCell(1).getStringCellValue();
		m4.put(header1, value1);
		m4.put(header2, value2);
		data[3] = m4;

		Map<String, String> m5 = new HashMap<>();
		value1 = sheet.getRow(5).getCell(0).getStringCellValue();
		value2 = sheet.getRow(5).getCell(1).getStringCellValue();
		m5.put(header1, value1);
		m5.put(header2, value2);
		data[4] = m5;
		
		return data;
	}
}
