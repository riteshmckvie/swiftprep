package design.pattern.structural;

public class ProxyDemo {

	public static void main(String[] args) {
		
		Internet internet = new ProxyInternet();
		try {
			internet.connectTo("pramati.com");
			internet.connectTo("google.com");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
