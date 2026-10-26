package org.howard.edu.lsp.midterm.inheritance;
/** Full-time employee with overtime. */
public class FullTimeEmployee extends Employee {
 /** Creates employee with hours and rate. */
 public FullTimeEmployee(double hoursWorked,double hourlyRate){super(hoursWorked,hourlyRate);}
 /** @return gross weekly pay */
 @Override public double calculatePay(){return Math.min(40,hoursWorked)*hourlyRate+Math.max(0,hoursWorked-40)*hourlyRate*1.5;}
}
