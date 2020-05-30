package smartbytes.akash.datadriventest;

import java.util.List;

import smartbytes.restassured.utils.FileUtility;

public class ReadDataFromCSVFile {
 
	public static void main(String[] args) {
		String filePath="./resources/customers.csv";
		String separator=",";
		boolean ignoreFirstRow=true;
		
		List<List<String>> productRecords = FileUtility.readFileData(filePath, separator, ignoreFirstRow);
		
		for(List<String> productRecord : productRecords) {
			System.out.println(productRecord);
		}
	}
}
