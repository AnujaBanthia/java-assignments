package javaProblemSolvingWithSoftware.week2.StringsSecondAssignments;

public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {

        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while(currIndex != -1) {
            int diff = currIndex - startIndex;
            if(diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }

        return dna.length();
    }
    public String findGene(String dna, int startIndex){
        startIndex = dna.indexOf("ATG",startIndex);
        if(startIndex == -1) {
            return "";
        }

        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");

        int minIndex = 0;
        if(taaIndex == -1 || (tagIndex != -1 && tagIndex < taaIndex)) {
            minIndex = tagIndex;
        } else {
            minIndex = taaIndex;
        }

        if(minIndex == -1 || (tgaIndex != -1 && tgaIndex < minIndex)) {
            minIndex = tgaIndex;
        }

        if(minIndex == -1) {
            return "";
        }

        return dna.substring(startIndex, minIndex + 3);
    }
    public void printAllGenes(String dna) {
         int count =0;
        int startIndex = 0;
        while (true) {
            String gene = findGene(dna,startIndex);
            if (gene.isEmpty()) {
                break;
            }
             else {
                System.out.println(gene);
                startIndex = dna.indexOf(gene,startIndex)+gene.length();
            }

        }
    }
    public int countGenes(String dna) {
        int count =0;
        int startIndex = 0;
        while (true) {
            String gene = findGene(dna,startIndex);
            if (gene.isEmpty()) {
                break;
            } else {
                count ++;
                startIndex = dna.indexOf(gene,startIndex)+gene.length();
                //System.out.println(gene);
            }

        }
        return count;
    }
    public void testCountGenes(){
        String dna= "aaaATGTAAGATGCCCTAGT";
        System.out.println("I should find 2 and found these amount of genes:" + countGenes(dna));

        dna= "ATGTAGATGTAAATGTAA";
        System.out.println("I should find 3 and found these amount of genes:" + countGenes(dna));
    }
    public static void main(String[] args) {
        Part3 part3 = new Part3();
       part3.testCountGenes();
    }
}
