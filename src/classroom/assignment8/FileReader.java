package classroom.assignment8;

public class FileReader {
    public void readFile(String fileName){
        try{
            if(fileName==" ")
                throw new IncorrectNameException("FileName cannot be blank");
            else if(fileName.contains(".png"))
                throw  new IncorrectFileExtensionException("File cannot be of type png");
            else if(fileName.startsWith("/usr"))
                throw new PermissionDeniedException("Permission is denied to read file from /usr folder");

        }
        catch (IncorrectNameException | IncorrectFileExtensionException | PermissionDeniedException | NullPointerException exception){
            System.out.println("catch block is  executed");
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("finally block is always executed");
        }
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.readFile(" ");

        fileReader.readFile("star.png");

        fileReader.readFile("/usr/tmp");
    }
}
