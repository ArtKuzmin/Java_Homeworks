import java.util.*;

//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
public class Checkmates {
    public static void main(String[] args) {
        String[][] field = new String[8][8];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = "0 ";
            }
        }
        solution(field);

        for (String[] strings : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }

    public static void solution(String[][] field) {
        Set<ArrayList<Integer>> set = moves();
        for (ArrayList<Integer> move : set) {
            if (check(field, move.get(0), move.get(1))) {
                field[move.get(0)][move.get(1)] = "X ";
            }
        }
    }

    public static boolean check(String[][] field, int r, int r2) {
        boolean isCheck = true;
        for (int i = 0; i < field.length; i++) {
            if (field[r][i].equals("X "))
                isCheck = false;
            if (field[i][r2].equals("X "))
                isCheck = false;
        }

        if (r < 6 && r2 < 6) {
            for (int i = r + 1; i < field.length; i++) {
                if (field[i][r2 + 1].equals("X "))
                    isCheck = false;
                if (r2 < 6)
                    r2++;
            }
        }
        if (r > 0 && r2 > 0) {
            for (int i = r; i >= 0; i--) {
                if (field[i][r2].equals("X "))
                    isCheck = false;
                if (r2 > 0)
                    r2--;
            }
        }
        if (r < 6 && r2 > 0) {
            for (int i = r; i < field.length; i++) {
                if (field[i][r2].equals("X "))
                    isCheck = false;
                if (r2 > 0)
                    r2--;
            }
        }
        if (r > 0 && r2 < 6) {
            for (int i = r; i >= 0; i--) {
                if (field[i][r2].equals("X "))
                    isCheck = false;
                if (r2 < 6)
                    r2++;
            }
        }
        return isCheck;
    }

    public static Set<ArrayList<Integer>> moves() {
        Set<ArrayList<Integer>> set = new HashSet<>();
        while (set.size() < 64) {
            ArrayList<Integer> rand = new ArrayList<>();
            int r = (int) (Math.random() * 8);
            int r2 = (int) (Math.random() * 8);
            rand.add(r);
            rand.add(r2);
            set.add(rand);
        }
        return set;
    }
}