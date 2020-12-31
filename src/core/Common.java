package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {
	public WebDriver webDriver;

	public void initBrowser() {
		System.setProperty("webdriver.chrome.driver",
		System.getProperty("user.dir") + "/browserDrivers/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static Map<String, String> getMapData() throws IOException {
		Map<String, String> testData = new HashMap<String, String>();
		try{
			FileInputStream fileInputStream = new FileInputStream("D:\\Auto\\QLNV\\testdata\\testdata.xlsx");
			Workbook workBook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workBook.getSheetAt(0);
			int lastRowNumber = sheet.getLastRowNum();
			for(int i = 0; i <= lastRowNumber; i++) {
				Row row = sheet.getRow(i);
				Cell keycell = row.getCell(0);
				String key = keycell.getStringCellValue().trim();
				Cell valueCell = row.getCell(1);
				String value = valueCell.getStringCellValue().trim();
				testData.put(key, value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return testData;
	}
	
	public static List<Map<String, String>> getTestDataInMap() throws IOException {
		List<Map<String, String>> testDataAllRows = null;
		Map<String, String> testData = null;
		try{
			FileInputStream fileInputStream = new FileInputStream("D:\\Auto\\QLNV\\testdata\\testdata.xlsx");
			Workbook workBook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workBook.getSheetAt(0);
			int lastRowNumber = sheet.getLastRowNum();
			int lastColNumber = sheet.getRow(0).getLastCellNum();
			List list = new ArrayList();
			for(int i = 0; i < lastColNumber; i++) {
				Row row = sheet.getRow(0);
				Cell cell = row.getCell(i);
				String rowHeader = cell.getStringCellValue().trim();
				list.add(rowHeader);
			}
			testDataAllRows = new ArrayList<Map<String, String>>();
			for(int j = 1; j <= lastRowNumber; j++) {
				Row row = sheet.getRow(j);
				testData = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
				for(int k = 0; k < lastColNumber; k++) {
					Cell cell = row.getCell(k);
					String colValue = cell.getStringCellValue().trim();
					testData.put((String) list.get(k), colValue);
				}
				testDataAllRows.add(testData);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return testDataAllRows;
	}
	
}
