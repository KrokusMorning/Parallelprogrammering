import java.util.concurrent.*;

public class QuickSortParallel extends Thread {

    int[] array;
    int l;
    int r;


    QuickSortParallel(int[] array, int left, int right) {
        this.array = array;
        this.l = left;
        this.r = right;
    }
    public void run(){
        quickSort(array, l, r);
    }


    int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    void quickSort(int arr[], int left, int right) {
        if (right>left){
        System.out.println("Thread name " + getName());
        /*for (int i :arr){
            System.out.println("INLOOP: " + i);
        }*/

        int index = partition(arr, left, right);
        System.out.println("left: " + left + " right: " + right + " index: " + index );

        //if (left < index - 1){
            QuickSortParallel qs1 = new QuickSortParallel(array, left, index - 1);
            qs1.start();
       // }
       // if (index < right) {
            QuickSortParallel qs2 = new QuickSortParallel(array, index, right);
            qs2.start();

            try {
                qs1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                qs2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // }
        }

    }
}

