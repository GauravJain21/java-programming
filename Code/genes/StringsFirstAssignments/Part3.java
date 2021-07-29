package StringsFirstAssignments;

public class Part3 {
    public boolean twoOccurences(String stringa, String stringb) {
        int firstIndex = stringb.indexOf(stringa);
        if(firstIndex == -1) {
            return false;
        }
        int secondIndex = stringb.indexOf(stringa, firstIndex + stringa.length());
        return secondIndex != -1;
    }
    public void testing() {
        String strings[][] = {{"a", "aaa"}, {"b", "vbsdfb"}, {"a", "a"}};
        for(String[] ab: strings) {
            System.out.println(ab[0] + "occurs twice in " + ab[1] + " : " + twoOccurences(ab[0], ab[1]));
        }
        return;
    }
    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testing();
    }
}
