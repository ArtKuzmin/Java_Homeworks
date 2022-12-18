import java.util.*;

//Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
public class OPN {

    public static void main(String[] args) {
//        String infix = "4 ^ 2 / 2 * (2 + 10)";
//        System.out.println("Infix: " + infix);
//        System.out.println("Postfix: 4 2 ^ 2 / 2 10 + *"); //для сравнения
        ArrayList<String> postfix;// = toPostfix(infix);

        String infix2 = "4 - 2 + 2 * (2 + 1)";
        System.out.println("Infix2: " + infix2);
        System.out.println("Postfix2: 4 2 - 2 2 1 + * +");
        postfix = toPostfix(infix2);
        System.out.print("Postfix: ");
        for (String ch : postfix) {
            System.out.print(ch + " ");
        }
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
                if (!stack.contains("(") && priority(s, stack.peek())) {
                    postfix.add(stack.pollFirst());
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

    public static boolean priority(String a, String b) {
        if (a.equals("^"))
            return true;
        else if (a.equals("*") || a.equals("/") && !b.equals("^"))
            return true;
        else if(a.equals(b)) return true;
        else if ((a.equals("+") | a.equals("-")) && (b.equals("*") | b.equals("/")))
            return true;
        else return false;
    }

}
