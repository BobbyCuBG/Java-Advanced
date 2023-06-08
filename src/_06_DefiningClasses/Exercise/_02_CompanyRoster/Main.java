package _06_DefiningClasses.Exercise._02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<Employee>> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            if (tokens.length == 4) {
                createAndAddEmployee(departments, name, salary, position, department);
            } else if (tokens.length == 5) {
                if (isNumber(tokens[4])) {
                    int age = Integer.parseInt(tokens[4]);
                    createAndAddEmployee(departments, name, salary, position, department, age);
                } else {
                    String email = tokens[4];
                    createAndAddEmployee(departments, name, salary, position, department, email);
                }
            } else {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                createAndAddEmployee(departments, name, salary, position, department, email, age);
            }
        }

        String departmentWithHighestSalary = findDepartmentWithHighestSalary(departments);
        if (departmentWithHighestSalary != null) {
            System.out.println("Highest Average Salary: " + departmentWithHighestSalary);
            List<Employee> employees = departments.get(departmentWithHighestSalary);
            employees.stream()
                    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                    .forEach(employee -> System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()));
        }

    }
    private static String findDepartmentWithHighestSalary(Map<String, List<Employee>> departments) {
        double highestAverageSalary = 0;
        String departmentWithHighestSalary = null;

        for (Map.Entry<String, List<Employee>> entry : departments.entrySet()) {
            String department = entry.getKey();
            List<Employee> employees = entry.getValue();
            double averageSalary = employees.stream()
                    .mapToDouble(Employee::getSalary)
                    .average()
                    .orElse(0);

            if (averageSalary > highestAverageSalary) {
                highestAverageSalary = averageSalary;
                departmentWithHighestSalary = department;
            }
        }

        return departmentWithHighestSalary;
    }

    private static void createAndAddEmployee(Map<String, List<Employee>> departments, String name, double salary, String position, String department) {
        Employee employee = new Employee(name, salary, position, department);
        addEmployeeToDepartment(departments, employee);
    }

    private static void createAndAddEmployee(Map<String, List<Employee>> departments, String name, double salary, String position, String department, int age) {
        Employee employee = new Employee(name, salary, position, department, age);
        addEmployeeToDepartment(departments, employee);
    }

    private static void createAndAddEmployee(Map<String, List<Employee>> departments, String name, double salary, String position, String department, String email) {
        Employee employee = new Employee(name, salary, position, department, email);
        addEmployeeToDepartment(departments, employee);
    }

    private static void createAndAddEmployee(Map<String, List<Employee>> departments, String name, double salary, String position, String department, String email, int age) {
        Employee employee = new Employee(name, salary, position, department, email, age);
        addEmployeeToDepartment(departments, employee);
    }

    private static void addEmployeeToDepartment(Map<String, List<Employee>> departments, Employee employee) {
        departments.putIfAbsent(employee.getDepartment(), new ArrayList<>());
        departments.get(employee.getDepartment()).add(employee);
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}