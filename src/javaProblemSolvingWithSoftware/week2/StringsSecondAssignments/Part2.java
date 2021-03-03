package javaProblemSolvingWithSoftware.week2.StringsSecondAssignments;

public class Part2 {
    public int howMany(String stringa, String stringb){
        int count = 0;
        int firstOccur = stringb.indexOf(stringa,0);
        if(firstOccur != -1)
            count++;


            while (true) {
                firstOccur = stringb.indexOf(stringa, firstOccur+stringa.length());
                if(firstOccur == -1)
                    break;
                count ++;


            }


        return count;
    }
    public void testHowMany(){
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        int count = howMany(stringa,stringb);
        if (count == 0) {
            System.out.println("no occurrence found");
        }
        else{
            System.out.println(stringa+" - "+stringb+" : " + count);
        }
        stringa = "AA";
        stringb = "ATAAAA";
        count = howMany(stringa,stringb);
        if (count == 0) {
            System.out.println("no occurrence found");
        }
        else{
            System.out.println(stringa+" - "+stringb+" : " + count);
        }
        stringa = "AA";
        stringb = "ATABABAB";
        count = howMany(stringa,stringb);
        if (count == 0) {
            System.out.println("no occurrence found");
        }
        else{
            System.out.println(stringa+" - "+stringb+" : " + count);
        }
        stringa = "ACAB";
        stringb = "AAAAACABACABAAAACABACABAA";
        count = howMany(stringa,stringb);
        if (count == 0) {
            System.out.println("no occurrence found");
        }
        else{
            System.out.println(stringa+" - "+stringb+" : " + count);
        }
    }
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        part2.testHowMany();
    }
}
