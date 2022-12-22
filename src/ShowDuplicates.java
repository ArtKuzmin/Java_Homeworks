import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
public class ShowDuplicates {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("list.txt");
        Map<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            String[] str = name.split(" ");
            if (!map.containsKey(str[0]))
                map.put(str[0], 0);
            else map.put(str[0], map.get(str[0]) + 1);
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (int i = 0; i < map.size(); i++) {
            for (Map.Entry<String, Integer> a : entries) {
                if (a.getValue() == i)
                    System.out.println(a.getKey() + ": " + a.getValue().toString().replaceAll("\\[", "").replaceAll("\\]", ""));
            }
        }
    }
}
