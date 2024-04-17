package edu.step;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Employee> Employees = new ArrayList<>();

        Employee EmpM1 = new Employee("Ion Ramura", 22000, Employee.Gender.Male, LocalDate.of(1990, 3, 12));
        Employee EmpM2 = new Employee("John Tree", 15000, Employee.Gender.Male, LocalDate.of(1985, 3, 16));
        Employee EmpM3 = new Employee("Arthur Marston", 22000, Employee.Gender.Male, LocalDate.of(1997, 1, 14));

        Employee EmpF1 = new Employee("Julia Zenga", 26000, Employee.Gender.Female, LocalDate.of(2000, 6, 2));
        Employee EmpF2 = new Employee("Marie Antoinette", 10000, Employee.Gender.Female, LocalDate.of(1984, 4, 23));
        Employee EmpF3 = new Employee("Helen Brandson", 18000, Employee.Gender.Female, LocalDate.of(1998, 7, 17));

        Employees.add(EmpM1);
        Employees.add(EmpM2);
        Employees.add(EmpM3);
        Employees.add(EmpF1);
        Employees.add(EmpF2);
        Employees.add(EmpF3);

        //Methods
        EmpM1.highestSalary(Employees);
        EmpM1.sal3(Employees);
        EmpM1.fem2(Employees);
        EmpM1.maleInfo(Employees);
        EmpM1.salaryAscend(Employees);
        EmpM1.salaryUnq(Employees);
        System.out.println("");

        Employees.forEach(employee -> System.out.println(employee.getName() + " - " + employee.getSalary()));
        System.out.println("");

        //Streams
        DoubleSummaryStatistics highest = Employees.stream().collect(Collectors.summarizingDouble(e -> e.getSalary()));
        System.out.println("Highest salary - " + highest.getMax());

    }
}