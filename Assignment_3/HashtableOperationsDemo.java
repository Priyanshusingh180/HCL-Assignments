package Assignment_3;
import java.util.*;

class HashtableOperationsDemo {
    public static void main(String[] args) {
        Hashtable<Integer,String> h1 = new Hashtable<>();
        Hashtable<Integer,String> h2 = new Hashtable<>(10);
        Hashtable<Integer,String> h3 = new Hashtable<>(10,0.75f);
        Hashtable<Integer,String> h4 = new Hashtable<>(Map.of(1,"A",2,"B"));

        h1.put(1,"One");
        h1.put(2,"Two");
        h1.putIfAbsent(3,"Three");
        h1.get(1);
        h1.containsKey(2);
        h1.containsValue("Two");
        h1.remove(2);
        h1.replace(1,"Uno");
        h1.size();
        h1.isEmpty();
        h1.keys();
        h1.elements();
        h1.keySet();
        h1.values();
        h1.clear();
    }
}
