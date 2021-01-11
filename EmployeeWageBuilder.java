package com.uccases;

import java.util.Random;

public final class EmployeeWageBuilder {
    public static void main(String[] args) {
        final int Is_Full_Time = 1;
        Random random = new Random();
        int empCheck = random.nextInt(2);
        if (empCheck == Is_Full_Time)
            System.out.println("Employee is present");
        else
            System.out.println("Employee is absent");
    }
}
