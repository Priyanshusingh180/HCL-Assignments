package Assignment_3;
import java.util.*;

class TreeMapOperationsDemo {
    public static void main(String[] args) {
        TreeMap<Integer,String> t1 = new TreeMap<>();
        TreeMap<Integer,String> t2 = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<Integer,String> t3 = new TreeMap<>(Map.of(1,"A",2,"B"));
        TreeMap<Integer,String> t4 = new TreeMap<>(t3);

        t1.put(1,"One");
        t1.put(2,"Two");
        t1.putIfAbsent(3,"Three");
        t1.get(1);
        t1.firstKey();
        t1.lastKey();
        t1.higherKey(1);
        t1.lowerKey(2);
        t1.ceilingKey(2);
        t1.floorKey(2);
        t1.pollFirstEntry();
        t1.pollLastEntry();
        t1.containsKey(3);
        t1.size();
        t1.clear();
    }
}
