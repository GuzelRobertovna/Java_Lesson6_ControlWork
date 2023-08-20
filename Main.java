package ru.geekbrains.api.lesson6.hw.control;


import java.util.*;

public class Main {


    public static void main(String[] args) {
        Notebook notebook1 =  new Notebook("HUAWEI","MateBook D15", 16, 512, "Windows 11", "серый", 15.6, 59999);
        Notebook notebook2 =  new Notebook("ASUS","M1502IA", 16, 512, "не установлена", "серый", 15.6, 52999);
        Notebook notebook3 =  new Notebook("HONOR","MagicBook X14", 8, 256, "Windows 10", "серый", 14, 43999);
        Notebook notebook4 =  new Notebook("HUAWEI", "MateBook D15", 8, 512, "DOS", "серебристый", 15.6, 49999);
        Notebook notebook5 =  new Notebook("HONOR","MagicBook X16", 16, 512, "Windows 11 Home", "серый", 16, 78999);
        HashSet<Notebook> notebooks =new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5));

        Map<Integer, String> filters = new HashMap<>();
        
        filters.put(1, "manufacturer");
        filters.put(2, "model");
        filters.put(3, "ramValue");
        filters.put(4, "hddValue");
        filters.put(5,  "os");
        filters.put(6, "color");
        filters.put(7, "diagonal");
        filters.put(8, "price");

        Integer filterNumber = chooseFilter();

        getNotebookFilter(notebooks, filters, filterNumber);

//        getFilteredNotebooks(notebooks, filters);
    }



    /**
     * apiNote Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
     * @param notebooks множество ноутбуков
     * @param filters  критерии фмльтрации
     * @param filterNumber критерий фильтрации введенного пользователем
     */
    private static void getNotebookFilter(HashSet<Notebook> notebooks, Map<Integer, String> filters, Integer filterNumber) {
        Scanner scanner = new Scanner(System.in);
        if(filters.containsKey(filterNumber)) {
            switch (filterNumber) {
                case 1: {
                    System.out.println("Введите производителя: ");
                    String input = doFirstUpper(scanner.next());
                    System.out.println(input);
                    findFilter(notebooks, filters.get(1), input);
                    break;
                }
                case 2: {
                    System.out.println("Введите модель: ");
                    String input = doFirstUpper(scanner.next());
                    findFilter(notebooks, filters.get(2), input);
                    break;
                }
                case 3: {
                    System.out.println("Введите обьем оперативной памяти: ");
                    String input = doFirstUpper(scanner.next());
                    findFilter(notebooks, filters.get(3), input);
                    break;
                }
                case 4: {
                    System.out.println("Введите обьем жесткого диска: ");
                    String input = doFirstUpper(scanner.next());
                    findFilter(notebooks, filters.get(4), input);
                    break;
                }
                case 5: {
                    System.out.println("Введите операционную систему: ");
                    String input = doFirstUpper(scanner.next());
                    findFilter(notebooks, filters.get(5), input);
                    break;
                }
                case 6: {
                    System.out.println("Введите цвет: ");
                    String input = doFirstUpper(scanner.next());
                    findFilter(notebooks, filters.get(6), input);
                    break;
                }
                case 7: {
                    System.out.println("Введите диагональ экрана: ");
                    String input = doFirstUpper(scanner.next());
                    findFilter(notebooks, filters.get(7), input);
                    break;
                }
                case 8: {
                    System.out.println("Введите цену: ");
                    String input = doFirstUpper(scanner.next());
                    findFilter(notebooks, filters.get(8), input);
                    break;
                }
                default:
                    break;
            }
        }
        scanner.close();
    }

    public static Integer chooseFilter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите  критерий для поиска: ");
        System.out.println(
                "1 - производитель\n2 - модель\n3 - обьем оперативной памяти\n4 - объем ЖД\n5 - операционная система\n6 - цвет\n7-диагональ экрана\n8-цена");
        System.out.print("Ваш критерий: ");
        return scanner.nextInt();
    }

    public static String doFirstUpper(String word) {
        if (word == null || word.isEmpty())
            return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public static void findFilter(HashSet<Notebook> notebooks, String filter, String input) {
        Integer count = 0;
        Map<String, Notebook> result = new LinkedHashMap<>();
        for (Notebook notebook : notebooks) {
            if ((notebook.getInfo(filter)).contains(input.toUpperCase())) {
                count++;
                result.put(String.format("\n\nНоутбук № %d", count), notebook);

            }
        }
        if (result.isEmpty()) {
            System.out.println("Нет ноутбуков, удовлетворяющих критерию фильтрации");
        } else {
            System.out.println("Cписок подходящих ноутбуков:\n" + result);
        }
    }

//    private static void getFilteredNotebooks(HashSet<Notebook> notebooks, Map<Integer, String> filters) {
//        Map<String, Integer> filterParams = new HashMap<>();
//        Scanner scanner = new Scanner(System.in);
//
//        for (Map.Entry<Integer, String> entry : filters.entrySet()) {
//            System.out.println("Введите минимальное значение " + entry.getValue() + ":");
//            int value = scanner.nextInt();
//            filterParams.put(entry.getValue(), value);
//        }
//
//        Set<Notebook> filteredNotebooks = new HashSet<>();
//        boolean flag = false;
//        for (Notebook notebook : notebooks) {
//            if (notebook.getRamValue() >= filterParams.get("ramValue") ||
//                    notebook.getHddValue() >= filterParams.get("HddValue") ||
//                    notebook.getDiagonal() >= filterParams.get("Diagonal") ||
//                    notebook.getPrice() >= filterParams.get("Price")) {
//                filteredNotebooks.add(notebook);
//                flag = true;
//            }
//
//        }
//        if (flag) {
//            System.out.println("\n Отфильтрованные ноутбуки:");
//            for (Notebook elem : filteredNotebooks) {
//                System.out.println(elem);
//            }
//        }
//    }
}
