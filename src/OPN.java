import java.util.*;

//Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
public class OPN {
    public static void main(String[] args) {
        ArrayList<String> postfix;
        ArrayList<String> result;
//        Вариант для ввода инфиксной записи пользователем:
//        System.out.println("Введите инфиксную запись с каждым символом через пробел:");
//        Scanner sc = new Scanner(System.in);
//        String infix = sc.nextLine();
        String infix = "4 ^ 2 / 2 * (2 + 10)";
        System.out.println("Infix: " + infix);
        System.out.println("Reference Postfix: 4 2 ^ 2 / 2 10 + *"); //для сравнения
        postfix = toPostfix(infix);
        System.out.print("Postfix: ");
        for (String ch : postfix) {
            System.out.print(ch + " ");
        }
        System.out.println();
        result = solvePostfix(postfix);
        System.out.print("Решение: " + result.get(0));
        System.out.println();
        System.out.println();

        String infix2 = "4 - 2 + 2 * (2 + 1)";
        System.out.println("Infix 2: " + infix2);
        System.out.println("Reference Postfix 2: 4 2 - 2 2 1 + * +");
        postfix = toPostfix(infix2);
        System.out.print("Postfix 2: ");
        for (String ch : postfix) {
            System.out.print(ch + " ");
        }
        result = solvePostfix(postfix);
        System.out.println();
        System.out.print("Решение: " + result.get(0));
    }

    // Вычисляем приоритет знака для вычислений
    public static boolean priority(String a, String b) {
        boolean highA = a.equals("*") || a.equals("/");
        boolean highB = b.equals("*") || b.equals("/");
        boolean lowA = a.equals("+") || a.equals("-");
        boolean lowB = b.equals("+") || b.equals("-");

        if (a.equals("^") && !b.equals("^"))
            return true;
        else if (a.equals(b))
            return false;
        else if (highA && (!b.equals("^") && !highB))
            return true;
        else if ((lowA) && highB)
            return false;
        else if (highA && highB)
            return false;
        else if ((lowA) && lowB)
            return false;
        else return false;
    }

    public static ArrayList<String> toPostfix(String inf) {
        inf = inf.replace("(", "( ").replace(")", " )");
        ArrayList<String> postfix = new ArrayList<>();
        String operators = "+-/*^";
        String[] post = inf.split(" ");
        Deque<String> stack = new LinkedList<>();
        for (String s : post) {
            if (!operators.contains(s) && !s.equals("(") && !s.equals(")")) {
                postfix.add(s);
            } else if (operators.contains(s) && stack.size() == 0) {
                stack.add(s);
            } else if (operators.contains(s)) {
                if (!stack.contains("(")) {
                    assert stack.peekFirst() != null;
                    if (!priority(s, stack.peekFirst())) {
                        postfix.add(stack.pollFirst());
                    }
                }
                stack.add(s);
            } else if (s.equals("(")) {
                stack.add(s);
            } else if (s.equals(")")) {
                for (int j = stack.size() - 1; j >= 0; j--) {
                    assert stack.peekLast() != null;
                    if (!stack.peekLast().equals("("))
                        postfix.add(stack.pollLast());
                    else stack.pollLast();
                }
            }
        }
        return postfix;
    }

    public static ArrayList<String> solvePostfix(ArrayList<String> postfix) {
        String operators = "+-/*^";
        if (postfix.size() < 3) {
            return postfix;
        } else {
            for (int i = 2; i < postfix.size() ; i++) {

                if (operators.contains(postfix.get(i))) {
                    switch (postfix.get(i)) {
                        case "+" ->
                                postfix.set(i, String.valueOf(Double.parseDouble(postfix.get(i - 2)) + Double.parseDouble(postfix.get(i - 1))));
                        case "-" ->
                                postfix.set(i, String.valueOf(Double.parseDouble(postfix.get(i - 2)) - Double.parseDouble(postfix.get(i - 1))));
                        case "*" ->
                                postfix.set(i, String.valueOf(Double.parseDouble(postfix.get(i - 2)) * Double.parseDouble(postfix.get(i - 1))));
                        case "/" ->
                                postfix.set(i, String.valueOf(Double.parseDouble(postfix.get(i - 2)) / Double.parseDouble(postfix.get(i - 1))));
                        case "^" ->
                                postfix.set(i, String.valueOf(Math.pow(Double.parseDouble(postfix.get(i - 2)), Double.parseDouble(postfix.get(i - 1)))));
                    }
                    postfix.remove(i - 1);
                    postfix.remove(i - 2);
                }
            }
            solvePostfix(postfix);
            return postfix;
        }
    }
}