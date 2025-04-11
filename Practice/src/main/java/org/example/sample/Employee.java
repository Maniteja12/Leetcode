package org.example.sample;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    private int id;
    private String name;
    private int salary;
    private String department;

    public Employee(int id, String name, int salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(1,"Hari", 1200, "Finance");
        Employee emp2 = new Employee(2,"Ram", 1300, "HR");
        Employee emp3 = new Employee(3,"Sita", 1000, "Finance");
        Employee emp4 = new Employee(4,"Pranay", 1500, "HR");
        Employee emp5 = new Employee(5,"Ravi", 1800, "Tech");
        Employee emp6 = new Employee(6,"Tarun", 1600, "Tech");
        List<Employee> empList = new ArrayList<>(List.of(new Employee(7, "A", 2000, "HR")));
        empList.forEach(a -> System.out.println(a.id + " " + a.salary));
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);
        empList.add(emp6);
        Map<String, Optional<Employee>> empData = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        empData.forEach((dept,emp) -> System.out.println(dept + " " +emp.get().salary));

    }
}
