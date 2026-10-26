package org.howard.edu.lsp.midterm.inheritance;
/** Common superclass for employees.
 * @author Kionne L. McGhee II
 */
public abstract class Employee {
 protected final double hoursWorked, hourlyRate;
 /** @param hoursWorked weekly work hours
  * @param hourlyRate hourly rate
  */
 public Employee(double hoursWorked,double hourlyRate){
  this.hoursWorked=hoursWorked;this.hourlyRate=hourlyRate;
 }
 /** @return calculated weekly wages */
 public abstract double calculatePay();
}