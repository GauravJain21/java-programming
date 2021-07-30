package StringsThirdAssignments;

import edu.duke.StorageResource;

public class Part2 {
    private final String[] dnas = {"AATGAAATAATATGGT", "ATG", "TAA", "AGGT", "ATGTAA", "gatgctataat", "ATGTAATGATAG", "ATGTAAATGTAGATGTGA", "CG"};
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
    public double cgRatio(String dna) {
        if (dna.length() == 0) {
            System.out.println("Zero length dna");
            return 0;
        }
        double cgCount = 0;
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'C' || dna.charAt(i) == 'G') {
                cgCount++;
            }
        }
        return cgCount/dna.length();
    }
    public int countCTG(String dna) {
        int count = 0, startIndex = dna.indexOf("CTG");
        while (startIndex != -1) {
            count++;
            startIndex = dna.indexOf("CTG", startIndex + 3);
        }
        return count;
    }

    public void processGenes(StorageResource sr) {
        int longerThanNineCharCount = 0, cgRatioCount = 0, longestGeneLength = 0;
        StorageResource longerStrings = new StorageResource();
        StorageResource cgRatioStrings = new StorageResource();
        for (String str : sr.data()) {
            if (str.length() > 9) {
                longerThanNineCharCount++;
                longerStrings.add(str);
            }
            if (cgRatio(str) > 0.35) {
                cgRatioCount++;
                cgRatioStrings.add(str);
            }
            StorageResource geneList = getAllGenes(str);
            for (String gene : geneList.data()) {
                longestGeneLength = Math.max(longestGeneLength, gene.length());
            }
        }
        System.out.println("Count of strings longer than 9 character: " + longerThanNineCharCount);
        if(longerThanNineCharCount != 0) {
            for (String str : longerStrings.data()) {
                System.out.println(str);
            }
        }
        System.out.println("Count of Strings with cg Ratio greater than 0.35: " + cgRatioCount);
        if (cgRatioCount != 0) {
            for (String str : cgRatioStrings.data()) {
                System.out.println(str);
            }
        }
        System.out.println("Longest Gene Length: " + longestGeneLength);
    }
    public void testCgRatio() {
        for (String str : dnas) {
            System.out.println("DNA strand is: " + str);
            System.out.println("CG Ratio is: " + cgRatio(str));
        }
    }
    public void testCTGCount() {
        for (String str : dnas) {
            System.out.println("DNA strand is: " + str);
            System.out.println("CTG Count is: " + countCTG(str));
        }

    }
    public void testProcessGene() {
        StorageResource dnaList = new StorageResource();
        for (String dna : dnas) {
            dnaList.add(dna);
        }
        processGenes(dnaList);
    }

    public static void main(String[] args) {
        Part2 driver = new Part2();
        driver.testCgRatio();
        driver.testCTGCount();
        driver.testProcessGene();
    }

}
