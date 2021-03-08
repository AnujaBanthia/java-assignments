package arraysListDataStructures.week2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> myCharacters;
    private ArrayList<Integer> myFreqs;

    public CharactersInPlay() {
        myCharacters = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }


    private int mainCharacterSpeakingThreshold = 13;

    private boolean hasValue (String s) { return s != null && ! s.isEmpty(); }


    void update (String person) {
        if (hasValue(person)) {
            int index = myCharacters.indexOf(person);
            if (index == -1) {
                myCharacters.add(person);
                myFreqs.add(1);
            } else {
                int freq = myFreqs.get(index);
                myFreqs.set(index, freq+1);
            }
        }
    }

    void findAllCharacters (FileResource fr) {
        for (String line : fr.lines()) {
            int period = line.indexOf('.');
            if (period != -1) {
                String person = line.substring(0, period);
                update(person);
            }
        }
    }

    private boolean isMainCharacter (String person) {
        if (! hasValue(person)) return false;
        int index = myCharacters.indexOf(person);
        int freq = myFreqs.get(index);
        return freq > mainCharacterSpeakingThreshold;
    }

    public void tester() {
        myCharacters.clear();
        myFreqs.clear();

        FileResource fr = new FileResource();

        findAllCharacters(fr);

        for (int k = 0; k < myCharacters.size(); k++) {
            String person = myCharacters.get(k);
            if (isMainCharacter(person))
                System.out.println(person+":\t"+myFreqs.get(k));
        }

        System.out.println("\nCharacters with 10 to 20 parts");
        charactersWithNumParts(10,20);
    }

    public void charactersWithNumParts (int num1, int num2) {
        // make sure num1 is <= num2
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        // print the names of character with between num1 and num2
        // speaking parts
        for (int k = 0; k < myCharacters.size(); k++) {
            String person = myCharacters.get(k);
            int parts = myFreqs.get(k);
            if (num1 <= parts && parts <= num2)
                System.out.println(person+":\t"+parts);
        }
    }

    public static void main(String[] args) {
        CharactersInPlay charactersInPlay = new CharactersInPlay();
        charactersInPlay.tester();
    }
}
