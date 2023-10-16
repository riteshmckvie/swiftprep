package basicjava;

import java.util.HashMap;

public final class Employee {

	private final String empName;
	private final int age;
	private final Address address;
	private final HashMap<String,Integer> hashmap;

	public Employee(String name, int age, Address address, HashMap<String,Integer> hashmap) {
		super();
		this.empName = name;
		this.age = age;
		this.address = address;
		this.hashmap = hashmap;
	}

	public String getEmpName() {
		return empName;
	}

	public int getAge() {
		return age;
	}

	/*
	 * public Address getAddress() { return address; }
	 */
	public Address getAddress() throws CloneNotSupportedException {
		return (Address) address.clone();
	}

	public HashMap<String,Integer> getHashmap() {
		return  (HashMap<String, Integer>) hashmap.clone();
	}

}
