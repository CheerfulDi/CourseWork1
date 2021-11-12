package pro.sky.java.course1.coursework;



public class Main {

    public static void main(String[] args) {

        EmployeeBook company = new EmployeeBook(10);

        company.addNewEmployee(new Employee("Johan Rolling", 100_000, 1));
        company.addNewEmployee(new Employee("Steven Allan Spielberg", 150_000, 1));
        company.addNewEmployee(new Employee("Barry Allen", 250_000, 2));
        company.addNewEmployee(new Employee("Bruce Wayne", 535_000, 2));
        company.addNewEmployee(new Employee("Peter Parker", 225_000, 3));
        company.addNewEmployee(new Employee("Charles Xavier", 35_000, 3));
        company.addNewEmployee(new Employee("Michelle Pfeiffer", 135_000, 4));
        company.addNewEmployee(new Employee("Johnny Depp", 198_000, 4));
        company.addNewEmployee(new Employee("Pablo Picasso", 278_000, 5));
        company.addNewEmployee(new Employee("Claude Monet", 186_000, 5));

        System.out.println("=============================");
        company.printEmployees();
        System.out.println("=============================");
        System.out.println("Сумма затрат на зарплаты в месяц: " + company.calculateTotalSalarySumPerMonth());
        System.out.println("=============================");
        System.out.println("Сотрудник с минимальной зарплатой: " + company.findMinSalaryEmployee());
        System.out.println("=============================");
        System.out.println("Сотрудник с максимальной зарплатой: " + company.findMaxSalaryEmployee());
        System.out.println("=============================");
        System.out.println("Средняя зарплата среди сотрудников: " + company.calculateAverageEmployeesSalary());
        System.out.println("=============================");
        company.printEmployeesFullNames();
        System.out.println("=============================");
        company.indexSalariesBy15Percent();
        company.printEmployeesFullNames();
        System.out.println("=============================");
        System.out.println("Сотрудник с минимальной зарплатой в отделе 2: " + company.findMinSalaryEmployeeByDepartment(2));
        System.out.println("=============================");
        System.out.println("Сотрудник с максимальной зарплатой в отделе 5: " + company.findMaxSalaryEmployeeByDepartment(5));
        System.out.println("=============================");
        System.out.println("Сумма затрат на зарплаты в отделе 1 в месяц: " + company.calculateTotalSalarySumPerMonthByDepartment(1));
        System.out.println("=============================");
        System.out.println("Средняя зарплата среди сотрудников в отделе 4: " + company.calculateAverageEmployeesSalaryByDepartment(4));
        System.out.println("=============================");
        company.indexSalariesBy15PercentInDepartment(3);
        company.printEmployeesInDepartment(3);
        System.out.println("=============================");
        System.out.println(company.findEmployeesWithLessSalary(100_000));
        System.out.println("=============================");
        System.out.println(company.findEmployeesWithBiggerSalary(500_000));
        company.dismissEmployee("Charles Xavier");
        System.out.println("=============================");
        company.printEmployeesFullNames();
        System.out.println("=============================");
        company.changeEmployeeDepartment("Johan Rolling", 2);
        company.printEmployeesInDepartment(2);
        System.out.println("=============================");
        company.changeEmployeeSalary("Bruce Wayne", 510_000);
        company.printEmployeesInDepartment(2);


    }

}
