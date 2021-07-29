package genes;

public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna) {
        String gene = "";
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
        return dna.substring(startIndex, endIndex + 3);
    }
    public void testFindGeneSimple() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        if(gene.length() != 0) {
            System.out.println("Gene is " + gene);
        }
    }
    public static void main(String[] args) {
        FindGeneSimpleAndTest findGeneSimpleAndTest = new FindGeneSimpleAndTest();
        findGeneSimpleAndTest.testFindGeneSimple();
    }
}
