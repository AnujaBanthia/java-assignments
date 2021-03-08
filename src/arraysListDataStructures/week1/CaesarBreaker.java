package arraysListDataStructures.week1;

public class CaesarBreaker {
    private String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int ALPHABET_LENGTH = ALPHABET.length();
    private int LETTER_E_POSITION = ALPHABET.indexOf('e');

    public String decrypt (String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        WordLengths w = new WordLengths();
        int[] freqs = countLetters(encrypted);
        int maxIndex = maxIndex(freqs);
        //int dkey = maxIndex - LETTER_E_POSITION;
        // if the maximum index is less than where 'e' is, we have
        // to wrap round to get the the decrypt key.
        //if (maxIndex < LETTER_E_POSITION) {
        //    dkey = ALPHABET_LENGTH - (LETTER_E_POSITION - maxIndex);
        //}
        int dkey = keyOffset(maxIndex);
        return cc.encrypt(encrypted, ALPHABET_LENGTH-dkey);
    }

    public int[] countLetters (String message) {
        int[] counts = new int[ALPHABET_LENGTH];
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int index = ALPHABET.indexOf(ch);
            if (index != -1) counts[index] += 1;
        }
        return counts;
    }

    public int maxIndex (int[] values) {
        WordLengths w = new WordLengths();
        return w.indexOfMax(values);
    }

    private int keyOffset(int value) {
        int key = value - LETTER_E_POSITION;
        if (value < LETTER_E_POSITION)
            key = ALPHABET_LENGTH - (LETTER_E_POSITION - value);
        return key;
    }

    public String decryptTwoKeys (String encrypted) {
        if (! hasValue(encrypted)) return "";

        // Calculate string of every other character in `encrypted`
        String oddChars = halfOfString(encrypted, 0);
        String evenChars = halfOfString(encrypted, 1);
        //ps("oddChars", oddChars);
        //ps("evenChars", evenChars);

        // Calculate a key used for each of those.
        // If the getKey() question on the practice quiz is wrong,
        // then keyOffset() goes INSIDE getKey() and I have to
        // adjust those tests.
        int key1 = keyOffset(getKey(oddChars));
        int key2 = keyOffset(getKey(evenChars));

        // We're told to print the keys found.
        System.out.println("key1 = "+key1+", key2 = "+key2);

        // Decrypt using CaesarCipher with the inverse keys.
        return new CaesarCipher().encryptTwoKeys(encrypted, ALPHABET_LENGTH-key1, ALPHABET_LENGTH-key2);
    }

    public String halfOfString (String message, int start) {
        if (! hasValue(message)) return "";

        StringBuilder sb = new StringBuilder("");
        int messageLen = message.length();
        for (int k = start; k < messageLen; k += 2) {
            sb.append(message.charAt(k));
        }
        return sb.toString();
    }
    private boolean hasValue (String s) { return s != null && s.length() != 0; }
    public int getKey (String s) {
        return hasValue(s) ? maxIndex(countLetters(s)) : -1;
    }

    public void testDecrypt(){
        System.out.println("halfOfString(“Qbkm Zgis”, 0)  is :"+halfOfString("Qbkm Zgis", 0) );
        System.out.println("halfOfString(“Qbkm Zgis”, 1)   is :"+halfOfString("bkm Zgis", 1)  );
        CaesarCipher caesarCipher = new CaesarCipher();
        String encryptedString = caesarCipher.encryptTwoKeys("Just a test string with lots of eeeeeeeeeeeeeeeees",23,2);

        String decryptedString = decryptTwoKeys(encryptedString);
        System.out.println("encrypted string is : "+ encryptedString);
        System.out.println("decrypted string shoud be 'Just a test string with lots of eeeeeeeeeeeeeeeees' and  is : "+ decryptedString);
    }

    public static void main(String[] args) {
        CaesarBreaker caesarBreaker = new CaesarBreaker();
        caesarBreaker.testDecrypt();
    }
}
