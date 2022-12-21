import java.util.*;

// Реализуйте структуру телефонной книги с помощью HashMap,
// учитывая, что 1 человек может иметь несколько телефонов.
public class PhoneBook {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String name = "";
        String string = "";
        System.out.println("Введите имя, фамилию и номера телефонов пользователя через пробел, 'stop' для завершения программы");
        while (!string.equals("stop")) {
            string = sc.nextLine();
            if (!string.equals("stop")) {
                String[] str = string.split(" ");
                for (int i = 0; i < str.length; i++) {
                    if (i < 2) {
                        name += str[i] + " "; //т.к. всегда будет конкатенироваться только две стринги, то СтрингБилдер использовать не стал
                    } else numbers.add(Integer.parseInt(str[i]));
                }
                name = name.strip();
                phoneBook.put(name, numbers);
                Set<Map.Entry<String, ArrayList<Integer>>> entries = phoneBook.entrySet();
                for (Map.Entry<String, ArrayList<Integer>> a : entries) {
                    System.out.println(a.getKey() + ": " + a.getValue().toString().replaceAll("\\[", "").replaceAll("\\]", ""));
                }
                name = "";
                numbers.clear();
            }
        }
    }
}
