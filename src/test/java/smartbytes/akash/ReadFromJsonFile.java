package smartbytes.akash;


import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.path.json.JsonPath.*;
 
public class ReadFromJsonFile {
	public static void main(String[] args) {
		File booksFile=new File("./resources/books.json");

		List<Map<String,String>> bookDataByPage=from(booksFile).
				get("books.findAll { book ->  (book.pages>=700 && book.pages<=1000) }");
       System.out.println(bookDataByPage.size());	
	}

}