package arraysListDataStructures.week2;

import arraysListDataStructures.week1.WordLengths;
import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {


        private ArrayList<String> myWords;      // holds the words in the file
        private ArrayList<Integer> myFreqs;     // holds the frequency of kth word in myWords

        public WordFrequencies() {
            myWords = new ArrayList<String>();
            myFreqs = new ArrayList<Integer>();
        }


        public void findUnique() {
            myWords.clear();
            myFreqs.clear();


            FileResource resource = new FileResource();

            for (String s : resource.words()) {
                s = s.toLowerCase();
                int index = myWords.indexOf(s);
                if (index == -1) {

                    myWords.add(s);
                    myFreqs.add(1);
                } else {

                    int value = myFreqs.get(index);
                    myFreqs.set(index, value + 1);
                }
            }
        }

        public void tester() {
            findUnique();
            System.out.println("Number of unique words: " + myWords.size());
            for (int k = 0; k < myWords.size(); k++) {
                System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
            }
            int maxIndex = findIndexOfMax();
            System.out.println("The word that occurs most often and its count are: " +
                    myWords.get(maxIndex) + " " + myFreqs.get(maxIndex));
        }

        public int findIndexOfMax() {
            if (myFreqs.size() == 0) return -1;

            int maxIndex = 0;  // location where max occurred
            for (int k = 0; k < myFreqs.size(); k++) {
                // "If there is a tie, return first such location" means use > instead
                // >=.
                if (myFreqs.get(k) > myFreqs.get(maxIndex))
                    maxIndex = k;
            }

            return maxIndex;
        }

    public static void main(String[] args) {
        WordFrequencies wordFrequencies = new WordFrequencies();
        wordFrequencies.tester();
    }
}
