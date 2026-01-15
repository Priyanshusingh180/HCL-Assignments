package Assignment_3;
import java.util.*;

class HashMapOperationsDemo {
    public static void main(String[] args) {
        HashMap<Integer,String> m1 = new HashMap<>();
        HashMap<Integer,String> m2 = new HashMap<>(10);
        HashMap<Integer,String> m3 = new HashMap<>(10,0.75f);
        HashMap<Integer,String> m4 = new HashMap<>(Map.of(1,"A",2,"B"));

        m1.put(1,"One");
        m1.put(2,"Two");
        m1.putIfAbsent(3,"Three");
        m1.get(1);
        m1.getOrDefault(4,"NA");
        m1.containsKey(2);
        m1.containsValue("Two");
        m1.remove(2);
        m1.replace(1,"Uno");
        m1.size();
        m1.isEmpty();
        m1.keySet();
        m1.values();
        m1.entrySet();
        m1.clear();
    }
}
