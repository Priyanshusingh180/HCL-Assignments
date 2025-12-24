import java.util.Scanner;

public class BasicMathOperations {
    
    // Method for addition
    public static double add(double a, double b) {
        return a + b;
    }
    
    // Method for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    // Method for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    // Method for division
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }
    
    // Method for remainder
    public static double remainder(double a, double b) {
        return a % b;
    }
    
    // Method for square
    public static double square(double a) {
        return a * a;
    }
    
    // Method for cube
    public static double cube(double a) {
        return a * a * a;
    }
    
    // Method for absolute value
    public static double absolute(double a) {
        return Math.abs(a);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Basic Mathematics Operations Program ===");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Remainder");
        System.out.println("6. Square");
        System.out.println("7. Cube");
        System.out.println("8. Absolute Value");
        System.out.println("9. All Operations");
        System.out.print("Enter your choice (1-9): ");
        
        int choice = scanner.nextInt();
        
        switch(choice) {
            case 1:
                System.out.print("Enter first number: ");
                double a1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b1 = scanner.nextDouble();
                System.out.println("Result: " + add(a1, b1));
                break;
                
            case 2:
                System.out.print("Enter first number: ");
                double a2 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b2 = scanner.nextDouble();
                System.out.println("Result: " + subtract(a2, b2));
                break;
                
            case 3:
                System.out.print("Enter first number: ");
                double a3 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b3 = scanner.nextDouble();
                System.out.println("Result: " + multiply(a3, b3));
                break;
                
            case 4:
                System.out.print("Enter first number: ");
                double a4 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b4 = scanner.nextDouble();
                try {
                    System.out.println("Result: " + divide(a4, b4));
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
                
            case 5:
                System.out.print("Enter first number: ");
                double a5 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b5 = scanner.nextDouble();
                System.out.println("Result: " + remainder(a5, b5));
                break;
                
            case 6:
                System.out.print("Enter a number: ");
                double a6 = scanner.nextDouble();
                System.out.println("Result: " + square(a6));
                break;
                
            case 7:
                System.out.print("Enter a number: ");
                double a7 = scanner.nextDouble();
                System.out.println("Result: " + cube(a7));
                break;
                
            case 8:
                System.out.print("Enter a number: ");
                double a8 = scanner.nextDouble();
                System.out.println("Result: " + absolute(a8));
                break;
                
            case 9:
                System.out.print("Enter first number: ");
                double a9 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b9 = scanner.nextDouble();
                
                System.out.println("\n=== All Operations ===");
                System.out.println("Addition: " + add(a9, b9));
                System.out.println("Subtraction: " + subtract(a9, b9));
                System.out.println("Multiplication: " + multiply(a9, b9));
                try {
                    System.out.println("Division: " + divide(a9, b9));
                } catch (ArithmeticException e) {
                    System.out.println("Division: " + e.getMessage());
                }
                System.out.println("Remainder: " + remainder(a9, b9));
                System.out.println("Square of " + a9 + ": " + square(a9));
                System.out.println("Square of " + b9 + ": " + square(b9));
                System.out.println("Cube of " + a9 + ": " + cube(a9));
                System.out.println("Cube of " + b9 + ": " + cube(b9));
                System.out.println("Absolute of " + a9 + ": " + absolute(a9));
                System.out.println("Absolute of " + b9 + ": " + absolute(b9));
                break;
                
            default:
                System.out.println("Invalid choice!");
        }
        
        scanner.close();
    }
} 
    

