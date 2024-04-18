package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        //Create new Application
        App a = new App();
        //Connect to database
        a.connect();

        //Disconnect from database
        a.disconnect();

        public city getCity(int ID)
        {
            try
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT "
                                + "FROM world.sql "
                                + "WHERE emp_no = " + ID;
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Return new employee if valid.
                // Check one is returned
                if (rset.next())
                {
                    Employee emp = new Employee();
                    emp.emp_no = rset.getInt("emp_no");
                    emp.first_name = rset.getString("first_name");
                    emp.last_name = rset.getString("last_name");
                    return emp;
                }
                else
                    return null;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get employee details");
                return null;
            }

        }

    }
}