package com.uccases;

import java.util.Random;

class EmpWageForMultipleCompany {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULLTIME = 2;
    private final String company;
    private final int empRatePerHour;
    private final int numOfWorkingDays;
    private final int maxHoursPerMonth;
    private int totalEmpWage;

    public EmpWageForMultipleCompany(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        super();
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
    }

    public void computeEmpWage() {
        int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
        Random random = new Random();
        while (totalEmpHrs <= maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = random.nextInt(3);
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                case IS_FULLTIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day :" + totalWorkingDays + " Emp Hr:" + empHrs);
        }
        totalEmpWage = totalEmpHrs * empRatePerHour;
    }

    @Override
    public String toString() {
        return " [company=" + company + ", totalEmpWage=" + totalEmpWage + "]";
    }
}

public final class EmployeeWageBuilder {

    public static void main(String[] args) {
        EmpWageForMultipleCompany tcs = new EmpWageForMultipleCompany("TCS", 20, 2, 10);
        tcs.computeEmpWage();
        System.out.println(tcs);
        EmpWageForMultipleCompany accenture = new EmpWageForMultipleCompany("Accenture", 10, 4, 20);
        accenture.computeEmpWage();
        System.out.println(accenture);
    }
}