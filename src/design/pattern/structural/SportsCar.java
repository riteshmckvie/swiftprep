package design.pattern.structural;

public class SportsCar extends CarDecorator {

	public SportsCar(MotorCar c) {
		super(c);
	}

	@Override
	public void assemble(){
		super.assemble();
		System.out.print(" Adding features of Sports Car.");
	}
}