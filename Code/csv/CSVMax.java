import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

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

    public CSVRecord hottestHourInManyDays() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord hottestHour = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f.getAbsolutePath());
            CSVParser parser = fr.getCSVParser();
            CSVRecord currHottestHour = hottestHourInFile(parser);
            double currentTemp = Double.parseDouble(currHottestHour.get("TemperatureF"));
            if(hottestHour == null || currentTemp > Double.parseDouble(hottestHour.get("TemperatureF"))) {
                hottestHour = currHottestHour;
            }
        }
        return hottestHour;
    }

    public void tester() {
        //FileResource fr = new FileResource();
        //CSVParser parser = fr.getCSVParser();
        //System.out.println(hottestHourInFile(parser));
        System.out.println(hottestHourInManyDays());

    }
    public static void main(String[] args) {
        CSVMax obj = new CSVMax();
        obj.tester();
    }
}
