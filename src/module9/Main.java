package module9;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by g.zubenko on 10.01.2017.
 */
public class Main {
    static private final String[] NAMES = {"Mary", "John", "Mark", "Paul", "Emily", "Alice", "Anna", "Harry", "Oliver"};
    static private final String[] SURNAMES = {"Green", "Black", "White", "Brown", "Gray", "Wood", "Parker"};
    static private final String[] CITIES = {"Kiev", "Kharkov", "Zaporozhye"};//, "Poltava", "Lvov"};
    static private final String[] ITEM_NAMES = {"headphones", "blender", "mobile phone", "microwave", "TV set", "fridge"};
    static private final String[] SHOP_IDENTIFICATORS = {"technoMall", "foxtrot"};//, "Comfy"};
    static private Random random = new Random();

    public static void main(String[] args) {

        printTaskHeader("create Main class where you create 10 Orders with 10 Users and put it to the List");
        final int numberOfUsers = 10;
        List<User> users = createUsers(numberOfUsers);
        users.sort(User.getByNameComparator());
        System.out.println();

        printCollection("List of users", users);

        final int numberOfOrders = 10;
        List<Order> orders = createOrders(users, numberOfOrders);
        Set<Order> setOfOrders = new HashSet<>(orders); // for task3
        printCollection("Initial list of orders", orders);

        printTaskHeader("sort list by order price in decrease order");
        orders.sort(Order.getByPriceComparator());
        printCollection("Orders sorted by price", orders);

        printTaskHeader("sort list by order price in increase order and user city");
        orders.sort(Order.getByPriceAndCityComparator());
        printCollection("Orders sorted by city and price", orders);

        printTaskHeader("sort list by order itemName, orderIdentificator and user city");
        orders.sort(Order.getByItemAndOrderAndCityComparator());
        printCollection("Orders sorted by city, item and id", orders);


        printTaskHeader("delete duplicates from the list");
        orders = orders.stream().distinct().collect(Collectors.toList());
        printCollection("Orders without duplicates", orders);

        printTaskHeader("delete items where price less than 1500");
        orders.removeIf((Order o) -> o.getPrice() < 1500);
        printCollection("Orders with price >1500", orders);

        printTaskHeader("separate list for two list - orders in USD and UAH");
        List<Order> ordersUsd = orders.stream().filter((Order o) -> o.getCurrency() == Currency.USD).collect(Collectors.toList());
        List<Order> ordersEur = orders.stream().filter((Order o) -> o.getCurrency() == Currency.EUR).collect(Collectors.toList());
        printCollection("Orders with currency = USD", ordersUsd);
        printCollection("Orders with currency = EUR", ordersEur);

        printTaskHeader("separate list for as many lists as many unique cities are in user");
        Set<String> uniqueCities = orders.stream()
                                    .map(order -> order.getUser().getCity())
                                    .distinct()
                                    .collect(Collectors.toSet());
        final List<Order> finalOrders = new ArrayList<>(orders);
        Map<String, List<Order>> ordersInCity = uniqueCities.stream().collect(Collectors.toMap(
                city -> city,
                city->finalOrders.stream().filter(o->o.getUser().getCity().equals(city)).collect(Collectors.toList())));
        ordersInCity.forEach((city,orderList) -> printCollection("Orders in " + city, orderList));

        System.out.println("-------------\nTASKS FOR SET\n-------------\n");

        printCollection("Initial set of orders", setOfOrders);
        printTaskHeader("check if set contain order where User’s lastName is “" + SURNAMES[0] + "”");
        System.out.println("result=" + setOfOrders.stream().anyMatch((Order o) -> o.getUser().getLastName().equals(SURNAMES[0])));
        System.out.println();

        printTaskHeader("delete orders where currency is USD");
        setOfOrders.removeIf(o -> o.getCurrency() == Currency.USD);
        printCollection("Orders with currency = EUR", setOfOrders);
    }

    //creates random orders
    private static List<Order> createOrders(List<User> users, int numberOfOrders) {
        List<Order> orders = new ArrayList<>(numberOfOrders);

        for (int i = 0; i < numberOfOrders - 2; i++) {
            int itemNameNumber = random.nextInt(ITEM_NAMES.length);
            int userNumber = random.nextInt(users.size());
            int shopIdentificatorNumber = random.nextInt(SHOP_IDENTIFICATORS.length);
            int price = 500 * (itemNameNumber + 1) + random.nextInt((itemNameNumber + 1) * 500);
            Currency currency = (i % 2 == 0) ? Currency.USD : Currency.EUR;
            orders.add(new Order(price, currency, ITEM_NAMES[itemNameNumber],
                    SHOP_IDENTIFICATORS[shopIdentificatorNumber], users.get(userNumber)));
        }
        Order lastOrder = orders.get(numberOfOrders - 3);

        //add duplicated orders
        orders.add(lastOrder);
        orders.add(new Order(lastOrder.getPrice(), lastOrder.getCurrency(), lastOrder.getItemName(),
                lastOrder.getShopIdentificator(), lastOrder.getUser()));
        return orders;
    }

    //creates random users
    private static List<User> createUsers(int numberOfUsers) {
        List<User> users = new ArrayList<>(numberOfUsers);
        for (int i = 0; i < numberOfUsers; i++) {
            int nameNumber = random.nextInt(NAMES.length);
            int surnameNumber = random.nextInt(SURNAMES.length);
            int cityNumber = random.nextInt(CITIES.length);
            users.add(new User(NAMES[nameNumber], SURNAMES[surnameNumber], CITIES[cityNumber], 1000 + random.nextInt(9000)));
        }
        return users;
    }

    public static void printCollection(String listName, Collection orders) {
        module7.Task_1_3.Main.printCollection(listName,orders);
    }

    public static void printTaskHeader(String header) {
        String hullHeader = "TASK: " + header;
        System.out.println(hullHeader);
        for (int i = 0; i < hullHeader.length(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
