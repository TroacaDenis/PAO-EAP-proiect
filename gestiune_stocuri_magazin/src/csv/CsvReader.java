package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class CsvReader {
	
	private static CsvReader INSTANCE;
	
	private CsvReader() {
		
	}
	
	public static CsvReader getInstance() {
		if(INSTANCE == null) {
            INSTANCE = new CsvReader();
        }
        return INSTANCE;
	}
	
	public ArrayList<String []> readFromCsv(String path){
		ArrayList<String []> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    
		    while ((line = br.readLine()) != null) {
		        records.add(line.split(","));
		    }
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		return records;
	}
		
	
}
