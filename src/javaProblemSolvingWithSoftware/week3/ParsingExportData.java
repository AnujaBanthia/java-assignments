package javaProblemSolvingWithSoftware.week3;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class ParsingExportData {
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser,"Anguilla");

        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "cotton", "flowers");

        parser = fr.getCSVParser();
        int count= numberOfExporters(parser,"wool");
        System.out.println("Number of wool exporters: "+count);

        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");

    }
    public String countryInfo(CSVParser parser, String country) {
        for(CSVRecord record : parser) {
            String myCountry = record.get("Country");
            if(myCountry.equalsIgnoreCase(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                String info = myCountry + ": " + exports + ": " + value;
                return info;
            }
        }

        return "NOT FOUND";
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for(CSVRecord record : parser) {
            String exports = record.get("Exports");
            String country = record.get("Country");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(country);
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int numOfCountries = 0;
        for(CSVRecord record : parser) {
            String exports = record.get("Exports");
            if(exports.contains(exportItem)) {
                numOfCountries++;
            }
        }
        return numOfCountries;
    }

    public void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            String country = record.get("Country");

            if(value.length() > amount.length()) {
                System.out.println(country + ": " + value);
            }
        }
    }

    public static void main(String[] args) {
        ParsingExportData parsingExportData = new ParsingExportData();
        parsingExportData.tester();
    }
}
