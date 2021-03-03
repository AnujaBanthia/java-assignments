package javaProblemSolvingWithSoftware.week2.StringsFirstAssignments;

public class Part1 {
    public String findSimpleGene(String dna){
        String result = "";
        int startPosition = dna.indexOf("ATG");
        if(startPosition == -1){
            return result;
        }
        int stopPosition = dna.indexOf("TAA", startPosition+3);
        if(stopPosition == -1){
            return  result;
        }
        int geneLength = stopPosition-startPosition;

        if(geneLength%3 == 0){
            
            result = dna.substring(startPosition,stopPosition+3);
        }
        return  result;

    }

    public void testSimpleGene(){
        String dnaSample1 = "AGGGCTAAAAGATAA"; //No ATG
        String dnaSample2 = "CGTATGACGTCATCGATATCTCTCACATATA"; // nO TAA
        String dnaSample3 = "CACACACATATATATAGTCGTCGTC"; //No ATG & TAA
        String dnaSample4 ="AGGGCTATGGACGTCATCGATTAA"; //ATG, TAA AND MULTIPLE OF 3
        String dnaSample5 = "AGGGCTATGGACGTCATCGATAA"; // ATG, TAA AND NOT MULTIPLE OF 3

        String resultGene ="";

        resultGene= findSimpleGene(dnaSample1);
        System.out.println(dnaSample1+":gene : "+resultGene);

        resultGene= findSimpleGene(dnaSample2);
        System.out.println(dnaSample2+":gene : "+resultGene);

        resultGene= findSimpleGene(dnaSample3);
        System.out.println(dnaSample3+":gene : "+resultGene);

        resultGene= findSimpleGene(dnaSample4);
        System.out.println(dnaSample4+":gene : "+resultGene);

        resultGene= findSimpleGene(dnaSample5);
        System.out.println(dnaSample5+":gene : "+resultGene);
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testSimpleGene();
    }
}
