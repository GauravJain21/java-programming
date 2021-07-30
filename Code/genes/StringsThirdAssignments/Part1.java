package StringsThirdAssignments;

import edu.duke.StorageResource;

public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int stopCodonIndex = dna.indexOf(stopCodon, startIndex + 3);
        return stopCodonIndex == -1? dna.length(): stopCodonIndex;
    }
    public int findSmallestStopCodon(String dna, int startIndex) {
        return Math.min(findStopCodon(dna, startIndex, "TAA"),
                Math.min(findStopCodon(dna, startIndex, "TAG"),
                        findStopCodon(dna, startIndex, "TGA")));
    }

    public String findGene(String dna, int startIndex) {
        startIndex = dna.indexOf("ATG", startIndex);
        if(startIndex == -1) {
            return "";
        }
        int endIndex =  findSmallestStopCodon(dna, startIndex);
        while (endIndex != dna.length() && (endIndex - startIndex)%3 != 0) {
            endIndex = findSmallestStopCodon(dna, endIndex + 3);
        }
        if(endIndex == dna.length()) {
            return "";
        }
        return dna.substring(startIndex, endIndex + 3);
    }
    public StorageResource getAllGenes(String dna) {
        int startIndex = dna.indexOf("ATG");
        StorageResource geneList = new StorageResource();
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if(currentGene.isEmpty()) {
                break;
            }
            geneList.add(currentGene);
            startIndex += currentGene.length();
        }
        return geneList;
    }
    public void testGetAllGene() {
        String[] dnas = {"AATGAAATAATATGGT", "ATG", "TAA", "AGGT", "ATGTAA", "gatgctataat", "ATGTAATGATAG", "ATGTAAATGTAGATGTGA"};
        for (String dna : dnas) {
            System.out.println("DNA strand is: " + dna);
            StorageResource geneList = getAllGenes(dna);
            for (String gene : geneList.data()) {
                System.out.println("Gene is: " + gene);
            }
        }
    }
    public static void main(String[] args) {
        Part1 driver = new Part1();
        driver.testGetAllGene();
    }
}
