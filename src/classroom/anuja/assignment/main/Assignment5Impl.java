package classroom.anuja.assignment.main;

import classroom.anuja.assignment.data.Data;
import classroom.anuja.assignment.singleton.Singleton;

public class Assignment5Impl {
    public static void main(String[] args) {
        Data data = new Data();
        data.printData();
        data.printLocalData();

        Singleton s = Singleton.setValue("Anuja");
        s.printStirng();
    }
}
