import java.util.Arrays;

public class StringOperations {
    
    public static void main(String[] args) {
        System.out.println("=== String Operations Demonstration ===\n");
        
        // Sample strings for demonstration
        String str1 = "Hello World";
        String str2 = "HELLO WORLD";
        String str3 = "   Java Programming   ";
        String str4 = "Hello";
        String str5 = "World";
        
        // 1. String, StringBuffer, StringBuilder comparison
        System.out.println("=== Comparison: String vs StringBuffer vs StringBuilder ===");
        System.out.println("1. String:");
        System.out.println("   - Immutable (cannot be changed)");
        System.out.println("   - Thread-safe");
        System.out.println("   - Stored in String Pool");
        System.out.println("   - Use when string won't change frequently");
        
        System.out.println("\n2. StringBuffer:");
        System.out.println("   - Mutable (can be changed)");
        System.out.println("   - Thread-safe (synchronized)");
        System.out.println("   - Slower than StringBuilder");
        System.out.println("   - Use when thread safety is required");
        
        System.out.println("\n3. StringBuilder:");
        System.out.println("   - Mutable (can be changed)");
        System.out.println("   - NOT thread-safe");
        System.out.println("   - Faster than StringBuffer");
        System.out.println("   - Use in single-threaded environment");
        
        // Demonstrations
        System.out.println("\n=== String Operations ===");
        
        // length()
        System.out.println("1. length() method:");
        System.out.println("   Length of \"" + str1 + "\": " + str1.length());
        
        // isEmpty()
        System.out.println("\n2. isEmpty() method:");
        System.out.println("   Is \"" + str1 + "\" empty? " + str1.isEmpty());
        System.out.println("   Is empty string empty? " + "".isEmpty());
        
        // charAt()
        System.out.println("\n3. charAt() method:");
        System.out.println("   Character at index 4 in \"" + str1 + "\": " + str1.charAt(4));
        
        // toString()
        System.out.println("\n4. toString() method:");
        Integer num = 123;
        System.out.println("   Integer to String: " + num.toString());
        
        // equals()
        System.out.println("\n5. equals() method:");
        System.out.println("   \"" + str1 + "\" equals \"" + str2 + "\"? " + str1.equals(str2));
        System.out.println("   \"" + str1 + "\" equalsIgnoreCase \"" + str2 + "\"? " + str1.equalsIgnoreCase(str2));
        
        // compareTo()
        System.out.println("\n6. compareTo() method:");
        System.out.println("   \"" + str4 + "\" compareTo \"" + str5 + "\": " + str4.compareTo(str5));
        System.out.println("   \"" + str5 + "\" compareTo \"" + str4 + "\": " + str5.compareTo(str4));
        
        // contains()
        System.out.println("\n7. contains() method:");
        System.out.println("   \"" + str1 + "\" contains \"World\"? " + str1.contains("World"));
        System.out.println("   \"" + str1 + "\" contains \"Java\"? " + str1.contains("Java"));
        
        // indexOf()
        System.out.println("\n8. indexOf() method:");
        System.out.println("   Index of 'o' in \"" + str1 + "\": " + str1.indexOf('o'));
        System.out.println("   Index of \"World\" in \"" + str1 + "\": " + str1.indexOf("World"));
        
        // lastIndexOf()
        System.out.println("\n9. lastIndexOf() method:");
        System.out.println("   Last index of 'o' in \"" + str1 + "\": " + str1.lastIndexOf('o'));
        
        // startsWith()
        System.out.println("\n10. startsWith() method:");
        System.out.println("   \"" + str1 + "\" startsWith \"Hello\"? " + str1.startsWith("Hello"));
        System.out.println("   \"" + str1 + "\" startsWith \"World\"? " + str1.startsWith("World"));
        
        // endsWith()
        System.out.println("\n11. endsWith() method:");
        System.out.println("   \"" + str1 + "\" endsWith \"World\"? " + str1.endsWith("World"));
        System.out.println("   \"" + str1 + "\" endsWith \"Hello\"? " + str1.endsWith("Hello"));
        
        // matches()
        System.out.println("\n12. matches() method:");
        String email = "test@example.com";
        System.out.println("   \"" + email + "\" matches email pattern? " + 
                          email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"));
        
        // substring()
        System.out.println("\n13. substring() method:");
        System.out.println("   Substring from index 6 of \"" + str1 + "\": " + str1.substring(6));
        System.out.println("   Substring from index 0 to 5 of \"" + str1 + "\": " + str1.substring(0, 5));
        
        // toLowerCase()
        System.out.println("\n14. toLowerCase() method:");
        System.out.println("   \"" + str2 + "\" to lowercase: " + str2.toLowerCase());
        
        // trim()
        System.out.println("\n15. trim() method:");
        System.out.println("   Original: \"" + str3 + "\"");
        System.out.println("   After trim: \"" + str3.trim() + "\"");
        
        // replace()
        System.out.println("\n16. replace() method:");
        System.out.println("   Replace 'l' with 'L' in \"" + str4 + "\": " + str4.replace('l', 'L'));
        System.out.println("   Replace \"World\" with \"Java\" in \"" + str1 + "\": " + 
                          str1.replace("World", "Java"));
        
        // split()
        System.out.println("\n17. split() method:");
        String sentence = "Java,Python,JavaScript,C++";
        System.out.println("   Original: " + sentence);
        String[] languages = sentence.split(",");
        System.out.println("   After split by comma: " + Arrays.toString(languages));
        
        // join()
        System.out.println("\n18. join() method:");
        String[] words = {"Java", "is", "awesome"};
        System.out.println("   Joined with space: " + String.join(" ", words));
        System.out.println("   Joined with hyphen: " + String.join("-", words));
        
        // valueOf()
        System.out.println("\n19. valueOf() method:");
        int number = 100;
        double price = 99.99;
        boolean flag = true;
        System.out.println("   int to String: " + String.valueOf(number));
        System.out.println("   double to String: " + String.valueOf(price));
        System.out.println("   boolean to String: " + String.valueOf(flag));
        
        // StringBuilder and StringBuffer examples
        System.out.println("\n=== StringBuilder and StringBuffer Examples ===");
        
        // StringBuilder
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, ",");
        sb.reverse();
        System.out.println("StringBuilder operations:");
        System.out.println("   Result: " + sb.toString());
        
        // StringBuffer
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" Java");
        sbf.replace(0, 5, "Hi");
        System.out.println("StringBuffer operations:");
        System.out.println("   Result: " + sbf.toString());
    }
}