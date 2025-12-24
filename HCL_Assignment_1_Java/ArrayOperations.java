import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    private static int[] array = new int[100];
    private static int size = 0;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choice;
        
        do {
            System.out.println("\n=== Array Operations Menu ===");
            System.out.println("1. Insert Element");
            System.out.println("2. Delete Element");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum Value");
            System.out.println("6. Count Even/Odd Numbers");
            System.out.println("7. Perform Insertion Sort");
            System.out.println("8. Display Array");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    insertElement();
                    break;
                case 2:
                    deleteElement();
                    break;
                case 3:
                    linearSearch();
                    break;
                case 4:
                    binarySearch();
                    break;
                case 5:
                    findMaximum();
                    break;
                case 6:
                    countEvenOdd();
                    break;
                case 7:
                    insertionSort();
                    break;
                case 8:
                    displayArray();
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while(choice != 9);
    }
    
    private static void insertElement() {
        if(size >= array.length) {
            System.out.println("Array is full!");
            return;
        }
        
        System.out.print("Enter element to insert: ");
        int element = scanner.nextInt();
        array[size] = element;
        size++;
        System.out.println("Element inserted successfully!");
    }
    
    private static void deleteElement() {
        if(size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        
        System.out.print("Enter element to delete: ");
        int element = scanner.nextInt();
        int index = -1;
        
        for(int i = 0; i < size; i++) {
            if(array[i] == element) {
                index = i;
                break;
            }
        }
        
        if(index == -1) {
            System.out.println("Element not found!");
            return;
        }
        
        for(int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        System.out.println("Element deleted successfully!");
    }
    
    private static void linearSearch() {
        if(size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        
        System.out.print("Enter element to search: ");
        int element = scanner.nextInt();
        
        for(int i = 0; i < size; i++) {
            if(array[i] == element) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
        
        System.out.println("Element not found!");
    }
    
    private static void binarySearch() {
        if(size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        
        // Create a sorted copy for binary search
        int[] sortedArray = Arrays.copyOf(array, size);
        Arrays.sort(sortedArray);
        
        System.out.print("Enter element to search: ");
        int element = scanner.nextInt();
        
        int left = 0, right = size - 1;
        boolean found = false;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(sortedArray[mid] == element) {
                System.out.println("Element found in sorted array!");
                found = true;
                break;
            } else if(sortedArray[mid] < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if(!found) {
            System.out.println("Element not found!");
        }
    }
    
    private static void findMaximum() {
        if(size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        
        int max = array[0];
        for(int i = 1; i < size; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        
        System.out.println("Maximum value: " + max);
    }
    
    private static void countEvenOdd() {
        if(size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        
        int evenCount = 0, oddCount = 0;
        
        for(int i = 0; i < size; i++) {
            if(array[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);
    }
    
    private static void insertionSort() {
        if(size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        
        for(int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            
            while(j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        
        System.out.println("Array sorted successfully using Insertion Sort!");
    }
    
    private static void displayArray() {
        if(size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        
        System.out.print("Array elements: ");
        for(int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}