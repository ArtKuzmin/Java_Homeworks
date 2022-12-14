import java.util.ArrayList;

//Реализовать алгоритм сортировки слиянием
//Пусть дан произвольный список целых чисел, удалить из него четные числа
//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

public class HW_3 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int rand = (int) (Math.random() * 100);
            list.add(rand);
        }

        int max = list.get(0);
        int min = list.get(0);
        double average = 0;

        System.out.println("Список из рандомных чисел:");
        for (int a : list) {
            if (a > max)
                max = a;
            if (a < min)
                min = a;
            average += a;
            System.out.print(a + " ");
        }
        System.out.println();

        System.out.println("Отсортированный список из рандомных чисел:");
        mergeSort(list);
        for (int a : list) {
            System.out.print(a + " ");
        }
        System.out.println();

        average = average / list.size();
        System.out.printf("Минимальное значение списка равно %d, максимальное равно %d, среднее равно %.2f", min, max, average);
        System.out.println();

        System.out.println("Список из рандомных чисел без четных чисел:");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        for (int a : list) {
            System.out.print(a + " ");
        }
    }

    public static void mergeSort(ArrayList<Integer> list) {
        if (list.size() < 2) {
            return;
        }

        int mid = list.size() / 2;
        int rightLength = list.size() - mid;

        ArrayList<Integer> left = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            left.add(list.get(i));
        }
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = mid; i < list.size(); i++) {
            right.add(list.get(i));
        }

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right, mid, rightLength);
    }

    public static void merge(ArrayList<Integer> list, ArrayList<Integer> left, ArrayList<Integer> right, int mid, int rightLength) {

        int i = 0, j = 0, k = 0;
        while (i < mid && j < rightLength) {
            if (left.get(i) <= right.get(j)) {
                list.set(k, left.get(i));
                i++;
            } else {
                list.set(k, right.get(j));
                j++;
            }
            k++;
        }
        while (i < mid) {
            list.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < rightLength) {
            list.set(k, right.get(j));
            j++;
            k++;
        }
    }
}