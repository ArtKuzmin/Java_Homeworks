import java.util.Scanner;
import java.io.*;

class Calculator {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("input.txt");
        Scanner sc = new Scanner(reader);

        FileWriter fw = new FileWriter("output.txt", false);
        while (sc.hasNextLine()) {
            String string = sc.nextLine();
            String[] str = string.split(" ");
            try {
                if (!isNumeric(str[0]) || !isNumeric(str[2])) {
                    fw.write(string + " = Error! Not number\n");
                    throw new Exception("Error! Not number");
                }
                if (!str[1].equals("+") && !str[1].equals("-") && !str[1].equals("*") && !str[1].equals("/")) {
                    fw.write(string + " = Operation Error!\n");
                    throw new Exception("Operation Error!");
                }
                if (str[1].equals("/") && str[2].equals("0")) {
                    fw.write(string + " = Error! Division by zero\n");
                    throw new Exception("Error! Division by zero");
                }
                if (str[1].equals("+")) {
                    System.out.println(string + " = " + addition(Double.parseDouble(str[0]), Double.parseDouble(str[2])));
                    fw.write(string + " = " + addition(Double.parseDouble(str[0]), Double.parseDouble(str[2])) + "\n");
                }
                if (str[1].equals("-")) {
                    System.out.println(string + " = " + extractor(Double.parseDouble(str[0]), Double.parseDouble(str[2])));
                    fw.write(string + " = " + extractor(Double.parseDouble(str[0]), Double.parseDouble(str[2])) + "\n");
                }
                if (str[1].equals("*")) {
                    System.out.println(string + " = " + multiplier(Double.parseDouble(str[0]), Double.parseDouble(str[2])));
                    fw.write(string + " = " + multiplier(Double.parseDouble(str[0]), Double.parseDouble(str[2])) + "\n");
                }
                if (str[1].equals("/")) {
                    System.out.println(string + " = " + divider(Double.parseDouble(str[0]), Double.parseDouble(str[2])));
                    fw.write(string + " = " + divider(Double.parseDouble(str[0]), Double.parseDouble(str[2])) + "\n");
                }
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

    static double addition(double a, double b) {
        return a + b;
    }

    static double extractor(double a, double b) {
        return a - b;
    }

    static double multiplier(double a, double b) {
        return a * b;
    }

    static double divider(double a, double b) {
        return a / b;
    }
}






