import edu.duke.FileResource;
import jdk.swing.interop.SwingInterOpUtils;
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
    public String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            if(record.get("Country").equals(country)) {
                return (country + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
            }
        }
        return "NOT FOUND";
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            if(record.get("Exports").contains(exportItem)) {
                ++count;
            }
        }
        return count;
    }

    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if(value.length() > amount.length()) {
                System.out.println(record.get("Country") + " " + value);
            }
        }
    }

    public void tester() {
        FileResource fr = new FileResource("/Users/gauravjain/Desktop/Java Programming- Solving Problems with Software/Projects/Code/csv/exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        String exportOfInterest = "coffee";
        //listExporters(parser, exportOfInterest);
        parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Germany"));
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "gold"));
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
    }

    public static void main(String[] args) {
        WhichCountriesExport obj = new WhichCountriesExport();
        obj.tester();
    }

}
