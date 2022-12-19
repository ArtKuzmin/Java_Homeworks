import java.util.Collections;
import java.util.LinkedList;

//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
public class ReverseList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
        System.out.println("LinkedList:");
        for (int item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("Reversed LinkedList:");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("Reversed LinkedList by built-in method:");
        Collections.reverse(list);
        for (int item : list) {
            System.out.print(item + " ");
        }
    }
}
