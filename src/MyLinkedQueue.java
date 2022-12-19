import java.util.ArrayList;
import java.util.LinkedList;

//Реализуйте очередь с помощью LinkedList со следующими методами:
//enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
//Здесь так же нужно создать класс, который будет реализовывать указанные методы)
public class MyLinkedQueue{
    LinkedList<Integer> list;

    public MyLinkedQueue() {
        list = new LinkedList<>();
    }

    public MyLinkedQueue(ArrayList<Integer> arr) {
        list = new LinkedList<>(arr);
    }

    public void enqueue(int element) {
        list.add(element);
    }

    public int dequeue() {
        int item = list.get(0);
        list.remove(0);
        return item;
    }

    public int first() {
        return list.get(0);
    }
//Добавил метод вывода для своего списка, так как со своим итератором я еще не разобрался
    public void printQueue() {
        for (int item : list) {
            System.out.print(item + " ");
        }
    }


}
