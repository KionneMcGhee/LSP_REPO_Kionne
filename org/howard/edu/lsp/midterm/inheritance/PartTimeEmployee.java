package org.howard.edu.lsp.midterm.inheritance;
/** Part-time employee earning straight hourly wages.
 * @author Kionne L. McGhee II
 */
public class PartTimeEmployee extends Employee {
    /** @param hoursWorked weekly hours worked
     * @param hourlyRate hourly rate
     */
    public PartTimeEmployee(double hoursWorked, double hourlyRate) { super(hoursWorked, hourlyRate); }
    /** @return straight hourly pay */
    @Override public double calculatePay() { return hoursWorked * hourlyRate; }
}
