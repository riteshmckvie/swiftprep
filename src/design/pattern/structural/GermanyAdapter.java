package design.pattern.structural;

public class GermanyAdapter implements Adapter {

	@Override
	public void conntect() {
		System.out.println("Connecting to Germany Plug using Adapter.");
	}

}