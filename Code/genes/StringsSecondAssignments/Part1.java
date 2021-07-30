package StringsSecondAssignments;

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

    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
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

    public void printAllGenes(String dna) {
        int startIndex = startIndex = dna.indexOf("ATG");
        int counter = 0;
        while (startIndex != -1) {
            counter++;
            int endIndex = findSmallestStopCodon(dna, startIndex);
            while (endIndex != dna.length() && (endIndex - startIndex)%3 != 0) {
                endIndex = findSmallestStopCodon(dna, endIndex + 3);
            }
            if(endIndex == dna.length()) {
                break;
            }
            System.out.println("Gene no. " + counter + ": " + dna.substring(startIndex, endIndex + 3));
            startIndex = dna.indexOf("ATG", startIndex + 3);
        }
        return;
    }

    public void testFindStopCodon() {
        String[] dnas = {"AATGAAATAATATGGT", "ATG", "TAA", "AGGT", "ATGTAA", "gatgctataat"};
        for (String dna : dnas) {
            System.out.println("DNA strand is: " + dna);
            System.out.println("Index of " + "TAA: " + findStopCodon(dna, dna.indexOf("ATG"), "TAA"));
            System.out.println("Index of " + "TAG: " + findStopCodon(dna, dna.indexOf("ATG"), "TAG"));
            System.out.println("Index of " + "TGA: " + findStopCodon(dna, dna.indexOf("ATG"), "TGA"));
        }
    }

    public void testFindGene() {
        String[] dnas = {"AATGAAATAATATGGT", "ATG", "TAA", "AGGT", "ATGTAA", "gatgctataat", "ATGTAATGATAG", "ATGTAAATGTAGATGTGA"};
        for (String dna : dnas) {
            System.out.println("DNA strand is: " + dna);
            System.out.println("Gene is: " + findGene(dna));
            printAllGenes(dna);
        }
    }
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testFindStopCodon();
        part1.testFindGene();
    }
}




















