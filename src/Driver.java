import java.util.*;

public class Driver {
    public static void main(String[] args) {

    int[] array = new int[100000];
    int[] array2 = new int[array.length];
    Random random = new Random();
    int processors = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < array.length; i++)
    {
        array[i] = random.nextInt(10);
        array2[i] = array[i];
    }



    for (int i :array){
        System.out.println("Unsorted array: " + i);

    }
        System.out.println("-");



        long t1 = System.nanoTime();
    QuickSort qs = new QuickSort(array);
    qs.sort();
        int arrayqs[] = qs.array;
        long t2 = System.nanoTime();
        long t3 = t2-t1;

        for (int i :array2){
            System.out.println("Unsorted array: " + i);
        }

        long tp1 = System.nanoTime();
    QuickSortParallel qsp = new QuickSortParallel(array, 0, array.length-1);
        qsp.quickSortP(array, 0, (array.length-1));
        int[] arrayqsp = qsp.array;

        long tp2 = System.nanoTime();
        long tp3 = tp2-tp1;



    /*for (int i :arrayqsp){
        System.out.println("Sorted array: " + i);
    }                     */
        System.out.println("Execution time (parallel):   " + tp3);
        System.out.println("Execution time (sequntial):  " + t3);
        System.out.println("Percent faster : " + ((float)t3/(float)tp3)*100 + "%");
        System.out.println("Array length: " + array.length);
        System.out.println("Number of processors: " + processors);

        //17792370
        //16587925

        //92466090
        //64943221
        //63606275


    }

}
