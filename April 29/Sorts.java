import java.util.*;

public class Sorts {
    public static void bubbleSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void modifiedBubbleSort(int[] array) {
        boolean sorted = false;
        for(int i = 0; i < array.length && !sorted; i++) {
            sorted = true;
            for(int j = 0; j < array.length - (i + 1); j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smalLoc = i;
            for (int j = 0; j < array.length; j++) {
                if (array[j] < array[smalLoc]) {
                    smalLoc = j;
                }
            }

            if (smalLoc != 1) {
                int temp = array[i];
                array[i] = array[smalLoc];
                array[smalLoc] = temp;
            }

        }
    }

    public static final void main(String[] args) {
        Random random = new Random();
        int[] original = new int[100000];
        System.out.println("Sorting using " + original.length + " elements.");
        System.out.println();
        for(int i = 0; i < original.length; i++) {
            original[i] = random.nextInt(original.length * 3);
        }
        int[] bubble = new int[original.length];
        // System.arraycopy(source array, starting index of source array, destination array, 
        // starting index of destination array, number of elements to copy);
        System.arraycopy(original, 0, bubble, 0, original.length);
        int[] modifiedBubble = Arrays.copyOf(original, original.length);

        long startTime = 0, endTime = 0;
        startTime = System.nanoTime();
        Arrays.sort(original);
        endTime = System.nanoTime();
        System.out.println("Arrays.sort took " + ((endTime - startTime) / 1E6) + " msec.");

        startTime = System.nanoTime();
        Sorts.bubbleSort(bubble);
        endTime = System.nanoTime();
        System.out.println("Bubble Sort took " + ((endTime - startTime) / 1E6) + " msec.");
        if(!Arrays.equals(original, bubble)) {
            System.out.println("Bubble Sort is broken.");
            System.out.println(Arrays.toString(bubble));
        }

        startTime = System.nanoTime();
        Sorts.modifiedBubbleSort(modifiedBubble);
        endTime = System.nanoTime();
        System.out.println("Modified Bubble Sort took " + ((endTime - startTime) / 1E6) + " msec.");
        if(!Arrays.equals(original, modifiedBubble)) {
            System.out.println("Modified Bubble Sort is broken.");
            System.out.println(Arrays.toString(bubble));
        }
    }
}