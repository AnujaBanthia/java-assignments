package classroom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment9 {
    public static boolean isValidString(String string){
        String regex = "^[A-Z].*\\.$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static void main(String[] args) {
        String string1 = "This is a proper message.";
        String string2 = "this is not a proper message.";
        String string3 = "This is also not a proper message";

        System.out.println(string1+":"+isValidString(string1));
        System.out.println(string2+":"+isValidString(string2));
        System.out.println(string3+":"+isValidString(string3));
    }
}
