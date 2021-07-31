import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.Locale;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest) {
        for (CSVRecord record : parser) {
            if(record.get("Exports").contains(exportOfInterest)) {
                System.out.println(record.get("Country"));
            }
        }
    }
    public void testListExporters() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String exportOfInterest = "coffee";
        listExporters(parser, exportOfInterest);
    }
    public static void main(String[] args) {
        WhichCountriesExport obj = new WhichCountriesExport();
        obj.testListExporters();
    }

}
