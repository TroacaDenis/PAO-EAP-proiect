package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class CsvWriter {
	
	private static CsvWriter INSTANCE;
	
	private CsvWriter() {
		
	}
	
	public static CsvWriter getInstance() {
		if(INSTANCE == null) {
            INSTANCE = new CsvWriter();
        }
        return INSTANCE;
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
	
	
}
