//Вывести все простые числа от 1 до 1000
public class Simple1000 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            int counter = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) counter++;
                if (counter > 1) break;
            }
            if (counter == 1) System.out.print(i + " ");
        }
    }
}
