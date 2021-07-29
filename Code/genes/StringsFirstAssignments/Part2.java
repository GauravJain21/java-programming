package StringsFirstAssignments;

import java.util.Locale;

public class Part2 {
    public String findGeneSimple(String dna, String startCodon, String stopCodon) {
        String dnaLowerCase = dna.toLowerCase();
        startCodon = startCodon.toLowerCase();
        stopCodon = stopCodon.toLowerCase();
        int startIndex = dnaLowerCase.indexOf(startCodon);
        if(startIndex == -1) {
            System.out.println("Gene doesn't exist in DNA");
            return "";
        }
        int endIndex = dnaLowerCase.indexOf(stopCodon, startIndex + startCodon.length());
        if(endIndex == -1) {
            System.out.println("End of Gene doesn't exist");
            return "";
        }
        if((endIndex - startIndex)%3 != 0) {
            System.out.println("Invalid Length Gene");
            return "";
        }
        return dna.substring(startIndex, endIndex + stopCodon.length());
    }
    public void testFindGeneSimple() {
        String[] dnas = {"AATGCGTAATATGGT", "ATG", "TAA", "AGGT", "ATGTAA", "gatgctataat"};
        for(String dna: dnas) {
            System.out.println("DNA strand is " + dna);
            System.out.println("Gene is " + findGeneSimple(dna, "ATG", "TAA"));
        }
        return;
    }
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        part2.testFindGeneSimple();
    }
}
