import java.util.concurrent.*;

public class QuickSortParallel extends Thread {

    int[] array;
    int l;
    int r;
    public static int threadcount = 1;
    int processors = Runtime.getRuntime().availableProcessors();


    QuickSortParallel(int[] array, int left, int right) {
        this.array = array;
        this.l = left;
        this.r = right;
    }
    public void run(){
        quickSortP(array, l, r);
    }

    void quickSortS(int arr[], int left, int right) {
            int index = partition(arr, left, right);
            if (left < index - 1)
                quickSortS(arr, left, index - 1);
            if (index < right)
                quickSortS(arr, index, right);
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

    void quickSortP(int arr[], int left, int right) {
        if (threadcount < processors){
            int index = partition(arr, left, right);
            System.out.println("Thread name " + getName());
            System.out.println("left: " + left + " right: " + right + " index: " + index );
            System.out.println("Thread count " + threadcount);

            if (left < index - 1){
                threadcount++;
                QuickSortParallel qs1 = new QuickSortParallel(array, left, index - 1);
                qs1.start();
                try {
                    qs1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (index < right){
                threadcount++;
                QuickSortParallel qs2 = new QuickSortParallel(array, index, right);
                qs2.start();
                try {
                    qs2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                if (left < index - 1)
                    quickSortS(arr, left, index - 1);
                if (index < right)
                    quickSortS(arr, index, right);
            }
            }

        }
    }

