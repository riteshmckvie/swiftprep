package design.pattern.structural;

public class UKAdapter implements Adapter {

	@Override
	public void conntect() {
		System.out.println("Connecting to UK Plug using Adapter.");
	}

}