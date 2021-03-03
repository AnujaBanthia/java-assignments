package javaProblemSolvingWithSoftware.week2.StringsFirstAssignments;

public class Part3 {
    public boolean twoOccurrences (String stringa, String stringb) {
        int occurrence = stringb.indexOf(stringa);
        if (occurrence == -1) {
            return false;

        }
        int nextOccurence = stringb.indexOf(stringa,occurrence+1);
        if (nextOccurence == -1) {
            return false;

        }

        return true;

    }
    public void testing(){
        String stringa = "by";
        String stringb = "A story by Abby Long";
        System.out.println("stringa = "+stringa + " and stringb = " + stringb);
        System.out.println(twoOccurrences(stringa, stringb));

        stringa = "a";
        stringb = "banana";
        System.out.println("stringa = "+stringa + " and stringb = " + stringb);
        System.out.println(twoOccurrences(stringa, stringb));

        stringa = "atg";
        stringb = "ctgtatgta";
        System.out.println("stringa = "+stringa + " and stringb = " + stringb);
        System.out.println(twoOccurrences(stringa, stringb));
    }

    public String lastPart(String stringa, String stringb){
        int occurrence = stringb.indexOf(stringa); //This tells you there is an occurrence, and where

        int startFrom = stringa.length();

            String finalPart = stringb.substring(startFrom+occurrence,stringb.length());
            return finalPart;


    }

    public void testingLastPart(){
        String stringa = "an";
        String stringb = "banana";
        System.out.println("The part of the string after " + stringa + " in " +stringb +" is "+ lastPart(stringa, stringb));

        stringa = "rest";
        stringb = "deforestacion";
        System.out.println("The part of the string after " + stringa + " in " +stringb +" is "+ lastPart(stringa, stringb));

        stringa = "cio";
        stringb = "deforestacion";
        System.out.println("The part of the string after " + stringa + " in " +stringb +" is "+ lastPart(stringa, stringb));

        stringa = "zoo";
        stringb = "forest";
        System.out.println("The part of the string after " + stringa + " in " +stringb +" is "+ lastPart(stringa, stringb));
    }

    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testing();
        part3.testingLastPart();
    }
}
