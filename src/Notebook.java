import java.util.Objects;

//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//Создать множество ноутбуков.
//Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
// отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
//“Введите цифру, соответствующую необходимому критерию:
//1 - ОЗУ
//2 - Объем ЖД
//3 - Операционная система
//4 - Цвет …
//Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также
// в Map.
//Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
public class Notebook {
    int ramCapacity;
    int storageCapacity;
    String os;
    String color;
    boolean isGraphicCard;
    double displaySize;
    String displayType;
    String cpuVendor;
    String vendor;

    public Notebook() {

    }

    public Notebook(int ramCapacity, int storageCapacity, String os, String color, boolean isGraphicCard, double displaySize, String displayType, String cpuVendor, String vendor) {
        this.ramCapacity = ramCapacity;
        this.storageCapacity = storageCapacity;
        this.os = os;
        this.color = color;
        this.isGraphicCard = isGraphicCard;
        this.displaySize = displaySize;
        this.displayType = displayType;
        this.cpuVendor = cpuVendor;
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return vendor + ": " +
                "RAM Capacity = " + ramCapacity +
                ", Storage Capacity = " + storageCapacity +
                ", OS = '" + os + '\'' +
                ", Color = '" + color + '\'' +
                ", isGraphicCard = " + isGraphicCard +
                ", Display Size = " + displaySize +
                ", Display Type = '" + displayType + '\'' +
                ", CPU Vendor = '" + cpuVendor + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Notebook notebook) {
            if (notebook.hashCode() != this.hashCode()) {
                return false;
            }
            if (this.displaySize == notebook.displaySize && this.vendor.equals(notebook.vendor))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(displaySize, vendor);
    }
}
