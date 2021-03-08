package classroom;

import java.io.File;
import java.util.regex.Pattern;

/*
Assignment 1:
Create a java program to search through the home directory and look for files that match a regular expression.
The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.

Provide appropriate documentation and comments on your code.
 */
public class FilesMatchingPattern {
    private final String homeDirectoryPath = "/home";
    private String regExForFileNames = "[A-Za-z]{10}"; // File name containing all letters and of length 10



    public boolean acceptFileName(String fileName){
        boolean found = fileName.matches(regExForFileNames);
        return found;
    }

    public void processFileName(File file){
        if(acceptFileName(file.getName())){
            System.out.println(file.getAbsolutePath());
        }
    }

    public void processDirectory(File directory){
        if(directory == null )
            return;
        File[] files = directory.listFiles();
        if(files == null || files.length == 0)
            return;
        for(File currFile: files){
            if(currFile.isFile()){
                processFileName(currFile);
            }
            else{
                processDirectory(currFile);
            }
        }
    }
    public void processAllFiles(){
        //Creating a File Object for the home Directory
        File homeDirectory = new File(homeDirectoryPath);
        processDirectory(homeDirectory);
    }

    public static void main(String[] args) {
        FilesMatchingPattern filesMatchingPattern = new FilesMatchingPattern();
        filesMatchingPattern.processAllFiles();
    }
}
