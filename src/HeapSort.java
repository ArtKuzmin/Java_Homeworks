import java.util.ArrayList;
import java.util.Arrays;

//Реализовать алгоритм пирамидальной сортировки (HeapSort).
//(Можно использовать массивы)
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int a : arr) {
            arrList.add(a);
        }
        System.out.println("Массив из рандомных чисел:");
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Сортированный массив из рандомных чисел:");
        System.out.println(Arrays.toString(arr));
        System.out.println("ArrayList из рандомных чисел:");
        for (int a : arrList) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("Сортированный ArrayList из рандомных чисел:");
        heapSortList(arrList);
        for (int a : arrList) {
            System.out.print(a + " ");
        }
    }

    public static void heapSortList(ArrayList<Integer> arrList) {
        for (int i = arrList.size() / 2 - 1; i >= 0; i--) {
            heapifyList(arrList, arrList.size(), i);
        }
        for (int i = arrList.size() - 1; i >= 0; i--) {
            int temp = arrList.get(0);
            arrList.set(0, arrList.get(i));
            arrList.set(i, temp);
            heapifyList(arrList, i, 0);
        }
    }

    static void heapifyList(ArrayList<Integer> arrList, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arrList.get(left) > arrList.get(max))
            max = left;
        if (right < n && arrList.get(right) > arrList.get(max))
            max = right;
        if (max != i) {
            int temp = arrList.get(i);
            arrList.set(i, arrList.get(max));
            arrList.set(max, temp);

            heapifyList(arrList, n, max);
        }
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[max])
            max = left;
        if (right < n && arr[right] > arr[max])
            max = right;
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, n, max);
        }
    }
}
