package javaProblemSolvingWithSoftware.week2.StringsFirstAssignments;

import java.util.Locale;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String tempDna = dna.toUpperCase();
        String result = "";
        int startPosition = tempDna.indexOf(startCodon);
        if(startPosition == -1){
            return "There is no "+startCodon+"strand";
        }
        int stopPosition = tempDna.indexOf(stopCodon, startPosition+3);
        if(stopPosition == -1){
            return "There is no"+stopCodon+" strand";
        }

        int geneLength = stopPosition-startPosition;

        if(geneLength%3 == 0){

            result = dna.substring(startPosition,stopPosition+3);
        }
        else{
            return "There is no gene strand satisfying multiple of 3";
        }
        return  result;

    }
    public void testSimpleGene(){
        String dnaSample1 = "AGGGCTAAAAGATAA"; //No ATG
        String dnaSample2 = "CGTATGACGTCATCGATATCTCTCACATATA"; // nO TAA
        String dnaSample3 = "CACACACATATATATAGTCGTCGTC"; //No ATG & TAA
        String dnaSample4 ="AGGGCTATGgACGTCATcGATTAa"; //ATG, TAA AND MULTIPLE OF 3
        String dnaSample5 = "AGGGCTATGGACGTCATCGATAA"; // ATG, TAA AND NOT MULTIPLE OF 3

        String resultGene ="";
        String startCodon = "ATG";
        String stopCodon = "TAA";

        resultGene= findSimpleGene(dnaSample1,startCodon,stopCodon);
        System.out.println(dnaSample1+":gene : "+resultGene);

        resultGene= findSimpleGene(dnaSample2,startCodon,stopCodon);
        System.out.println(dnaSample2+":gene : "+resultGene);

        resultGene= findSimpleGene(dnaSample3,startCodon,stopCodon);
        System.out.println(dnaSample3+":gene : "+resultGene);

        resultGene= findSimpleGene(dnaSample4,startCodon,stopCodon);
        System.out.println(dnaSample4+":gene : "+resultGene);

        resultGene= findSimpleGene(dnaSample5,startCodon,stopCodon);
        System.out.println(dnaSample5+":gene : "+resultGene);
    }

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        part2.testSimpleGene();
    }
}
