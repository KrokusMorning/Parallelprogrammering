import java.util.concurrent.*;

public class QuickSortParallel extends Thread {

    int[] array;
    int left;
    int right;

    QuickSortParallel(int[] array, String name, int left, int right) {
        super(name);
        this.array = array;
        this.left = left;
        this.right = right;
    }
    public void run(){
        quickSort(array, left, right);
        /*int index = partition(array, left, right);

        if (left < index - 1) {
            right = index - 1;
            //QuickSortParallel qs1 = new QuickSortParallel(array, "a", left, right);
            start();

        }
        if (index < right){
            left = index;
            //QuickSortParallel qs2 = new QuickSortParallel(array, "b", left, right);
            start();
        }*/
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
        int index = partition(arr, left, right);
        if (left < index - 1){
            right = index - 1;
            QuickSortParallel qs1 = new QuickSortParallel(array, "a", left, right);
            qs1.start();
            /*try {
                qs1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

        if (index < right) {
            left = index;
            QuickSortParallel qs2 = new QuickSortParallel(array, "b", left, right);
            qs2.start();
            /*try {
                qs2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

    }
}

