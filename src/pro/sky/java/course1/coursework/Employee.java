package pro.sky.java.course1.coursework;

import static java.lang.String.format;

public class Employee {
    private static int idCounter;
    private static final int MIN_DEPARTMENT = 1;
    private static final int MAX_DEPARTMENT = 5;

    private String fullName;
    private double salary;
    private int department;
    private int id;

    public Employee(String fullName, double salary, int department) {
        idCounter++;
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
        this.id = getIdCounter();
    }

    public int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int newDepartment) {
        if (department >= MIN_DEPARTMENT && department <= MAX_DEPARTMENT) {
            department = newDepartment;
        } else{
            throw new IllegalArgumentException("В компании всего 5 департаментов. Пожалуйста, введите значение от 1 до 5.");
        }
        }


    public String toString() {
        return "FullName: " + fullName + ". Salary: " + format("%.2f", salary) + ". Department: " + department + ".";
    }

}