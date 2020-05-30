package smartbytes.akash.datadriventest;

import org.testng.annotations.Test;

import smartbytes.restassured.utils.FileUtility;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class ExcelDataProviderTest {
	
  @SuppressWarnings("unchecked")
@Test(dataProvider = "customer_data")
  public void test_create_customer(Object[] records) {
	  List<String> customerRecord=new ArrayList<String>();
	  for(Object record : records) {
		 customerRecord =  (ArrayList<String>)record;
		  System.out.println(customerRecord.get(0));
	  }
	 
  }
 
  @DataProvider(name="customer_data")
  public Object[][] read_customer_data() {
	  String filePath="./resources/customers.csv";
		String separator=",";
		boolean ignoreFirstRow=true;
		
		List<List<String>> customerRecords = FileUtility.readFileData(filePath, separator, ignoreFirstRow);
		Object[][] records = new Object[][] { customerRecords.toArray()};
		return records;
  }
}
