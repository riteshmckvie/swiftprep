package design.pattern.structural;

public class DecoratorDemo {

	public static void main(String[] args) {
		MotorCar sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n*****");

		MotorCar sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}
}
