package pro.sky.java.course1.coursework;

import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;
import java.util.Arrays;

import static java.lang.String.format;

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
        System.out.println("Сотрудник с минимальной зарплатой: " + findMinSalaryEmployee(employees));
        System.out.println();
        System.out.println("Сотрудник с максимальной зарплатой: " + findMaxSalaryEmployee(employees));
        System.out.println();
        System.out.println("Средняя зарплата среди сотрудников: " + calculateAverageEmployeesSalary(employees));
        System.out.println();
        printEmployeesFullNames(employees);
        indexSalariesBy15Percent(employees);
        printEmployees(employees);
        System.out.println("Сотрудник с минимальной зарплатой в отделе 2: " + findMinSalaryEmployeeByDepartment(employees, 2));
        System.out.println("Сотрудник с максимальной зарплатой в отделе 5: " + findMaxSalaryEmployeeByDepartment(employees, 5));
        System.out.println("Сумма затрат на зарплаты в отделе 1 в месяц: " + calculateTotalSalarySumPerMonthByDepartment(employees, 1));
        System.out.println("Средняя зарплата среди сотрудников в отделе 4: " + calculateAverageEmployeesSalaryByDepartment(employees, 4));
        indexSalariesBy15PercentInDepartment(employees, 3);
        printEmployeesInDepartment(employees, 3);
        System.out.println(findEmployeesWithLessSalary(employees, 100_000));
        System.out.println(findEmployeesWithBiggerSalary(employees, 500_000));


    }

    public static void printEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    public static double calculateTotalSalarySumPerMonth(Employee[] employees) {
        if (employees.length == 0) {
            return 0;
        } else {
            double sum = 0;
            for (Employee employee : employees) {
                sum += employee.getSalary();
            }
            return sum;
        }
    }

    public static String findMinSalaryEmployee(Employee[] employees) {
        if (employees.length == 0) {
            return null;
        } else {
            double min = employees[0].getSalary();
            String poorEmployee = null;
            for (Employee employee : employees) {
                if (employee.getSalary() < min) {
                    min = employee.getSalary();
                    poorEmployee = employee.getFullName();
                }
            }
            return poorEmployee;
        }
    }

    public static String findMaxSalaryEmployee(Employee[] employees) {
        if (employees.length == 0) {
            return null;
        } else {
            double max = employees[0].getSalary();
            String richEmployee = null;
            for (Employee employee : employees) {
                if (employee.getSalary() > max) {
                    max = employee.getSalary();
                    richEmployee = employee.getFullName();
                }
            }
            return richEmployee;
        }
    }

    public static double calculateAverageEmployeesSalary(Employee[] employees) {
        return calculateTotalSalarySumPerMonth(employees) / employees.length;
    }

    public static void printEmployeesFullNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public static void indexSalariesBy15Percent(Employee[] employees) {
        if (employees.length != 0) {
            // увеличиваем зарплату на 15%
            double index = 1.15;

            for (Employee employee : employees) {
                employee.setSalary(employee.getSalary() * index);
            }
        }
    }

    public static String findMinSalaryEmployeeByDepartment(Employee[] employees, int department) {
        if (employees.length == 0) {
            return null;
        } else {
            String poorEmployee = null;
            double min = Double.MAX_VALUE;
            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == department && employee.getSalary() < min) {
                    min = employee.getSalary();
                    poorEmployee = employee.getFullName();
                }
            }
            return poorEmployee;

        }
    }

    public static String findMaxSalaryEmployeeByDepartment(Employee[] employees, int department) {
        if (employees.length == 0) {
            return null;
        } else {
            String richEmployee = null;
            double max = Double.MIN_VALUE;
            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == department && employee.getSalary() > max) {
                    max = employee.getSalary();
                    richEmployee = employee.getFullName();
                }
            }
            return richEmployee;

        }
    }

    public static double calculateTotalSalarySumPerMonthByDepartment(Employee[] employees, int department) {
        if (employees.length == 0) {
            return 0;
        } else {
            double sum = 0;
            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == department) {
                    sum += employee.getSalary();
                }
            }
            return sum;
        }

    }

    public static double calculateAverageEmployeesSalaryByDepartment(Employee[] employees, int department) {
        if (employees.length == 0) {
            return 0;
        } else {
            int count = 0;
            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == department) {
                    count++;
                }
            }
            return calculateTotalSalarySumPerMonthByDepartment(employees, department) / count;

        }

    }

    public static void indexSalariesBy15PercentInDepartment(Employee[] employees, int department) {
        if (employees.length != 0) {
            // увеличиваем зарплату на 15%
            double index = 1.15;

            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == department) {
                    employee.setSalary(employee.getSalary() * index);
                }
            }
        }
    }

    public static void printEmployeesInDepartment(Employee[] employees,int department) {
        System.out.println("Сотрудники отдела " + department + ": ");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("Full name" + employee.getFullName() + ". Salary: " + format("%.2f", employee.getSalary()));
            }
        }
    }

    public static String findEmployeesWithLessSalary(Employee[] employees, int value) {
        if (employees.length == 0) {
            return null;
        } else {
            System.out.println("Сотрудники компании с зарплатой, меньше " + value + ": ");
            String someEmployee = null;
            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getSalary() < value) {
                    someEmployee = "Id: " + employee.getId() + ". Full name: " + employee.getFullName() + ". Salary: " + format("%.2f", employee.getSalary()) + ".";
                }
            }
            return someEmployee;

        }
    }

    public static String findEmployeesWithBiggerSalary(Employee[] employees, int value) {
        if (employees.length == 0) {
            return null;
        } else {
            System.out.println("Сотрудники компании с зарплатой, больше или равно " + value + ": ");
            String someEmployee = null;
            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getSalary() >= value) {
                    someEmployee = "Id: " + employee.getId() + ". Full name: " + employee.getFullName() + ". Salary: " + format("%.2f", employee.getSalary()) + ".";
                }
            }
            return someEmployee;

        }
    }
}
