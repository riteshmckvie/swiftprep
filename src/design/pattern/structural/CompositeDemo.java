package design.pattern.structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Composite class
class Employee {

	String name;
	List<Employee> reportee = new ArrayList<>();
	String designation;
	Integer id;
	Integer managerId;

	Employee(Integer id, String name, String designation, Integer managerid) {
		this.designation = designation;
		this.name = name;
		this.id = id;
		this.managerId = managerid;
		if (managerid != null) {
			CompositeDemo.employeeMap.get(managerid).reportee.add(this);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
}

public class CompositeDemo {

	static Map<Integer, Employee> employeeMap = new HashMap<>();

	public static void main(String[] args) {
		employeeMap.put(1, new Employee(1, "Vijay", "CEO", null));
		employeeMap.put(2, new Employee(2, "Giri", "VP", 1));
		employeeMap.put(3, new Employee(3, "Kayal", "Manager", 2));
		employeeMap.put(4, new Employee(4, "KP", "Architect", 3));
		employeeMap.put(5, new Employee(5, "Manoj", "SDE", 3));
		employeeMap.put(6, new Employee(6, "Ritesh", "SDE", 3));
	}

}
