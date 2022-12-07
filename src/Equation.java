//Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
// например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
public class Equation {
    public static void main(String[] args) {
        String eq = "1? + ?5 = 29";
        String[] tempArr = eq.split("=");
        String[] tempArr2 = tempArr[0].split("\\+");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String t1 = tempArr2[0].replace("?", String.valueOf(i));
                String t2 = tempArr2[1].replace("?", String.valueOf(j));
                int arg1 = Integer.parseInt(t1.trim());
                int arg2 = Integer.parseInt(t2.trim());
                int arg3 = Integer.parseInt(tempArr[1].trim());
                if (arg1 + arg2 == arg3) System.out.println(arg1 + " + " + arg2 + " = " + arg3);
            }

        }

    }
}
