import java.util.Scanner;
import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class Calculator {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("input.txt");
        Scanner sc = new Scanner(reader);
        FileWriter fw = new FileWriter("output.txt", false);
        Logger logger = Logger.getLogger(DigitArray.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("calc_log.txt");
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        while (sc.hasNextLine()) {
            String string = sc.nextLine();
            String[] str = string.split(" ");
            try {
                if (!isNumeric(str[0]) || !isNumeric(str[2])) {
                    fw.write(string + " = Error! Not number\n");
                    logger.log(Level.INFO, string + " = Error! Not number\n");
                    throw new Exception("Error! Not number");
                }
                if (!str[1].equals("+") && !str[1].equals("-") && !str[1].equals("*") && !str[1].equals("/")) {
                    fw.write(string + " = Operation Error!\n");
                    logger.log(Level.INFO, string + " = Operation Error!\n");
                    throw new Exception("Operation Error!");
                }
                if (str[1].equals("/") && str[2].equals("0")) {
                    fw.write(string + " = Error! Division by zero\n");
                    logger.log(Level.INFO, string + " = Error! Division by zero\n");
                    throw new Exception("Error! Division by zero");
                }
                System.out.println(string + " = " + calc(string));
                fw.write(string + " = " + calc(string) + "\n");
                logger.log(Level.INFO, string + " = " + calc(string) + "\n");
            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }
        fw.close();
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





