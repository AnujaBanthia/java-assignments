package arraysListDataStructures.week1.objectOrientedCaesarCipher;

import arraysListDataStructures.week1.WordLengths;
import edu.duke.FileResource;

public class TestCaesarCipher {
    public void simpleTests () {
        String message = new FileResource().asString();
        CaesarCipher cipher = new CaesarCipher(18);
        System.out.println("Message : "+message);
        String encrypted = cipher.encrypt(message);
        System.out.println("Encrypted Message: "+encrypted);
        String decrypted = cipher.decrypt(encrypted);


        System.out.println("now breaking it...");
        String broken = breakCaesarCipher(encrypted);
        System.out.println("Broken Message : "+broken);

    }

    private void qps (String label, String value) {
        System.out.println(label+" '"+value+"'");
    }



    private String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int ALPHABET_LENGTH = ALPHABET.length();
    private int LETTER_E_POSITION = ALPHABET.indexOf('e');

    private int[] countLetters (String message) {
        int[] counts = new int[ALPHABET_LENGTH];
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int index = ALPHABET.indexOf(ch);
            if (index != -1) counts[index] += 1;
        }
        return counts;
    }


    private int maxIndex (int[] values) {
        if (values.length == 0)
            return -1;

        int maxIdx = 0;
        for (int k = 0; k < values.length; k++)
            if (values[k] > values[maxIdx])
                maxIdx = k;
        return maxIdx;
    }



    private int keyOffset(int value) {
        int key = value - LETTER_E_POSITION;

        if (value < LETTER_E_POSITION)
            key = ALPHABET_LENGTH - (LETTER_E_POSITION - value);
        return key;
    }

    private String breakCaesarCipher (String input) {
        int[] freqs = countLetters(input);
        int maxIndex = maxIndex(freqs);
        int dkey = keyOffset(maxIndex);
        CaesarCipher cc = new CaesarCipher(dkey);
        return cc.decrypt(input);
    }

    public static void main(String[] args) {
        TestCaesarCipher testCaesarCipher = new TestCaesarCipher();
        testCaesarCipher.simpleTests();
    }
}
