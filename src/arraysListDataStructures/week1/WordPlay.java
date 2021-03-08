package arraysListDataStructures.week1;

public class WordPlay {
    public boolean isVowel (char ch) {
        return "aeiouAEIOU".contains(Character.toString(ch));
    }

    private boolean isEmpty (String s) { return s != null && ! s.isEmpty(); }

    public String replaceVowels (String phrase, char ch) {
        if (! isEmpty(phrase))
            return "";
        StringBuilder sb = new StringBuilder(phrase);
        for (int k = 0; k < phrase.length(); k++)
            if (isVowel(sb.charAt(k)))
                sb.setCharAt(k, ch);
        return sb.toString();
    }
    public String emphasize (String phrase, char ch) {
        if (! isEmpty(phrase)) return "";
        StringBuilder sb = new StringBuilder(phrase);
        for (int k = 0; k < phrase.length(); k++)
            if (toLower(sb.charAt(k)) == toLower(ch) ||
                    toUpper(sb.charAt(k)) == toUpper(ch)) {
                sb.setCharAt(k, replacement(k));
            }
        return sb.toString();
    }
    private char toLower (char ch) { return Character.toLowerCase(ch); }
    private char toUpper (char ch) { return Character.toUpperCase(ch); }
    private char replacement (int pos) { return (pos % 2 == 0) ? '*' : '+'; }

    public static void main(String[] args) {
        WordPlay wordPlay = new WordPlay();

        System.out.println(wordPlay.isVowel('F'));
        System.out.println(wordPlay.replaceVowels("Hello World", '*') );
        System.out.println(wordPlay.emphasize("dna ctgaaactga", 'a') );
    }

}
