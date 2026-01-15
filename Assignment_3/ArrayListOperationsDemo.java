package Assignment_3;
import java.util.*;

class ArrayListOperationsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>(10);
        ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(1,2,3));

        a1.add(10);
        a1.add(20);
        a1.add(1,30);
        a1.addAll(a3);
        a1.get(0);
        a1.set(0,99);
        a1.remove(1);
        a1.remove(Integer.valueOf(30));
        a1.contains(20);
        a1.indexOf(20);
        a1.lastIndexOf(20);
        a1.isEmpty();
        a1.size();
        a1.subList(0,2);
        a1.toArray();
        a1.clear();
    }
}
