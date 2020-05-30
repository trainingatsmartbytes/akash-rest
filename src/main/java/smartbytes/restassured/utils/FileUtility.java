package smartbytes.restassured.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

	/**
	 * Reads data from file
	 * @param filePath	 path to file
	 * @param separator  data separator (e.g ; or |)
	 * @param 
	 * @return
	 */
	public static List<List<String>> readFileData(String filePath, String separator,boolean ignoreFirstRow) {

		List<List<String>> fileData = new ArrayList<List<String>>();
		List<String> rowData = null;

		BufferedReader br = null;

		String st;

		try {
			br = new BufferedReader(new FileReader(new File(filePath)));
			int rowIdx=0;
			while ((st = br.readLine()) != null) {
				rowData = new ArrayList<String>();
				for(String value: st.split(separator)) {
					rowData.add(value);
				}
				if(ignoreFirstRow) {
					if(rowIdx !=0)
					fileData.add(rowData);
				}else {
					fileData.add(rowData);
				}
				rowIdx++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileData;
	}
}
