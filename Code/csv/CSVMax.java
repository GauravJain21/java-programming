import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class CSVMax {
    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar) {
        if(largestSoFar == null) {
            largestSoFar = currentRow;
        }
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestSoFarTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if(currentTemp > largestSoFarTemp) {
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }

    public CSVRecord hottestHourInFile(CSVParser parser) {
        double maxTemp = 0;
        CSVRecord maxRecord = null;
        for (CSVRecord record : parser) {
            maxRecord = getLargestOfTwo(record, maxRecord);
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
            hottestHour = getLargestOfTwo(currHottestHour, hottestHour);
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
