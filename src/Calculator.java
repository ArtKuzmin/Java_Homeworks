// В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger(Calculator.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("calc_log.txt");
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);

        String string;
        boolean isEnd = true;
        ArrayList<String> history = new ArrayList<>();
        System.out.println("Введите выражение с разделителем пробелом, 'undo' для возвращения предыдущего значения, 'stop' для завершения программы");

        while (isEnd) {
            string = sc.nextLine();
            String[] str = string.split(" ");
            if (!string.equals("undo"))
                history.add(string);
            switch (string) {
                case "undo" -> {
                    System.out.println(history.get(history.size() - 2) + " = " + calc(history.get(history.size() - 2)));
                    logger.log(Level.INFO, "(udo) " + history.get(history.size() - 2) + " = " + calc(history.get(history.size() - 2)) + "\n");
                }
                case "stop" -> isEnd = false;
                default -> {
                    if (!isNumeric(str[0]) || !isNumeric(str[2])) {
                        logger.log(Level.SEVERE, string + " = Error! Not number\n");
                        continue;
                    }
                    if (!str[1].equals("+") && !str[1].equals("-") && !str[1].equals("*") && !str[1].equals("/")) {
                        logger.log(Level.SEVERE, string + " = Operation Error!\n");
                        continue;
                    }
                    if (str[1].equals("/") && str[2].equals("0")) {
                        logger.log(Level.SEVERE, string + " = Error! Division by zero\n");
                        continue;
                    }
                    System.out.println(string + " = " + calc(string));
                    logger.log(Level.INFO, string + " = " + calc(string) + "\n");
                }
            }
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static double calc(String exp) {
        String[] str = exp.split(" ");
        return switch (str[1]) {
            case "+" -> Double.parseDouble(str[0]) + Double.parseDouble(str[2]);
            case "-" -> Double.parseDouble(str[0]) - Double.parseDouble(str[2]);
            case "*" -> Double.parseDouble(str[0]) * Double.parseDouble(str[2]);
            case "/" -> Double.parseDouble(str[0]) / Double.parseDouble(str[2]);
            default -> 0;
        };
    }
}