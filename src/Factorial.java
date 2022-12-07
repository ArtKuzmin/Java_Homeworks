//Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int trianglDigit = 0;
        int factorial = 1;
        if (sc.hasNextInt()) {
            n = sc.nextInt();
        } else {
            System.out.println("Неверный ввод");
        }

        for (int i = 1; i <= n; i++) {
            trianglDigit += i;
            factorial *= i;
        }
        System.out.printf("Сумма элементов от 1 до %d равна %d, фаториал числа %d равен %d", n, trianglDigit, n, factorial);

    }
}
