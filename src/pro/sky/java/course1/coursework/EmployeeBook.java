package pro.sky.java.course1.coursework;

import static java.lang.String.format;

public class EmployeeBook {

    private final Employee[] company;

    public EmployeeBook(int companySize) {
        company = new Employee[companySize];
    }

    public boolean addNewEmployee(Employee employee) {
        for (int i = 0; i < company.length; i++) {
            if (company[i] == null) {
                company[i] = employee;
                return true;
            }
            }
        return false;
    }

    public boolean dismissEmployee(String fullName) {
        for (int i = 0; i < company.length; i++) {
            if (company[i].getFullName() != null && company[i].getFullName().equals(fullName)) {
                company[i] = null;
                return true;
            }
        }
        return false;
    }

    public void changeEmployeeDepartment(String fullName, int newDepartment) {
        for (Employee employee : company) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                employee.setDepartment(newDepartment);

            }
        }
    }

    public void changeEmployeeSalary(String fullName, int newSalary) {
        for (Employee employee : company) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                employee.setSalary(newSalary);
            }
        }
    }

    public boolean isArrayEmpty(Employee[] company) {
        return company.length == 0;
    }

    public void printEmployees() {
        for (Employee employee : company) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    public double calculateTotalSalarySumPerMonth() {
        if (isArrayEmpty(company)) {
            return 0;
        } else {
            double sum = 0;
            for (Employee employee : company) {
                sum += employee.getSalary();
            }
            return sum;
        }
    }

    public String findMinSalaryEmployee() {
        if (isArrayEmpty(company)) {
            return null;
        } else {
            double min = company[0].getSalary();
            String poorEmployee = null;
            for (Employee employee : company) {
                if (employee.getSalary() < min) {
                    min = employee.getSalary();
                    poorEmployee = employee.getFullName();
                }
            }
            return poorEmployee;
        }
    }

    public String findMaxSalaryEmployee() {
        if (isArrayEmpty(company)) {
            return null;
        } else {
            double max = company[0].getSalary();
            String richEmployee = null;
            for (Employee employee : company) {
                if (employee.getSalary() > max) {
                    max = employee.getSalary();
                    richEmployee = employee.getFullName();
                }
            }
            return richEmployee;
        }
    }

    public double calculateAverageEmployeesSalary() {
        return calculateTotalSalarySumPerMonth() / company.length;
    }

    public void printEmployeesFullNames() {
        for (Employee employee : company) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void indexSalariesBy15Percent() {
        if (company.length != 0) {
            // увеличиваем зарплату на 15%
            double index = 1.15;

            for (Employee employee : company) {
                employee.setSalary(employee.getSalary() * index);
            }
        }
    }

    public String findMinSalaryEmployeeByDepartment(int department) {
        if (isArrayEmpty(company)) {
            return null;
        } else {
            String poorEmployee = null;
            double min = Double.MAX_VALUE;
            for (Employee employee : company) {
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

    public String findMaxSalaryEmployeeByDepartment(int department) {
        if (isArrayEmpty(company)) {
            return null;
        } else {
            String richEmployee = null;
            double max = Double.MIN_VALUE;
            for (Employee employee : company) {
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

    public double calculateTotalSalarySumPerMonthByDepartment(int department) {
        if (isArrayEmpty(company)) {
            return 0;
        } else {
            double sum = 0;
            for (Employee employee : company) {
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

    public double calculateAverageEmployeesSalaryByDepartment(int department) {
        if (isArrayEmpty(company)) {
            return 0;
        } else {
            int count = 0;
            for (Employee employee : company) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == department) {
                    count++;
                }
            }
            return calculateTotalSalarySumPerMonthByDepartment(department) / count;

        }

    }

    public void indexSalariesBy15PercentInDepartment(int department) {
        if (company.length != 0) {
            // увеличиваем зарплату на 15%
            double index = 1.15;

            for (Employee employee : company) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == department) {
                    employee.setSalary(employee.getSalary() * index);
                }
            }
        }
    }

    public void printEmployeesInDepartment(int department) {
        System.out.println("Сотрудники отдела " + department + ": ");
        for (Employee employee : company) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("Full name: " + employee.getFullName() + ". Salary: " + format("%.2f", employee.getSalary()));
            }
            }
        }


    public String findEmployeesWithLessSalary(int value) {
        if (isArrayEmpty(company)) {
            return null;
        } else {
            System.out.println("Сотрудники компании с зарплатой, меньше " + value + ": ");
            String someEmployee = null;
            for (Employee employee : company) {
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

    public String findEmployeesWithBiggerSalary(int value) {
        if (isArrayEmpty(company)) {
            return null;
        } else {
            System.out.println("Сотрудники компании с зарплатой, больше или равно " + value + ": ");
            String someEmployee = null;
            for (Employee employee : company) {
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


