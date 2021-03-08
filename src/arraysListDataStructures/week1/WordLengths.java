package arraysListDataStructures.week1;

import edu.duke.FileResource;

public class WordLengths {
    public void countWordLengths (FileResource resource, int[] counts) {
        int lastIndex = counts.length - 1;
        for (String word : resource.words()) {
            // Apparently there is a defect in FileResource.words(): using an
            // empty file will return a "word" of zero length, so we have to
            // test for that.
            if (word.isEmpty()) break;


            int wordLen = word.length();
            int len = wordLen;
            if (! Character.isLetter(word.charAt(0))) len -= 1;
            if (! Character.isLetter(word.charAt(wordLen-1))) len -= 1;


            if (len > lastIndex)
                counts[lastIndex]++;
            else if (len > 0)
                counts[len]++;
        }
    }

    public int indexOfMax (int[] values) {
        if (values.length == 0)
            return -1;

        int maxIdx = 0;
        for (int k = 0; k < values.length; k++)
            if (values[k] > values[maxIdx])
                maxIdx = k;
        return maxIdx;
    }
    public void testCountWordLengths(){
        FileResource fileResource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fileResource,counts);
        for (int i=0;i<31;i++) {
            System.out.println("count of length "+i+": "+counts[i]);
        }
    }

    public static void main(String[] args) {
        WordLengths wordLengths = new WordLengths();
        wordLengths.testCountWordLengths();
    }
}
