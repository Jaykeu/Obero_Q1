import java.util.Scanner;

public class StudentEnrollment {

    // Method to calculate total fee based on the number of units
    public static double calculateTotalFee(int units) {
        int feePerUnit = 1000; // Fee per unit is 1000
        return units * feePerUnit;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input section: Get student information
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();

        // Input the number of units
        int numberOfUnits;
        do {
            System.out.print("Enter Number of Units (Maximum 10): ");
            numberOfUnits = scanner.nextInt();
        } while (numberOfUnits < 1 || numberOfUnits > 10);  // Ensure units are between 1 and 10

        // Calculate the total enrollment fee
        double totalFee = calculateTotalFee(numberOfUnits);
        int feePerUnit = 1000;

        // Output student details and the total fee
        System.out.println("\n=== Enrollment Summary ===");
        System.out.println("Student Name: " + studentName);
        System.out.println("Course: " + course);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Number of Units: " + numberOfUnits);
        System.out.println("Fee per Unit: PHP " + feePerUnit);
        System.out.println("Total Enrollment Fee: PHP " + totalFee);

        // Payment section: Ask for the payment amount
        System.out.print("\nEnter Payment Amount: PHP ");
        double paymentAmount = scanner.nextDouble();

        // Check payment status
        if (paymentAmount == totalFee) {
            System.out.println("Status: Fully Paid");
        } else if (paymentAmount < totalFee && paymentAmount > 0) {
            System.out.println("Status: Partial Payment");
            System.out.println("Amount Paid: PHP " + paymentAmount);
            System.out.println("Remaining Balance: PHP " + (totalFee - paymentAmount));
        } else if (paymentAmount > totalFee) {
            System.out.println("Status: Overpayment");
            System.out.println("Amount Paid: PHP " + paymentAmount);
            System.out.println("Change Due: PHP " + (paymentAmount - totalFee));
        }

        scanner.close();  // Close the scanner to prevent resource leak
    }
}
