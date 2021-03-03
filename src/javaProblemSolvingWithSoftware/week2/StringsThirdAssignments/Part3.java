package javaProblemSolvingWithSoftware.week2.StringsThirdAssignments;

import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Part3 {
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
    public void processGenes(StorageResource sr){
        int count = 0;
        int counting = 0;
        System.out.println("Printing genes with +9 charas:");
        for (String gene9 : sr.data()){
            if (gene9.length() > 9){
                System.out.println(gene9);
            }
        }
        for (String plus9 : sr.data()){
            if (plus9.length() > 9){
                count = count +1;
            }
        }
        System.out.println("Printing number of strings above: " + count);
        for (String cgRat : sr.data()){
            //cgRatio(cgRat);
            if (cgRatio(cgRat) > 0.35)
                System.out.println("Gene with C-G ratio higher than 0.35 = " + cgRat + " and the ratio is: "+ cgRatio(cgRat));
        }
        for (String longest : sr.data()){
            if (longest.length() > counting){
                counting = longest.length();
            }
        }
        System.out.println("Length of the longest gene= " + counting);

    }
    public void testProcessGenes(){
        processGenes(CreationofSR());
    }

    public StorageResource CreationofSR(){
        StorageResource sr = new StorageResource();
        sr.add("ATGCCCCGGTAA");
        sr.add("ATGCCCGGGTTTTTTTTTTTTTTTTAA");
        sr.add("ATGTTTTTTTTTTTTTTTTAA");
        for(String s : sr.data()){
            System.out.println("this is my list of genes: " + s);
        }
        return sr;
    }

    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testProcessGenes();

    }
}
