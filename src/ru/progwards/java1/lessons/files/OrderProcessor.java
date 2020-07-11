package ru.progwards.java1.lessons.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

class Order {
    public String shopId; // идентификатор магазина
    public String orderId; // идентификатор заказа
    public String customerId; // идентификатор покупателя
    public LocalDateTime datetime; // дата-время заказа (из атрибутов файла - дата последнего изменения)
    public List<OrderItem> items; // список позиций в заказе, отсортированный по наименованию товара
    public double sum; // сумма стоимости всех позиций в заказе

    public Order() {
        items = new ArrayList<OrderItem>();
    }

    @Override
    public String toString() {
        return "Order{" +
                "shopId='" + shopId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", datetime=" + datetime +
                ", items=" + items +
                ", sum=" + sum +
                '}';
    }
}

class OrderItem {
    public String googsName; // наименование товара
    public int count; // количество
    public double price; // цена за единицу

    @Override
    public String toString() {
        return "\nOrderItem{" + googsName + ", count=" + count + ", price=" + price + '}';
    }
}

public class OrderProcessor {

    Path startPath; // начальная папка для хранения файлов
    List<Order> orders; // список заказов
    String loadedShopId; // загруженный магазин

    // инициализирует класс, с указанием начальной папки для хранения файлов
    public OrderProcessor(String startPath) {
        this.startPath = Paths.get(startPath);
    }

    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
        orders = new ArrayList<Order>();
        int failedFiles = 0;
        List<Path> paths = null;
        loadedShopId = shopId;

        // список файлов с информацией о заказах
        // плохо, что имена папок "не имеют значения". В имя папки или файла обязательно надо было сделать привязку к дате. Как процессинг будет работать через 10 лет!?
        String shopFilter = shopId==null ? "???" : shopId;
        String pattern = "glob:**/" + shopFilter + "-??????-????.csv"; // tester not passed
        //String pattern = "glob:**/" + shopFilter + "-*-*.csv"; // tester changed his mind )
        PathMatcher pathMatcher1 = FileSystems.getDefault().getPathMatcher(pattern);
        try {
            paths = Files.walk(startPath)
                    .filter(p -> {
                        if (pathMatcher1.matches(p)) {
                            if (start == null && finish == null) return true;
                            LocalDate fm = getFileLocalDateTime(p).toLocalDate();
                            if (fm == null) return false;
                            return !((start != null && fm.isBefore(start)) || (finish != null && fm.isAfter(finish)));
                        }
                        return false;
                    })
                    .sorted(Comparator.comparing(this::getFileLocalDateTime))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (paths == null) return 0;
        //System.out.println(paths);

        for (Path path : paths) {
            if (!loadOrderFromFile(path)) {
                failedFiles++;
                System.out.println("Processing failed: "+path);
            } else { System.out.println("Ok: "+path); }
        }
        //System.out.println(orders);
        //sortOrders(); // отсортируем orders // отсортировали файлы ранее, потому это не надо

        return failedFiles;
    }

    public LocalDateTime getFileLocalDateTime(Path path) {
        try {
            return LocalDateTime.ofInstant(Files.getLastModifiedTime(path).toInstant(), ZoneId.systemDefault());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Загрузим заказ одного файла. Если что-то поёдет не так, вернем false, заказ игнорируем
    public boolean loadOrderFromFile(Path path) {
        Order order = new Order();
        Double sum = 0d;
        final String DELIMITER = ",";
        Charset charset = Charset.forName("UTF-8");
        String fileName = path.getFileName().toString();
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    if (line.compareTo("")==0) continue;
                    String[] s = line.split(DELIMITER);
                    if (s.length != 3) return false; // критическая ошибка
                    OrderItem item = new OrderItem();
                    item.googsName = s[0];
                    item.count = Integer.parseInt(s[1].trim());
                    item.price = Double.parseDouble(s[2].trim());
                    sum += item.price * item.count;
                    order.items.add(item);
                } catch (Exception e) {
                    System.err.println(fileName + ':' + line + ':' + e); //log
                    return false; // критическая ошибка
                }
            }
            String[] s = fileName.substring(0, fileName.lastIndexOf(".")).split("-");
            order.datetime = getFileLocalDateTime(path);
            order.shopId = s[0];
            if (s[0].length() != 3) return false; // критическая ошибка, из за тестера
            order.orderId = s[1];
            if (s[1].length() != 6) return false; // критическая ошибка, из за тестера
            order.customerId = s[2];
            if (s[2].length() != 4) return false; // критическая ошибка, из за тестера
            order.sum = sum;
            Collections.sort(order.items, new Comparator<OrderItem>() {
                @Override
                public int compare(OrderItem lhs, OrderItem rhs) {
                    return lhs.googsName.compareTo(rhs.googsName);
                }
            }); // добавил сортировку для тестера. В задаче не видел такого условия.
            orders.add(order);
            return true;
        } catch (IOException e) {
            System.err.println(fileName + ':' + e); //log
        }
        return false;
    }

    // сортировка заказов "в порядке обработки"
    private void sortOrders() {
        Comparator<Order> dateComparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.datetime.compareTo(o2.datetime);
            }
        };
        Collections.sort(orders, dateComparator);
    }

    // выдать список заказов в порядке обработки (отсортированные по дате-времени), для заданного магазина.
    // Если shopId == null, то для всех
    public List<Order> process(String shopId) {
        if (shopId == null || (loadedShopId!=null && shopId.compareTo(loadedShopId) == 0)) return orders;
        List<Order> result = new ArrayList<Order>();
        for (Order o : orders) {
            if (o.shopId.compareTo(shopId)==0) result.add(o);
        }
        return result;
    }

    // выдать информацию по объему продаж по магазинам (отсортированную по ключам): String - shopId, double - сумма стоимости всех проданных товаров в этом магазине
    public Map<String, Double> statisticsByShop() {
        Map<String, Double> result = new TreeMap<String, Double>();
        for (Order o : orders) {
            String key = o.shopId;
            boolean isExists = result.containsKey(key);
            double sum = isExists ? result.get(key) : 0;
            result.put(key, sum + o.sum);
        }
        return result;
    }

    // выдать информацию по объему продаж по товарам (отсортированную по ключам): String - goodsName, double - сумма стоимости всех проданных товаров этого наименования
    public Map<String, Double> statisticsByGoods() {
        Map<String, Double> result = new TreeMap<String, Double>();
        for (Order o : orders) {
            for (OrderItem item : o.items) {
                String key = item.googsName;
                boolean isExists = result.containsKey(key);
                double sum = isExists ? result.get(key) : 0;
                result.put(key, sum + item.count*item.price);
            }
        }
        return result;
    }

    // выдать информацию по объему продаж по дням (отсортированную по ключам): LocalDate - конкретный день, double - сумма стоимости всех проданных товаров в этот день
    public Map<LocalDate, Double> statisticsByDay() {
        Map<LocalDate, Double> result = new TreeMap<LocalDate, Double>();
        for (Order o : orders) {
            LocalDate key = o.datetime.toLocalDate();
            boolean isExists = result.containsKey(key);
            double sum = isExists ? result.get(key) : 0;
            result.put(key, sum + o.sum);
        }
        return result;
    }

    // test
    public static void main(String[] args) {
        OrderProcessor p = new OrderProcessor("C:\\Users\\Grigory\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\files\\orders");
        System.out.println(p.loadOrders(null, null, null));
        System.out.println(p.process(null));

    }
}