import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;

public class HashTableMethod {
    public static void main(String[] args) {
        // Q4
        Hashtable<Integer, Integer> table = new Hashtable<>();
        table.put(0, 1);
        table.put(1, 3);
        table.put(2, 5);
        table.put(3, 7);
        table.put(4, 9);
        table.put(5, 11);
        System.out.println("Before");
        for (int i = 0; i < table.size(); i++) {
            System.out.print(table.get(i) + " ");
        }
        addAndSort(table, 4);
        System.out.println("\nAfter");
        for (int i = 0; i < table.size(); i++) {
            System.out.print(table.get(i) + " ");
        }

        // Q5
        table = new Hashtable<>();
        table.put(0, 1);
        table.put(1, 3);
        table.put(2, 5);
        table.put(3, 7);
        table.put(4, 9);
        table.put(5, 11);
        swapIndex(table, 1, 5);
        System.out.println("\n\nSwap");
        for (int i = 0; i < table.size(); i++) {
            System.out.print(table.get(i) + " ");
        }

        // Q6
        table = randomIntTable(500, 1000, 9999);
        int searchVal = randomInt(1000, 9999);
        System.out.println("\n\nRandom Value: " + searchVal);
        int searchResult = findValue(table, searchVal);
        System.out.println("Found: " + searchResult);
    }

    private static void addAndSort(Hashtable<Integer, Integer> table, int value) {
        table.put(table.size(), value);
        ArrayList<Integer> list = new ArrayList<>(table.values());
        list.sort((a, b) -> a.compareTo(b));

        for (int i = 0; i < table.size(); i++) {
            table.put(i, list.get(i));
        }
    }

    private static void swapIndex(Hashtable<Integer, Integer> table, int index1, int index2) {
        int ele1 = table.get(index1);
        int ele2 = table.get(index2);
        table.put(index1, ele2);
        table.put(index2, ele1);
    }

    private static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private static Hashtable<Integer, Integer> randomIntTable(int size, int min, int max) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        for (int i = 0; i < 500; i++) {
            table.put(i, randomInt(min, max + 1));
        }
        return table;
    }

    private static int findValue(Hashtable<Integer, Integer> table, int searchVal) {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i) == searchVal) {
                return i;
            }
        }
        return -1;
    }
}
