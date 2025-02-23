class Employee {
    int empId;
    String empName;
    double sal;
    int yearsOfExperience;

    void setEmployeeDetails(int id, String name, double salary, int experience) {
        this.empId = id;
        this.empName = name;
        this.sal = salary;
        this.yearsOfExperience = experience;
    }

    void getEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Monthly Salary: " + sal);
        System.out.println("Years of Experience: " + yearsOfExperience);
    }

    void getLoanEligibility() {
        if (yearsOfExperience <= 5) {
            System.out.println(empName + " is not eligible for a loan.");
            return;
        }

        double annualSalary = sal * 12;
        double loanAmount = 0;

        if (annualSalary >= 1500000) {
            loanAmount = 700000;
        } else if (annualSalary >= 1000000) {
            loanAmount = 500000;
        } else if (annualSalary >= 600000) {
            loanAmount = 200000;
        }

        if (loanAmount > 0) {
            System.out.println(empName + " is eligible for a loan of Rs." + loanAmount);
        } else {
            System.out.println(empName + " is not eligible for a loan.");
        }
    }
}

public class EmployeeLoanEligibility {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.setEmployeeDetails(101, "Ram", 55000, 6);
        emp1.getEmployeeDetails();
        emp1.getLoanEligibility();

        System.out.println();

        Employee emp2 = new Employee();
        emp2.setEmployeeDetails(102, "Sam", 40000, 4);
        emp2.getEmployeeDetails();
        emp2.getLoanEligibility();
    }
}
