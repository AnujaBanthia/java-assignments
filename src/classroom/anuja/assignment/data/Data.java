package classroom.anuja.assignment.data;

public class Data {
    int intValue;
    char charValue;

    public void printData(){
        System.out.println("int : "+intValue);
        System.out.println("char: "+charValue);
    }

    public void printLocalData(){
//        int intVal;
//        char charVal;
//        System.out.println("int : "+intVal);
//        System.out.println("char: "+charVal);
    }

    /* The code is not compiled because the local variables are not initialized and the default is not assigned to them as to the data members of the class.
    Thus had to comment the code.
     */
}
