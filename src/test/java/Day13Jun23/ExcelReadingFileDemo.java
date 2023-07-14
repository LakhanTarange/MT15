package Day13Jun23;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReadingFileDemo {

	@Test
	public void readExcel() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");

		String sheetName = "PlayerInfo";

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		// row starts with 0
		// col starts with 1
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();

		System.out.println("row : " + row);
		System.out.println("col : " + col);
		String val = "";
		for (int r = 1; r <= row; r++) {
			for (int c = 0; c < col; c++) {
				val = sheet.getRow(r).getCell(c).getStringCellValue();
				System.out.print(String.format("%-12s", val));
			}
			System.out.println();
		}

	}
}
