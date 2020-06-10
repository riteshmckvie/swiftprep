package design.pattern.structural;

public class Charger {

	private Adapter adapter;
	
	private String country;

	public void charge() {
		adapter.conntect();
		System.out.println("Charging...");
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}

}
