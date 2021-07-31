import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser) {
        double maxTemp = 0;
        CSVRecord maxRecord = null;
        for (CSVRecord record : parser) {
            double currentTemp = Double.parseDouble(record.get("TemperatureF"));
            if (maxTemp < currentTemp) {
                maxTemp = currentTemp;
                maxRecord = record;
            }
        }
        return maxRecord;
    }

    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(hottestHourInFile(parser));
    }
    public static void main(String[] args) {
        CSVMax obj = new CSVMax();
        obj.tester();
    }
}
