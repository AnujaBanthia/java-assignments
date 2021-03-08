package arraysListDataStructures.week1;

import edu.duke.FileResource;

public class CaesarCipher {
    // The source alphabet used by all routines.
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Encapsulate the key shift since it will get done in several places.
    private String shiftAlphabet(int key) {
        return alphabet.substring(key) + alphabet.substring(0, key);
    }

    // A test to make sure a string has something in it, since I will be
    // doing that test in every method that accepts a string.
    private boolean hasValue (String s) { return s != null && ! s.isEmpty(); }
    public String encrypt (String input, int key) {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder (input);
        // Write down the alphabet
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = Alphabet.toLowerCase();

        // Compute the shifted alphabet
        String ShiftedAlphabet = Alphabet.substring(key)+ Alphabet.substring(0,key);
        String shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        // Count from 0 to < length of encrypted,(call it i)
        for (int i = 0; i < encrypted.length();i++){
            // Look at the ith character of encrypted ( call it currchar)
            char currChar = encrypted.charAt(i);
            if (Character.isLowerCase(currChar)) {
                // Find the index of currChar in the alphabet (call it idx)
                int idx = alphabet.indexOf(currChar);
                // If currChar is in the alphabet
                if (idx !=-1){
                    // Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabet.charAt(idx);
                    // Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i,newChar);
                }

            }

            else {
                // Find the index of currChar in the alphabet (call it idx)
                int idx = Alphabet.indexOf(currChar);
                // If currChar is in the alphabet
                if (idx !=-1){
                    // Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = ShiftedAlphabet.charAt(idx);
                    // Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i,newChar);
                }

            }


            //otherwise : do nothing
        }
        // Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testCaesar(){
        //FileResource fr = new FileResource();
        String message = "FIRST LEGION ATTACK EAST FLANK!";
        int key = 23;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);

        message = "First Legion";
        key=17;
        encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        System.out.println(encryptTwoKeys("First Legion", 23, 17));
    }
    public String encryptTwoKeys (String input, int key1, int key2) {
        // parameter checks.  If input has nothing, or both keys
        // are zero, we have no work to do.
        if (!hasValue(input)) return "";
        if (key1 == 0 && key2 == 0) return input;

        // Start with a StringBuilder we can update below.
        StringBuilder encrypted = new StringBuilder(input);
        // Support both cases by creating a shifted alphabet of each, then
        // combining together.
        String myAlphabet = alphabet.toUpperCase() + alphabet.toLowerCase();
        String shifted1 = shiftAlphabet(key1).toUpperCase() +
                shiftAlphabet(key1).toLowerCase();
        String shifted2 = shiftAlphabet(key2).toUpperCase() +
                shiftAlphabet(key2).toLowerCase();
        // Walk the input string and transform each letter that exists in
        // our alphabet
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = myAlphabet.indexOf(currChar);
            if (idx != -1) {
                // Which alphabet do I use?  even i is key1, odd i is key2
                String shiftedAlphabet = (i % 2 == 0) ? shifted1: shifted2;
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }

        return encrypted.toString();
    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();
        caesarCipher.testCaesar();
    }
}
