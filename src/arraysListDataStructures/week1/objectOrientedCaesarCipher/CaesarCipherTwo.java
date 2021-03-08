package arraysListDataStructures.week1.objectOrientedCaesarCipher;

public class CaesarCipherTwo {
    private String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int ALPHABET_LENGTH = ALPHABET.length();
    private int LETTER_E_POSITION = ALPHABET.indexOf('e');

    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;

    public CaesarCipherTwo (int key1, int key2) {
        alphabet = ALPHABET.toUpperCase() + ALPHABET.toLowerCase();
        mainKey1 = validateKey(key1);
        mainKey2 = validateKey(key2);
        shiftedAlphabet1 = shiftAlphabet(mainKey1).toUpperCase() +
                shiftAlphabet(mainKey1).toLowerCase();
        shiftedAlphabet2 = shiftAlphabet(mainKey2).toUpperCase() +
                shiftAlphabet(mainKey2).toLowerCase();
    }


    private int validateKey (int key) {
        return (key < 0 || key > ALPHABET_LENGTH-1) ? 0 : key;
    }


    private String shiftAlphabet(int key) {
        return ALPHABET.substring(key) + ALPHABET.substring(0, key);
    }


    private boolean hasValue (String s) { return s != null && s.length() != 0; }


    public String encrypt (String input) {

        if (!hasValue(input)) return "";
        if (mainKey1 == 0 && mainKey2 == 0) return input;


        StringBuilder encrypted = new StringBuilder(input);


        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if (idx != -1) {
                // Which alphabet do I use?  even i is key1, odd i is key2
                String shiftedAlphabet = (i % 2 == 0) ? shiftedAlphabet1: shiftedAlphabet2;
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }

        return encrypted.toString();
    }


    public String decrypt (String input) {
        return new CaesarCipherTwo(ALPHABET_LENGTH-mainKey1, ALPHABET_LENGTH-mainKey2).encrypt(input);
    }
}
