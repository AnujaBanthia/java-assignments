package classroom.assignment7.question_3;

import java.util.Scanner;

interface A{
    public void getA();
    public void dispA();
}
interface B{
    public void getB();
    public void dispB();
}
interface C{
    public void getC();
    public void dispC();

}
interface D extends A, B, C {
    public void getD();

}
class E implements D {
    public void getA(){
        System.out.println("interface A get method");
    }
    public void dispA(){
        System.out.println("interface A disp method");
    }
    public void getB(){
        System.out.println("interface B get method");
    }
    public void dispB(){
        System.out.println("interface B disp method");
    }
    public void getC(){
        System.out.println("interface C get method");
    }
    public void dispC(){
        System.out.println("interface C disp method");
    }
    public void getD(){
        System.out.println("interface D get mehtod ");
    }

     void method1(A a) {
        System.out.println("Method accepting A as argument");
    };
     void method2(B b) {
         System.out.println("Method accepting B as argument");
    };
     void method3(C c) {
         System.out.println("Method accepting C as argument");
    };
     void method4(D d) {
         System.out.println("Method accepting D as argument");
    };
};
public class Ques3 {


    public static void main(String[] args) {
        E s = new E();
        String st;

        s.method1(s);
        s.method2(s);
        s.method3(s);
        s.method4(s);

    }
}
