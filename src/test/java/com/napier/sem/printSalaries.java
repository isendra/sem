package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class printSalaries {
    @Nested
    class AppTest
    {
        static App app;

        @BeforeAll
        static void init()
        {
            app = new App();
        }

        public void printSalaries(ArrayList<Employee> employees)
        {
            // Check employees is not null
            if (employees == null)
            {
                System.out.println("No employees");
                return;
            }
            // Print header
            System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp No", "First Name", "Last Name", "Salary"));
            // Loop over all employees in the list
            for (Employee emp : employees)
            {
                String emp_string = String.format("%-10s %-15s %-20s %-8s",
                        emp.emp_no, emp.first_name, emp.last_name, emp.salary);
                System.out.println(emp_string);
            }
        }
    }
}
