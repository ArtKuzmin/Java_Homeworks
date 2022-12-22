//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
public class Checkmates {
    public static void main(String[] args) {
        String[][] field = new String[8][8];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = "0 ";
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        int queenCounter = 0;
        int counter = 0;
        while (queenCounter < 9) {
            int r = (int) (Math.random() * 8);
            int r2 = (int) (Math.random() * 8);
            if (check(field, r, r2)) {
                field[r][r2] = "Q ";
                queenCounter++;
                for (String[] strings : field) {
                    for (int j = 0; j < field.length; j++) {
                        System.out.print(strings[j]);
                    }
                    System.out.println();

                }
                System.out.println();
            }
            counter++;
            if (counter == 8)
                for (int i = 0; i < field.length; i++) {
                    for (int j = 0; j < field.length; j++) {
                        field[i][j] = "0 ";

                    }
                }
        }
    }

    public static boolean check(String[][] field, int r, int r2) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[r][j].equals("Q "))
                    return false;
                if (field[j][r2].equals("Q "))
                    return false;
            }
        }
        for (int i = r; i < field.length; i++) {
            for (int j = r2; j < field.length; j++) {
                if (field[i][i].equals("Q "))
                    return false;
                if (field[j][j].equals("Q "))
                    return false;
            }
        }
        for (int i = r; i >= 0; i--) {
            for (int j = r2; j >= 0; j--) {
                if (field[i][i].equals("Q "))
                    return false;
                if (field[j][j].equals("Q "))
                    return false;
            }
        }
        return true;
    }
}
