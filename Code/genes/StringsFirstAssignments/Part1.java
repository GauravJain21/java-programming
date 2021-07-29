package StringsFirstAssignments;

public class Part1 {
    public String findGeneSimple(String dna) {
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1) {
            System.out.println("Gene doesn't exist in DNA");
            return "";
        }
        int endIndex = dna.indexOf("TAA", startIndex);
        if(endIndex == -1) {
            System.out.println("End of Gene doesn't exist");
            return "";
        }
        if((endIndex - startIndex)%3 != 0) {
            System.out.println("Invalid Length Gene");
            return "";
        }
        return dna.substring(startIndex, endIndex + 3);
    }
    public void testFindGeneSimple() {
        String[] dnas = {"AATGCGTAATATGGT", "ATG", "TAA", "AGGT", "ATGGTAA"};
        for(String dna: dnas) {
            System.out.println("DNA strand is " + dna);
            System.out.println("Gene is " + findGeneSimple(dna));
        }
        return;
    }
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testFindGeneSimple();
    }
}
