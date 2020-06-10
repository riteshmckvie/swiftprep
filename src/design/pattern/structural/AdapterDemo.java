package design.pattern.structural;

//converts the interface of a class into another interface that a client wants
public class AdapterDemo {

	public static void main(String[] args) {
		Charger charger = new Charger();

		charger.setAdapter(new UKAdapter());

		charger.charge();

		charger.setAdapter(new GermanyAdapter());

		charger.charge();
	}

}
