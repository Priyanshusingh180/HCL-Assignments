package Assignment_3;
import java.util.*;

class VectorOperationsDemo {
    public static void main(String[] args) {
        Vector<String> v1 = new Vector<>();
        Vector<String> v2 = new Vector<>(5);
        Vector<String> v3 = new Vector<>(5,2);
        Vector<String> v4 = new Vector<>(List.of("A","B"));

        v1.add("X");
        v1.addElement("Y");
        v1.add(1,"Z");
        v1.get(0);
        v1.set(0,"P");
        v1.remove("Z");
        v1.remove(0);
        v1.contains("Y");
        v1.capacity();
        v1.size();
        v1.firstElement();
        v1.lastElement();
        v1.isEmpty();
        v1.toArray();
        v1.clear();
    }
}
