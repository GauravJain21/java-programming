package StringsSecondAssignments;

import StringsFirstAssignments.Part2;

public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int stopCodonIndex = dna.indexOf(stopCodon, startIndex + 3);
        return stopCodonIndex == -1? dna.length(): stopCodonIndex;
    }
    public int findSmallestStopCodon(String dna, int startIndex) {
        return Math.min(findStopCodon(dna, startIndex, "TAA"),
                Math.min(findStopCodon(dna, startIndex, "TAG"),
                        findStopCodon(dna, startIndex, "TGA")));
    }

    public int countAllGenes(String dna) {
        int startIndex = startIndex = dna.indexOf("ATG");
        int counter = 0;
        while (startIndex != -1) {
            int endIndex = findSmallestStopCodon(dna, startIndex);
            while (endIndex != dna.length() && (endIndex - startIndex)%3 != 0) {
                endIndex = findSmallestStopCodon(dna, endIndex + 3);
            }
            if(endIndex == dna.length()) {
                break;
            }
            counter++;
            startIndex = dna.indexOf("ATG", startIndex + 3);
        }
        return counter;
    }
    public void testCountGenes() {
        String[] dnas = {"AATGAAATAATATGGT", "ATG", "TAA", "AGGT", "ATGTAA", "gatgctataat", "ATGTAATGATAG", "ATGTAAATGTAGATGTGA"};
        for (String dna : dnas) {
            System.out.println("Genes in " + dna + ": " + countAllGenes(dna));
        }
    }
    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testCountGenes();
    }

}
