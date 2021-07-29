package StringsFirstAssignments;

import edu.duke.URLResource;

public class Part4 {
    int getBeginIndexOfDoubleQuote(String word, int index) {
        while(index >= 0 && word.charAt(index) != '\"') {
            index--;
        }
        return index;
    }
    public void printURL(String url) {
        URLResource urlResource = new URLResource(url);
        int count = 0;
        for (String word: urlResource.words()) {
            String tmpWord = word.toLowerCase();
            int startIndex = tmpWord.indexOf("youtube.com");
            if(startIndex == -1) {
                continue;
            }
            int beginIndex = tmpWord.lastIndexOf("\"", startIndex);
            int endIndex = tmpWord.indexOf("\"", startIndex);
            if(beginIndex != -1 && endIndex != -1) {
                System.out.println("Youtube link is : " + word.substring(beginIndex + 1, endIndex));
                count++;
            }
        }
        System.out.println("Total link count : " + count);
    }
    public static void main(String[] args) {
        Part4 part4 = new Part4();
        part4.printURL("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
    }
}
