import java.util.Scanner;

public class MatrixOperations {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choice;
        
        do {
            System.out.println("\n=== Matrix Operations Menu ===");
            System.out.println("1. Matrix Addition");
            System.out.println("2. Matrix Subtraction");
            System.out.println("3. Matrix Multiplication");
            System.out.println("4. Matrix Transpose");
            System.out.println("5. Check Square Matrix");
            System.out.println("6. Check Diagonal Matrix");
            System.out.println("7. Check Identity Matrix");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    matrixAddition();
                    break;
                case 2:
                    matrixSubtraction();
                    break;
                case 3:
                    matrixMultiplication();
                    break;
                case 4:
                    matrixTranspose();
                    break;
                case 5:
                    checkSquareMatrix();
                    break;
                case 6:
                    checkDiagonalMatrix();
                    break;
                case 7:
                    checkIdentityMatrix();
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while(choice != 8);
    }
    
    private static int[][] inputMatrix(String name) {
        System.out.print("Enter number of rows for " + name + ": ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns for " + name + ": ");
        int cols = scanner.nextInt();
        
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements for " + name + ":");
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        return matrix;
    }
    
    private static void displayMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for(int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
    
    private static void matrixAddition() {
        System.out.println("\n=== Matrix Addition ===");
        int[][] matrixA = inputMatrix("Matrix A");
        int[][] matrixB = inputMatrix("Matrix B");
        
        if(matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            System.out.println("Matrices must have same dimensions for addition!");
            return;
        }
        
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        
        System.out.println("\nResult of Matrix Addition:");
        displayMatrix(result);
    }
    
    private static void matrixSubtraction() {
        System.out.println("\n=== Matrix Subtraction ===");
        int[][] matrixA = inputMatrix("Matrix A");
        int[][] matrixB = inputMatrix("Matrix B");
        
        if(matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            System.out.println("Matrices must have same dimensions for subtraction!");
            return;
        }
        
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        
        System.out.println("\nResult of Matrix Subtraction:");
        displayMatrix(result);
    }
    
    private static void matrixMultiplication() {
        System.out.println("\n=== Matrix Multiplication ===");
        int[][] matrixA = inputMatrix("Matrix A");
        int[][] matrixB = inputMatrix("Matrix B");
        
        if(matrixA[0].length != matrixB.length) {
            System.out.println("Number of columns in Matrix A must equal number of rows in Matrix B!");
            return;
        }
        
        int rows = matrixA.length;
        int cols = matrixB[0].length;
        int common = matrixA[0].length;
        int[][] result = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                for(int k = 0; k < common; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        
        System.out.println("\nResult of Matrix Multiplication:");
        displayMatrix(result);
    }
    
    private static void matrixTranspose() {
        System.out.println("\n=== Matrix Transpose ===");
        int[][] matrix = inputMatrix("Matrix");
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        
        System.out.println("\nTranspose of Matrix:");
        displayMatrix(transpose);
    }
    
    private static void checkSquareMatrix() {
        System.out.println("\n=== Check Square Matrix ===");
        int[][] matrix = inputMatrix("Matrix");
        
        if(matrix.length == matrix[0].length) {
            System.out.println("The matrix is a square matrix.");
        } else {
            System.out.println("The matrix is NOT a square matrix.");
        }
    }
    
    private static void checkDiagonalMatrix() {
        System.out.println("\n=== Check Diagonal Matrix ===");
        int[][] matrix = inputMatrix("Matrix");
        
        if(matrix.length != matrix[0].length) {
            System.out.println("The matrix is NOT diagonal (must be square).");
            return;
        }
        
        boolean isDiagonal = true;
        int n = matrix.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && matrix[i][j] != 0) {
                    isDiagonal = false;
                    break;
                }
            }
            if(!isDiagonal) break;
        }
        
        if(isDiagonal) {
            System.out.println("The matrix is a diagonal matrix.");
        } else {
            System.out.println("The matrix is NOT a diagonal matrix.");
        }
    }
    
    private static void checkIdentityMatrix() {
        System.out.println("\n=== Check Identity Matrix ===");
        int[][] matrix = inputMatrix("Matrix");
        
        if(matrix.length != matrix[0].length) {
            System.out.println("The matrix is NOT an identity matrix (must be square).");
            return;
        }
        
        boolean isIdentity = true;
        int n = matrix.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    if(matrix[i][j] != 1) {
                        isIdentity = false;
                        break;
                    }
                } else {
                    if(matrix[i][j] != 0) {
                        isIdentity = false;
                        break;
                    }
                }
            }
            if(!isIdentity) break;
        }
        
        if(isIdentity) {
            System.out.println("The matrix is an identity matrix.");
        } else {
            System.out.println("The matrix is NOT an identity matrix.");
        }
    }
}