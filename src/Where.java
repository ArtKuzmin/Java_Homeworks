import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки. Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class Where {
    public static void main(String[] args) throws IOException {
        String request = new String(Files.readAllBytes(Paths.get("file.json"))).replace("\"", "").replace("{", "").replace("}", "");
        String s = "select * from students where";
        StringBuilder sb = new StringBuilder(s);
        String[] arr = request.split(",");
        ArrayList<String[]> arrayList = new ArrayList<>();
        for (String value : arr) arrayList.add(value.split(":"));
        for (int i = 0; i < arrayList.size(); i++) {
            if (!arrayList.get(i)[1].equals("null"))
                sb.append(" ").append(arrayList.get(i)[0]).append(" = ").append("\"").append(arrayList.get(i)[1]).append("\"");
            if (i < arrayList.size() - 2)
                sb.append(" and");
        }
        String str = sb.toString();
        str = str.replace("  ", " "); // Так и не понял, почему после цепочки аппендов в 28 строке после
        System.out.println(str);                          //and поялвлялся лишний пробел. Потому перевел в стрингу обратно, т.к. тут удобный метод реплейс
    }
}
