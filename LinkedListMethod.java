import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class LinkedListMethod {
    public static void main(String[] args) {
        // Q1
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 3, 5, 7, 9, 11));
        System.out.println("Before");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        addAndSort(list, 4);
        System.out.println("\nAfter");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // Q2
        list = new LinkedList<>(Arrays.asList(1, 3, 5, 7, 9, 11));
        swapIndex(list, 1, 5);
        System.out.println("\n\nSwap");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // Q3
        list = new LinkedList<>(randomIntArray(500, 1000, 9999));
        int searchVal = randomInt(1000, 9999);
        System.out.println("\n\nRandom Value: " + searchVal);
        int searchResult = findValue(list, searchVal);
        System.out.println("Found: " + searchResult);
    }

    private static void addAndSort(LinkedList<Integer> list, int value) {
        list.add(value);
        list.sort((a, b) -> a.compareTo(b));
    }

    private static void swapIndex(LinkedList<Integer> list, int index1, int index2) {
        int ele1 = list.get(index1);
        int ele2 = list.get(index2);
        list.set(index1, ele2);
        list.set(index2, ele1);
    }

    private static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private static ArrayList<Integer> randomIntArray(int size, int min, int max) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < 500; i++) {
            array.add(randomInt(min, max + 1));
        }
        return array;
    }

    private static int findValue(LinkedList<Integer> list, int searchVal) {
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            if (val == searchVal) {
                return val;
            }
        }
        return -1;
    }
}
