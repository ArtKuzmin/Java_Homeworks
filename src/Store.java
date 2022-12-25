import java.util.*;

public class Store {
    public Set<Notebook> sort(Set<Notebook> notebooks, Map<String, String> sort) {
        Set<Notebook> sortedNotebooks = new HashSet<>();
        Set<Map.Entry<String, String>> entries = sort.entrySet();
        for (Map.Entry<String, String> a : entries) {
            for (Notebook item : notebooks) {
                switch (a.getKey()) {
                    case ("ramCapacity") -> {
                        if (item.ramCapacity >= Integer.parseInt(a.getValue()))
                            sortedNotebooks.add(item);
                    }
                    case ("storageCapacity") -> {
                        if (item.storageCapacity >= Integer.parseInt(a.getValue()))
                            sortedNotebooks.add(item);
                    }
                    case ("os") -> {
                        if (item.os.equals(a.getValue()))
                            sortedNotebooks.add(item);
                    }
                    case ("color") -> {
                        if (item.color.equals(a.getValue()))
                            sortedNotebooks.add(item);
                    }
                    case ("isGraphicCard") -> {
                        if (Boolean.parseBoolean(a.getValue()))
                            sortedNotebooks.add(item);
                    }
                    case ("displaySize") -> {
                        if (item.displaySize >= Double.parseDouble(a.getValue()))
                            sortedNotebooks.add(item);
                    }
                    case ("displayType") -> {
                        if (item.displayType.equals(a.getValue()))
                            sortedNotebooks.add(item);
                    }
                    case ("cpuVendor") -> {
                        if (item.cpuVendor.equals(a.getValue()))
                            sortedNotebooks.add(item);
                    }
                    case ("vendor") -> {
                        if (item.vendor.equals(a.getValue()))
                            sortedNotebooks.add(item);
                    }
                }
            }
        }
        return sortedNotebooks;
    }


    public Map<String, String> menu() {
        boolean stop = true;
        Map<Integer, String> menu = new LinkedHashMap<>();
        Map<String, String> sort = new TreeMap<>();
        menu.put(1, "RAM Capacity");
        menu.put(2, "Storage Capacity");
        menu.put(3, "OS");
        menu.put(4, "Color");
        menu.put(5, "With or without graphic card");
        menu.put(6, "Display Size");
        menu.put(7, "Display Type");
        menu.put(8, "CPU Vendor");
        menu.put(9, "Vendor");
        menu.put(0, "stop");
        Scanner sc = new Scanner(System.in);
        System.out.println("По какоу параметру вы хотите выбрать ноутбук?");

        while (stop) {
            System.out.println(menu);
           String input = sc.nextLine();
            if (input.equals("0")) stop = false;
            switch (input) {
                case ("1") -> {
                    System.out.println("Введите значение параметра");
                    input = sc.nextLine();
                    sort.put("ramCapacity", input);
                }
                case ("2") -> {
                    System.out.println("Введите значение параметра");
                    input = sc.nextLine();
                    sort.put("storageCapacity", input);
                }
                case ("3") -> {
                    System.out.println("Введите значение параметра");
                    input = sc.nextLine();
                    sort.put("os", input);
                }
                case ("4") -> {
                    System.out.println("Введите значение параметра");
                    input = sc.nextLine();
                    sort.put("color", input);
                }
                case ("5") -> {
                    System.out.println("Введите значение параметра");
                    input = sc.nextLine();
                    sort.put("isGraphicCard", input);
                }
                case ("6") -> {
                    System.out.println("Введите значение параметра");
                    input = sc.nextLine();
                    sort.put("displaySize", input);
                }
                case ("7") -> {
                    System.out.println("Введите значение параметра");
                    input = sc.nextLine();
                    sort.put("displayType", input);
                }
                case ("8") -> {
                    System.out.println("Введите значение параметра");
                    input = sc.nextLine();
                    sort.put("cpuVendor", input);
                }
                case ("9") -> {
                    System.out.println("Введите значение параметра");
                    input = sc.nextLine();
                    sort.put("vendor", input);
                }
            }
        }
        return sort;
    }
}
