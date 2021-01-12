package com.uccases;

import java.util.Random;

public final class EmployeeWageBuilder {

    public static void main(String[] args) {
        computeEmpWage();
    }
    public static int computeEmpWage(){
        final int Is_Full_Time = 1;
        final int Is_Part_Time = 2;
        Random random = new Random();
        final int empRatePerHr = 20;
        int empHrs = 0;
        int totalEmpHrs = 0;
        final int totalWorkingDays = 20;
        int workingDays = 0;
        while (workingDays < totalWorkingDays && empHrs <= totalEmpHrs) {
            int empCheck = random.nextInt(3);
            workingDays++;
            switch (empCheck) {
                case Is_Full_Time:
                    empHrs = 8;
                    break;
                case Is_Part_Time:
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day :"+workingDays+" Emp Hr: "+empHrs);
        }
        System.out.println("TotalEmpHrs : " + totalEmpHrs);
        int salary = totalEmpHrs * empRatePerHr;
        System.out.println("Salary : " + salary);
        return salary;
    }
}
