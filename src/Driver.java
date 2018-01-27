import java.util.*;

public class Driver {
    public static void main(String[] args) {

    int[] array = new int[1000000];
    Random random = new Random();

        for (int i = 0; i < array.length; i++)
    {
        array[i] = random.nextInt(10000);
    }

    /*for (int i :array){
        System.out.println("Unsorted array: " + i);
    }*/

    long t1 = System.nanoTime();

    QuickSort qs = new QuickSort(array);
    qs.sort();

   /*QuickSortParallel qs = new QuickSortParallel(array, "mjao", 0, array.length-1);
        qs.quickSort(array, 0, (array.length-1));
        array = qs.array;*/

        long t2 = System.nanoTime();
        long t3 = t2-t1;

    for (int i :array){
        System.out.println("Sorted array: " + i);
    }
        System.out.println("Execution time: " + t3);
        System.out.println("Execution time: " + t1);
        System.out.println("Execution time: " + t2);
        //17792370
        //16587925

        //92466090
        //64943221
        //63606275


    }

}
