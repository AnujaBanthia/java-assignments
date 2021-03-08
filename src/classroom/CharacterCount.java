package classroom;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CharacterCount {
    static Map<Character,Integer> characterMap= new HashMap<Character,Integer>();
    public static void readFile(String fileName){
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(fileName));
            int ch = reader.read();
            while(ch != -1){
                if(characterMap.containsKey((char)(ch))){
                    int count = characterMap.get((char)ch);
                    count++;
                    characterMap.put((char)ch,count);
                }
                else{
                    characterMap.put((char)ch,1);
                }
                ch = reader.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void writeToFile(String fileName){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            for (Map.Entry<Character,Integer> entry : characterMap.entrySet()){
                fileWriter.write(entry.getKey()+":"+entry.getValue()+"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        if(args.length == 0)
            return;
        String fileName = args[0];
        readFile(fileName);
        writeToFile("output.txt");
    }
}
