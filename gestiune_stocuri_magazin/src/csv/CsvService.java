package csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class CsvService {
	
	private static CsvService INSTANCE;
	
	private CsvService() {
		
	}
	
	public static CsvService getInstance() {
		if(INSTANCE == null) {
            INSTANCE = new CsvService();
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
	
	public void writeToCsv(String path, ArrayList<String[]> records) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			records.stream().map(x->String.join(",", x)).forEach(y->{
				try {
					bw.write(y);
					bw.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			bw.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void auditCsv(String path, ArrayList<ArrayList<String>> records) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
			records.stream().map(x->String.join(",", x)).forEach(y->{
				try {
					bw.write(y);
					bw.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			bw.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
