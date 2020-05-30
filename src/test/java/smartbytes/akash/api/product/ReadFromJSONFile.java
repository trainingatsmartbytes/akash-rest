package smartbytes.akash.api.product;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.path.json.JsonPath.*;

public class ReadFromJSONFile {

    public static List<Map<String,String>> filterProductsByCurrency(String currencyCode){
		File productFile= new File("./resources/products.json"); // 1200-1250 - 10 products - 1300
		List<Map<String, String>> productData= from(productFile).get("products.findAll{product -> product.CurrencyCode == '"+currencyCode+"' }");
		
		Map<String,String> product = from(productFile).get("products[1]");
		productData.add(product);
		return productData;
    }
	public static void main(String[] args) {
		
		File productFile= new File("./resources/products.json"); // 1200-1250 - 10 products - 1300
		List<Map<String, String>> productData= from(productFile).get("products");
//		for(Map<String, String> product : productData) {
//			System.out.println(product.get("ProductId"));
//		}
		//Read single product
		Map<String, String> product = from(productFile).get("products[2]");
		System.out.println(product);
		
//		List<Map<String, String>> productsByPrice= from(productFile).
//											get("products.findAll { product->  ( product.Price <1200 && product.Price >1250 ) }");
//	    int totalProducts= productsByPrice.size();
//	   System.out.println("Products in price range 1200-1250 =" + totalProducts);
//		for(Map<String, String> p : productsByPrice) {
//		System.out.println(p);
	
		List<Map<String, String>> productsByCurrency= filterProductsByCurrency("USD");
		
		int totalProducts= productsByCurrency.size();
		   System.out.println("Products by currency USD =" + totalProducts);
			for(Map<String, String> p : productsByCurrency) {
			 System.out.println(p);
			 if(!"USD".equals(p.get("CurrencyCode"))) {
				 System.err.println("FOUND INVALID CURRENCY CODE IN PRODUCTS");
			 }
			}
			
	}
	
}
