package practiceClasses;

public class Bike extends Vehcile{

	public void stop() {
		System.out.println("Bike was a stop");
	}

	public static void main(String[] args) {
		Vehcile obj = new Vehcile();
		Bike obj1 = new Bike();
		
		obj.start();
		obj1.stop();
		
	}
}
