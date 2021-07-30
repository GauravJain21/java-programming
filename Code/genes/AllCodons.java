public class AllCodons {
    int findStopCodon(String dna, int index) {
        int minIndex = Integer.MAX_VALUE;
        String[] stopCodons = {"TAA", "TAG", "TGA"};
        for(String codon: stopCodons) {
            int endIndex = dna.indexOf(codon, index);
            if(endIndex != -1) {
                minIndex = Math.min(minIndex, endIndex);
            }
        }
        return minIndex == Integer.MAX_VALUE? -1: minIndex;
    }

    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        int pivotIndex = startIndex + 3;
        if(startIndex == -1) {
            return "";
        }
        int endIndex = findStopCodon(dna, pivotIndex);
        if(endIndex == -1) {
            return "";
        }
        while(endIndex != -1 && (endIndex - pivotIndex)%3 != 0) {
            pivotIndex = endIndex + 3;
            endIndex = findStopCodon(dna, pivotIndex);
        }
        if(endIndex != -1) {
            return dna.substring(startIndex, endIndex + 3);
        }
        return "";
    }

    public void testing() {
        String[] dnas = {"AATGAAATAATATGGT", "ATG", "TAA", "AGGT", "ATGTAA", "gatgctataat"};
        for(String dna: dnas) {
            System.out.println("DNA strand is " + dna);
            System.out.println("Gene is " + findGene(dna));
        }
        return;
    }

    public static void main(String[] args) {
        AllCodons allCodons = new AllCodons();
        allCodons.testing();
    }
}
