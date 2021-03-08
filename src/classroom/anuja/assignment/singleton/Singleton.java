package classroom.anuja.assignment.singleton;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

public class Singleton {
    String str;

    public static Singleton setValue(String value){
        Singleton newSingletonObject = new Singleton();
        newSingletonObject.str = value;
        return newSingletonObject;
    }

    public void printStirng(){
        System.out.println(str);
    }
}
