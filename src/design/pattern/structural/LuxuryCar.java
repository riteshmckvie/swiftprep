package design.pattern.structural;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(MotorCar c) {
		super(c);
	}
	
	@Override
	public void assemble(){
		super.assemble();
		System.out.print(" Adding features of Luxury Car.");
	}
}
