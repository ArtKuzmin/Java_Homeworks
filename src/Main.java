import java.util.*;

public class Main {
    public static void main(String[] args)  {
        Set<Notebook> notebooks = new HashSet<>();
        Notebook macbook = new Notebook(8, 256, "MacOS", "Grey", false, 13.6, "Retina", "Apple", "Apple");
        Notebook asus = new Notebook(16, 512, "Windows 11", "White", false, 15.6, "IPS", "Intel", "ASUS");
        Notebook acer = new Notebook(4, 256, "Windows 7", "Black", false, 17.6, "TN", "AMD", "ACER");
        Notebook lenovo = new Notebook(8, 2048, "Windows 10", "White", true, 13.6, "IPS", "AMD", "Lenovo");
        Notebook msi = new Notebook(32, 1024, "Windows 10", "White", true, 15.6, "OLED", "Intel", "MSI");
        Notebook huawei = new Notebook(16, 512, "Windows 11", "Grey", false, 16, "IPS", "AMD", "Huawei");
        Notebook huawei2 = new Notebook(8, 1024, "Windows 11", "Grey", false, 13, "OLED", "AMD", "Huawei");
        Notebook huawei3 = new Notebook(8, 1024, "Windows 11", "Grey", false, 16, "OLED", "AMD", "Huawei");
        notebooks.add(macbook);
        notebooks.add(asus);
        notebooks.add(acer);
        notebooks.add(lenovo);
        notebooks.add(msi);
        notebooks.add(huawei);
        notebooks.add(huawei2);
        notebooks.add(huawei3);
        System.out.println("В наличии ес ть следующие ноутбуки:");
        for (Notebook a : notebooks) {
            System.out.println(a);
        }
        System.out.println();
        Store store = new Store();
        Map<String, String> temp = store.menu();
        Set<Notebook> sortedNotebooks = store.sort(notebooks, temp);
        System.out.println("Под ваши запросы подходят следующие модели ноутбуков:");
        for (Notebook a : sortedNotebooks) {
            System.out.println(a);
        }
    }
}
