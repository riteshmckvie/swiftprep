package basicjava;

import java.util.HashMap;

public class Immutable {

	public static void main(String[] args) throws CloneNotSupportedException {
		HashMap<String,Integer> testMap = new HashMap<>();
		testMap.put("ritesh", 4);
		Employee emp = new Employee("Adithya", 34, new Address("Home", "Madhapur", "Hyderabad"),  testMap);
		Address address = emp.getAddress();
		System.out.println(address);
		address.setAddress("Hi-tech City");
		address.setAddressType("Office");
		address.setCity("Bengaluru");
		emp.getHashmap().put("ritesh",5);
		System.out.println(emp.getAddress() +"  "+emp.getHashmap().get("ritesh"));
	}

}
