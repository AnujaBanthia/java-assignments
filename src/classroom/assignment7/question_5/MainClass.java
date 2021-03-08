class Aouter{
	Aouter(){
		System.out.println("Aouter class constructor is running.");
	}
	class Ainner{
		Ainner( int a,int b){
			System.out.println("The value of a is " +a);
			System.out.println("Ainner class constructor is running.");
		}
	}
};

class Bouter extends Aouter{
	Bouter(){
		System.out.println("Bouter class constructor is running.");
	}
	class Binner{
		 Binner(int a){
			System.out.println("The value of a is " +a);
			System.out.println("Binner class constructor is running.");
		}
	}
};

public class MainClass{
	public static void main(String[] args){
		Bouter.Binner in = new Bouter().new Binner(4);

		
	} 

}
