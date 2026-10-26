package org.howard.edu.lsp.midterm.inheritance;
/** Contractor earning a fifteen-percent hourly premium.
 * @author Kionne L. McGhee II
 */
public class Contractor extends Employee {
    /** @param hoursWorked hours worked
     * @param hourlyRate base hourly rate
     */
    public Contractor(double hoursWorked, double hourlyRate) { super(hoursWorked, hourlyRate); }
    /** @return base wages increased by fifteen percent */
    @Override public double calculatePay() { return hoursWorked * hourlyRate * 1.15; }
}
