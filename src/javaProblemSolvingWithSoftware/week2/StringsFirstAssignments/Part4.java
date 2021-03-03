package javaProblemSolvingWithSoftware.week2.StringsFirstAssignments;

import edu.duke.URLResource;

public class Part4 {
    public void printUrls(String url) {
        URLResource myurl = new URLResource(url);

        for(String word : myurl.words()) {
            if(word.toLowerCase().indexOf("youtube.com") != -1) {
                int quoteIndex = word.indexOf("\"");
                int lastQouteIndex = word.indexOf("\"", quoteIndex+1);
                System.out.println(word.substring(quoteIndex+1, lastQouteIndex));

            }
        }
    }

    public static void main(String[] args) {
        Part4 part4 = new Part4();
        part4.printUrls("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
    }
}
