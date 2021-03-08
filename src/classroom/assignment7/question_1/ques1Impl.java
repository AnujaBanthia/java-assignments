package classroom.assignment7.question_1;

public class ques1Impl {
    public static void main(String[] args) {
        Rodent[] rodent = new Rodent[3];
        rodent[0] = new Mouse();
        rodent[0].disp();
        rodent[0].game();
        rodent[1] = new Gerbil();
        rodent[1].disp();
        rodent[1].game();
        rodent[2] = new Hamster();
        rodent[2].disp();
        rodent[2].game();
    }
}
