package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public final class CsvAudit {
	
	private static CsvAudit INSTANCE;
	
	private CsvAudit() {
		
	}
	
	public static CsvAudit getInstance() {
		if(INSTANCE == null) {
            INSTANCE = new CsvAudit();
        }
        return INSTANCE;
	}

	public void auditCsv(String path, String[] record) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
			bw.write(String.join(", ", record));
			bw.newLine();
			bw.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
