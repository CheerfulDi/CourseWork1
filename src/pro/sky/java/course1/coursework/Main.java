package pro.sky.java.course1.coursework;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        Employee johan = new Employee("Johan Rolling", 100_000, 1);
        Employee steven = new Employee("Steven Allan Spielberg", 150_000, 1);
        Employee barry = new Employee("Barry Allen", 250_000, 2);
        Employee bruce = new Employee("Bruce Wayne", 535_000, 2);
        Employee peter = new Employee("Peter Parker", 225_000, 3);
        Employee xavier = new Employee("Charles Xavier", 35_000, 3);
        Employee michelle = new Employee("Michelle Pfeiffer", 135_000, 4);
        Employee johnny = new Employee("Johnny Depp", 198_000, 4);
        Employee picasso = new Employee("Pablo Picasso", 278_000, 5);
        Employee monet = new Employee("Claude Monet", 186_000, 5);

        Employee[] employees = new Employee[]{johan, steven, barry, bruce, peter, xavier, michelle, johnny, picasso, monet};

        printEmployees(employees);
        System.out.println();
        System.out.println("Сумма затрат на зарплаты в месяц: " + calculateTotalSalarySumPerMonth(employees));
        System.out.println();
        findMinSalaryEmployee(employees);
        System.out.println();
        findMaxSalaryEmployee(employees);
        System.out.println();
        System.out.println("Средняя зарплата среди сотрудников: " + calculateAverageEmployeesSalary(employees));
        System.out.println();
        printEmployeesFullNames(employees);
    }

    public static void printEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    public static int calculateTotalSalarySumPerMonth(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static void findMinSalaryEmployee(Employee[] employees) {
        int min = employees[0].getSalary();
        String poorEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                poorEmployee = employee.getFullName();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + poorEmployee);
    }

    public static void findMaxSalaryEmployee(Employee[] employees) {
        int max = employees[0].getSalary();
        String richEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                richEmployee = employee.getFullName();
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + richEmployee);
    }

    public static int calculateAverageEmployeesSalary(Employee[] employees) {
        return calculateTotalSalarySumPerMonth(employees) / employees.length;
    }

    public static void printEmployeesFullNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
}

