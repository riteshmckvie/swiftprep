package design.pattern.structural;

public class CarDecorator implements MotorCar {

	protected MotorCar car;
	
	public CarDecorator(MotorCar c){
		this.car=c;
	}
	
	@Override
	public void assemble() {
		this.car.assemble();
	}

}