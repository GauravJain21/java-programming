package StringsSecondAssignments;

public class Part2 {
    public int howMany(String stringa, String stringb) {
        if(stringa.length() == 0) {
            return -1;
        }
        if(stringb.length() == 0) {
            return 0;
        }
        int count = 0, index = stringb.indexOf(stringa);
        while (index != -1) {
            count++;
            index = stringb.indexOf(stringa, index + stringa.length());
        }
        return count;
    }
    public void testHowMany() {
        String ab[][] = {{"abc", "abc"}, {"abc", ""}, {"", "abc"}, {"a", "aaa"}, {"abc", "abbc"}};
        for(String[] stringab : ab) {
            System.out.println(stringab[0] + " occurs " + howMany(stringab[0], stringab[1]) + " many times in " + stringab[1]);
        }
    }
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        part2.testHowMany();
    }
}
