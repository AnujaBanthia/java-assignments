package arraysListDataStructures.week1.objectOrientedCaesarCipher;

import arraysListDataStructures.week1.WordLengths;
import edu.duke.FileResource;

public class TestCaesarCipherTwo {
    void reallySimpleTests() {
        // Invalid keys
        CaesarCipherTwo badkeys = new CaesarCipherTwo(-1, 26);
        // That should set both keys to zero, which means no encryption.
        String msg = "Oh what a tangled web we weave";

        System.out.println("Message : "+msg);
        // degenerate cases
        CaesarCipherTwo breaker = new CaesarCipherTwo(17, 3);


        // Remember we need tests where 'e' is the most frequent character.
        String lotsOfEs = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        String encrypted = breaker.encrypt(lotsOfEs);
        System.out.println("Encrypted Message: "+encrypted);


    }


    void simpleTests() {
        String message = new FileResource().asString();

        CaesarCipherTwo cc = new CaesarCipherTwo(17, 3);
        System.out.println("Message: "+message);
        String encrypted = cc.encrypt(message);
        System.out.println("Encrypted Message: "+encrypted);
        String decrypted = cc.decrypt(encrypted);


        String broken = breakCaesarCipher(encrypted);
        System.out.println("Broken Message : "+broken);


    }



    private String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int ALPHABET_LENGTH = ALPHABET.length();
    private int LETTER_E_POSITION = ALPHABET.indexOf('e');

    // Returns true if the string has actual content.
    private boolean hasValue (String s) { return s != null && s.length() != 0; }

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
        WordLengths w = new WordLengths();
        return w.indexOfMax(values);
    }


    private int getKey (String s) {
        return hasValue(s) ? maxIndex(countLetters(s)) : -1;
    }

    private int keyOffset(int value) {
        int key = value - LETTER_E_POSITION;

        if (value < LETTER_E_POSITION)
            key = ALPHABET_LENGTH - (LETTER_E_POSITION - value);
        return key;
    }


    private String halfOfString (String message, int start) {
        if (! hasValue(message)) return "";

        StringBuilder sb = new StringBuilder("");
        int messageLen = message.length();
        for (int k = start; k < messageLen; k += 2) {
            sb.append(message.charAt(k));
        }
        return sb.toString();
    }


    private String breakCaesarCipher (String input) {
        if (! hasValue(input)) return "";

        // Calculate string of every other character in `encrypted`
        String oddChars = halfOfString(input, 0);
        String evenChars = halfOfString(input, 1);



        int key1 = keyOffset(getKey(oddChars));
        int key2 = keyOffset(getKey(evenChars));

        System.out.println("key1 = "+key1+", key2 = "+key2);

        // Decrypt using CaesarCipher with those keys.
        return new CaesarCipherTwo(key1, key2).decrypt(input);
    }

    public static void main(String[] args) {
        TestCaesarCipherTwo testCaesarCipherTwo = new TestCaesarCipherTwo();
        testCaesarCipherTwo.reallySimpleTests();
        testCaesarCipherTwo.simpleTests();
    }
}
