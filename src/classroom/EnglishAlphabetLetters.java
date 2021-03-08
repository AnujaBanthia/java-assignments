package classroom;

/*
Assignment2:
Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive).
Write time and space complexity of your solution as comments in the source file.
Time Complexity: O(n)
Space Complexity: O(1)
 */

public class EnglishAlphabetLetters {
    public static boolean checkStringForAllTheLetters(String input) {
        int index = 0;
        boolean[] visited = new boolean[26];

        for (int id = 0; id < input.length(); id++) {
            if ('a' <= input.charAt(id) && input.charAt(id) <= 'z') {
                index = input.charAt(id) - 'a';
            } else if ('A' <= input.charAt(id) && input.charAt(id) <= 'Z') {
                index = input.charAt(id) - 'A';
            }
            visited[index] = true;
        }

        for (int id = 0; id < 26; id++) {
            if (!visited[id]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input="Farmer jack realized that big yellow quilts were expensive";
        boolean result = checkStringForAllTheLetters(input);
        System.out.println(input+":"+result);
        String input2 ="Anuja";
        result = checkStringForAllTheLetters(input2);
        System.out.println(input2+":"+result);
    }
}
