package com.uccases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface IcomputeEmpWage {
    void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);
    int computeEmpWage(CompanyEmpWage companyEmpWage);
    void computeEmpWage();
    int getTotalWage(String company);
}

class CompanyEmpWage {
    public final String company;
    public final int empRatePerHour;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public int totalEmpWage;


    CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString() {
        return "company=" + company + ", totalEmpWage=" + totalEmpWage;
    }
}

public class EmployeeWageBuilder implements IcomputeEmpWage {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    ArrayList<CompanyEmpWage> companyEmpWageList;
    private Map<String, CompanyEmpWage> companyEmpWageMap;
    public EmployeeWageBuilder() {
        companyEmpWageList = new ArrayList<>();
        companyEmpWageMap= new HashMap<>();
    }

    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        companyEmpWageList.add(companyEmpWage);
        companyEmpWageMap.put(company, companyEmpWage);
    }

    public void computeEmpWage() {
        for (int i = 0; i < companyEmpWageList.size(); i++) {
            CompanyEmpWage company=companyEmpWageList.get(i);
            company.setTotalEmpWage(this.computeEmpWage(company));
            System.out.println(company);
        }
    }


    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
        Random random = new Random();
        while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
            totalWorkingDays++;

            int empCheck = random.nextInt(3);

            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 4;
                    break;

                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
            }
            totalEmpHrs += empHrs;
            System.out.println("day: " + totalWorkingDays + " EmpHrs: " + empHrs);
        }

        return totalEmpHrs * companyEmpWage.empRatePerHour;
    }


    public static void main(String[] args) {
        IcomputeEmpWage empWageBuilder = new EmployeeWageBuilder();

        empWageBuilder.addCompanyEmpWage("Dmart", 20, 2, 10);
        empWageBuilder.addCompanyEmpWage("Reliance", 10, 4, 20);
        empWageBuilder.computeEmpWage();
        System.out.println("Dmart totalWage ="+empWageBuilder.getTotalWage("Dmart"));
    }

    @Override
    public int getTotalWage(String company) {
        return companyEmpWageMap.get(company).totalEmpWage;

    }
}

