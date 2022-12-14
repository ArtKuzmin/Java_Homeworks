import java.util.Arrays;

//Реализовать алгоритм сортировки слиянием
//Пусть дан произвольный список целых чисел, удалить из него четные числа
//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
public class HW_3 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 4, 16, 91, 2, 12, 5, 48, 3, 22, 4, 32, 5,};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] a) {
        if (a.length < 2) {
            return;
        }
        int mid = a.length / 2;
        int rightLength = a.length - mid;
        int[] left = new int[mid];
        int[] right = new int[a.length - mid];

        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, right, 0, a.length - mid);
        mergeSort(left);
        mergeSort(right);

        merge(a, left, right, mid, rightLength);
    }

    public static void merge(int[] a, int[] left, int[] right, int mid, int rightLength) {

        int i = 0, j = 0, k = 0;
        while (i < mid && j < rightLength) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }
        while (i < mid) {
            a[k++] = left[i++];
        }
        while (j < rightLength) {
            a[k++] = right[j++];
        }
    }
}