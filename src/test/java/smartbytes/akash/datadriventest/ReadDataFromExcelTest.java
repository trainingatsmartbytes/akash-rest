package smartbytes.akash.datadriventest;

import java.util.List;

import smartbytes.restassured.utils.ExcelUtility;

public class ReadDataFromExcelTest {

	public static void main(String[] args) {
		String excelFilePath="/Users/sys/Documents/restassured/SmartBytes_API_TestData.xlsx";
		String sheetName="Customers";
		
		List<List<String>> productRecords = ExcelUtility.readExcelData(excelFilePath, sheetName);
		
		for(List<String> productRecord : productRecords) {
			System.out.println(productRecord);
		}
	}
}
