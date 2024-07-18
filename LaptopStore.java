import java.util.*;

public class LaptopStore {
    private Set<Laptop> laptops = new HashSet<>();

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    public void filterLaptops() {
        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("0 - Завершить выбор критериев");

            int choice = scanner.nextInt();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.println("Введите минимальный объем ОЗУ:");
                    filters.put("ram", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Введите минимальный объем ЖД:");
                    filters.put("hddCapacity", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Введите операционную систему:");
                    filters.put("os", scanner.next());
                    break;
                case 4:
                    System.out.println("Введите цвет:");
                    filters.put("color", scanner.next());
                    break;
                default:
                    System.out.println("Некорректный выбор");
            }
        }

        Set<Laptop> filteredLaptops = new HashSet<>(laptops);
        for (Laptop laptop : laptops) {
            if (filters.containsKey("ram") && laptop.getRam() < (int) filters.get("ram")) {
                filteredLaptops.remove(laptop);
            }
            if (filters.containsKey("hddCapacity") && laptop.getHddCapacity() < (int) filters.get("hddCapacity")) {
                filteredLaptops.remove(laptop);
            }
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                filteredLaptops.remove(laptop);
            }
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String) filters.get("color"))) {
                filteredLaptops.remove(laptop);
            }
        }

        System.out.println("Отфильтрованные ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }

    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();

        // Добавляем несколько ноутбуков для примера
        store.addLaptop(new Laptop("Dell", 8, 512, "Windows", "Black"));
        store.addLaptop(new Laptop("Apple", 16, 256, "MacOS", "Silver"));
        store.addLaptop(new Laptop("Lenovo", 16, 1024, "Windows", "Gray"));
        store.addLaptop(new Laptop("Asus", 32, 1024, "Linux", "Black"));

        store.filterLaptops();
    }
}
