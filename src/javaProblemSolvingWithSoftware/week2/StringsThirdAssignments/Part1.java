package javaProblemSolvingWithSoftware.week2.StringsThirdAssignments;

import edu.duke.StorageResource;

public class Part1 {
    public  int findStopCodon(String dna, int startIndex, String stopCodon) {

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

    public void testFindStopCodon() {
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";

        int dex = findStopCodon(dna, 0,"TAA");
        System.out.println(dex);

        dex = findStopCodon(dna, 9,"TAA");
        System.out.println(dex);

        dex = findStopCodon(dna, 1,"TAA");
        System.out.println(dex);

        dex = findStopCodon(dna, 0,"TAG");
        System.out.println(dex);

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
    public void testFindGene() {
        String one = "ATFxxxyyyzzzTAAxxxTAGxxx";
        String two = "xxxATGxxxyyyxxTAGxTAAxxx";
        String three = "xyyATGxxxyyyuuuTGAxxxTAGxxx";
        String four = "xyyATGxxxyyxxxyuuuTGAxxxTAGxxx";

        System.out.println("Gene is: " + one + " " + findGene(one,0));
        System.out.println("Gene is: " + two + " " + findGene(two,0));
        System.out.println("Gene is: " + three + " " + findGene(three,0));
        System.out.println("Gene is: " + four + " " + findGene(four,0));
    }
    public void printAllGenes(String dna) {

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

    public StorageResource getAllGenes(String dna) {
        StorageResource allGenes = new StorageResource();
        int startIndex = 0;
        while (true) {
            String gene = findGene(dna,startIndex);
            if (gene.isEmpty()) {
                break;
            }
            else {
                allGenes.add(gene);
                //System.out.println(gene);

                startIndex = dna.indexOf(gene,startIndex)+gene.length();
            }

        }
        return allGenes;
    }

    public void testGetAllGenes(){
        String dna= "aaaATGTAAGATGCCCTAGT";
        System.out.println("All the genes in "+dna+":");
        StorageResource allGenes = getAllGenes(dna);
        for(String gene: allGenes.data()){
            System.out.println(gene);
        }
    }
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testGetAllGenes();

    }
}
