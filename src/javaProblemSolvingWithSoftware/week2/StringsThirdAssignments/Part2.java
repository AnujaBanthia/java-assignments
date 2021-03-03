package javaProblemSolvingWithSoftware.week2.StringsThirdAssignments;

public class Part2 {
    public float cgRatio (String dna){
        int firstOccurC = dna.indexOf("C");
        int firstOccurG = dna.indexOf("G");
        int countC = 0;
        int countG = 0;
        if (firstOccurC > -1) {
            countC = countC+1;
            while (dna.indexOf("C", firstOccurC) != -1 && firstOccurC !=-1){
                countC = countC + 1;
                firstOccurC = dna.indexOf("C", firstOccurC + 1);
            }
            countC = countC - 1;
        }
        else {
            countC = 0;
        }
        if (firstOccurG > -1) {
            countG = countG+1;
            while (dna.indexOf("G", firstOccurG) != -1 && firstOccurG !=-1){
                countG = countG + 1;
                firstOccurG = dna.indexOf("G", firstOccurG + 1);
            }
            countG = countG - 1;
        }
        else {
            countG = 0;
        }
        //System.out.println(countC +" y "+ countG);
        float Finalresult = (float)countC / countG;
        return Finalresult;
    }
    public void testcgRatio(){
        String dna="CCCCAAGCCC";
        System.out.println("Result of all should be 7 and is: "+cgRatio(dna));
        dna="CCCGGGGGAAAGGG";
        System.out.println("Number of all should be 0.37 and is: "+cgRatio(dna));
        dna = "AAACCCCAAGG";
        System.out.println("Number of all should be 2 and is: "+cgRatio(dna));
    }
    public int countCTG(String dna){
        String codon = "CTG";
        int count=0;
        int startIndex =0;
        int currIndex = dna.indexOf(codon, startIndex );
        while(currIndex != -1) {
            count++;
            currIndex = dna.indexOf(codon, currIndex + 3);

        }
        return count;
    }
    public void testCountCTG(){
        String dna="CCCCAAGCCC";
        System.out.println("Result should be 0 and is: "+countCTG(dna));
        dna="CCCTGGGGGAAAGCTGCTGG";
        System.out.println("Result should be 3 and is: "+countCTG(dna));
        dna = "AAACCCCAAGCTG";
        System.out.println("Result should be 1 and is: "+countCTG(dna));
    }
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        part2.testcgRatio();
        part2.testCountCTG();
    }
}
