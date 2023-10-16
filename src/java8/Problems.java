package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.Employee;

public class Problems {

	public static void main(String[] args) {

		int nthHighest = 2;
		//System.out.println("abc".compareTo("absc") == 0);

		List<Employee> employeeList = Arrays.asList(new Employee(10, "ritesh", 20), new Employee(9, "ramesh", 10),
				new Employee(5, "panchu", 25), new Employee(7, "Mahesh", 21));
		//Comparator<Employee> byName =  (Employee o1,Employee o2) -> o1.getName().compareTo(o2.getName());
		employeeList.sort((Employee o1,Employee o2) -> o1.getName().compareTo(o2.getName()));
		List<Employee> sortedListBySalary = employeeList.stream()
				.sorted(Comparator.comparingLong(Employee::getSalary).reversed()).collect(Collectors.toList());
		Employee employee = sortedListBySalary.get(nthHighest - 1);
		sortedListBySalary.forEach(emp -> System.out.println(emp.getName() + " " + emp.getSalary()));
		//System.out.println(employee.getName() + " " + employee.getSalary());
		System.out.println();
		List<Employee> sortedListByAge = employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).collect(Collectors.toList());
		sortedListByAge.forEach(emp -> System.out.println(emp.getName() + " " + emp.getAge()));
	}

}
