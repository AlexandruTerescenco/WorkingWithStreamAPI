package edu.step;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Employee {
    //private static List<Employee> Employees = new ArrayList<>();
    private String name;
    private double salary;
    public enum Gender {
        Male,
        Female
    }

    Gender gender;

    private LocalDate birthday;

    public Employee(String name, double salary, Gender gender, LocalDate birthday) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.birthday = birthday;
        //Employees.add(this);
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void highestSalary(List<Employee> emp) {
        double highest = 0;
        String name = new String();
        for (int i = 0; i < emp.size(); i++) {
            if(highest < emp.get(i).getSalary()) {
                highest = emp.get(i).getSalary();
                name = emp.get(i).getName();
            }
        }
        System.out.println("(Method highestSalary)Highest salary: " + name + " - " + highest);
    }

    public void sal3(List<Employee> emp) {
        double highest = 0;
        int c = 0;
        int personID = 0;
        ArrayList<Employee> sal = new ArrayList<>();

        while (c < 3) {
            for (int i = 0; i < emp.size(); i++) {
                if(highest < emp.get(i).getSalary() && !sal.contains(emp.get(i)) ) {
                    highest = emp.get(i).getSalary();
                    personID = i;
                }
            }
            sal.add(emp.get(personID));
            highest = 0;
            personID = 0;
            c++;
        }

        sal.forEach(employee -> System.out.println("(Method sal3)" + employee.getName() + " - " + employee.getSalary()));
    }

    public void fem2(List<Employee> emp) {
        int c = 0;
        LocalDate year = LocalDate.of(1990, 1, 1);
        ArrayList<Employee> fem = new ArrayList<>();

        for (int i = 0; i < emp.size(); i++) {
            if(emp.get(i).gender == Gender.Female && emp.get(i).getBirthday().isAfter(year) && c < 2) {
                fem.add(emp.get(i));
                c++;
            }
        }

        fem.forEach(employee ->  System.out.println("(Method fem2)" + employee.getName() + " - " + employee.getBirthday()));
    }

    public void maleInfo(List<Employee> emp) {
        ArrayList<Employee> info = new ArrayList<>();

        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i).gender == Gender.Male) {
                info.add(emp.get(i));
            }
        }

        info.forEach(employee -> System.out.println("(Method maleInfo)Name: " + employee.getName() + ", gender: " + employee.getGender() + ", birthday: " + employee.getBirthday() + ", salary:" + employee.getSalary()));
    }

    public void salaryAscend(List<Employee> emp) {
        ArrayList<Employee> ordered = new ArrayList<>();
        int c = 0;
        double highest = 0;
        int personID = 0;

        while(c < emp.size()) {
            for (int i = 0; i < emp.size(); i++) {
                if (highest < emp.get(i).getSalary() && !ordered.contains(emp.get(i))) {
                    highest = emp.get(i).getSalary();
                    personID = i;
                }
            }
            ordered.add(emp.get(personID));
            highest = 0;
            personID = 0;
            c++;
        }

        ordered.forEach(employee -> System.out.println("(Method salaryAscend)" + employee.getSalary()));
    }

    public void salaryUnq(List<Employee> emp) {
        HashSet<Double> unique = new HashSet<>();

        for (Employee sal: emp) {
            unique.add(sal.getSalary());
        }

        System.out.println("(Method salaryUnq)" + unique);
    }

}
