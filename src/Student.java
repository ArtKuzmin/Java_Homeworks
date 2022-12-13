import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
//Дана json строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.
public class Student {
    public static void main(String[] args) throws IOException {
        String request = new String(Files.readAllBytes(Paths.get("student.json")));
        request = request.replace("фамилия", "").replace("оценка", "").replace("предмет", "").replace("\"", "").replace("{", "").replace(",", "");
        String s = "";
        StringBuilder sb = new StringBuilder(s);
        String[] arr = request.split("}");
        ArrayList<String[]> arrayList = new ArrayList<>();
        for (String value : arr)
            arrayList.add(value.split(":"));
        for (String[] value : arrayList) {
            if (value.length > 1)
                sb.append("Студент ").append(value[1]).append(" получил ").append(value[2]).append(" по предмету ").append(value[3]).append("\n");
        }
        System.out.println(sb);
    }
}