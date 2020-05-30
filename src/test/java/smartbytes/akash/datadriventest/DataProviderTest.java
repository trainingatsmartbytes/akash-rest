package smartbytes.akash.datadriventest;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
	
  @Test(dataProvider = "dp")
  public void get_country_by_iso2code(Object [] data) {
	  System.out.println(data[0]);
  }
 
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "IN", "IND","India" },
      new Object[] { "US", "USA","United States of America" },
    };
    
    
  }
}
