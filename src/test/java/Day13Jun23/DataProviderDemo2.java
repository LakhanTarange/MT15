package Day13Jun23;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo2 {

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
		int row = sheet.getLastRowNum();
		Object[] data = new Object[row]; // rows
		String header1 = sheet.getRow(0).getCell(0).getStringCellValue();
		String header2 = sheet.getRow(0).getCell(1).getStringCellValue();
		Map<String, String> m1;
		for (int r = 0; r < row; r++) {
			m1 = new HashMap<>();
			String value1 = sheet.getRow(r + 1).getCell(0).getStringCellValue();
			String value2 = sheet.getRow(r + 1).getCell(1).getStringCellValue();
			m1.put(header1, value1);
			m1.put(header2, value2);
			data[r] = m1;
		}

		return data;
	}
}
