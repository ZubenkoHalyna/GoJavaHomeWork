package module7;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by g.zubenko on 11.12.2016.
 */
public class Main {
    static private final String[] NAMES = {"Mary", "John", "Mark", "Paul", "Emily", "Alice", "Anna", "Harry", "Oliver"};
    static private final String[] SURNAMES = {"Green", "Black", "White", "Brown", "Gray", "Wood", "Parker"};
    static private final String[] CITIES = {"Kiev", "Kharkov", "Zaporozhye"};//, "Poltava", "Lvov"};
    static private final String[] ITEM_NAMES = {"headphones", "blender", "mobile phone", "microwave", "TV set", "fridge"};
    static private final String[] SHOP_IDENTIFICATORS = {"technoMall", "foxtrot"};//, "Comfy"};
    static private Random random = new Random();

    public static void main(String[] args) {

        printTaskHeader("                          TASK № 2                          ");
        printSubHeader("create Main class where you create 10 Orders with 10 Users and put it to the List");
        final int numberOfUsers = 10;
        List<User> users = createUsers(numberOfUsers);
        users.sort(User.getByNameComparator());
        printCollection("List of users", users);

        final int numberOfOrders = 10;
        List<Order> orders = createOrders(users, numberOfOrders);
        Set<Order> setOfOrders = new HashSet<>(orders); // for task3
        printCollection("Initial list of orders", orders);

        printSubHeader("delete duplicates from the list");
        orders = orders.stream().distinct().collect(Collectors.toList());
        printCollection("Orders without duplicates", orders);

        printSubHeader("sort list by order price in decrease order");
        orders.sort(Order.getByPriceComparator());
        printCollection("Orders sorted by price", orders);

        printSubHeader("sort list by order price in increase order and user city");
        orders.sort(Order.getByPriceAndCityComparator());
        printCollection("Orders sorted by city and price", orders);

        printSubHeader("sort list by order itemName and shopIdentificator and user city");
        orders.sort(Order.getByItemAndShopAndCityComparator());
        printCollection("Orders sorted by city, shop and item", orders);

        printSubHeader("delete items where price less than 1500");
        orders.removeIf((Order o) -> o.getPrice() < 1500);
        printCollection("Orders with price >1500", orders);

        printSubHeader("separate list for two list - orders in USD and UAH");
        List<Order> ordersUsd = orders.stream().filter((Order o) -> o.getCurrency() == Currency.USD).collect(Collectors.toList());
        List<Order> ordersEur = orders.stream().filter((Order o) -> o.getCurrency() == Currency.EUR).collect(Collectors.toList());
        printCollection("Orders with currency = USD", ordersUsd);
        printCollection("Orders with currency = EUR", ordersEur);

        printSubHeader("separate list for as many lists as many unique cities are in user");
        Map<String, List<Order>> ordersInCity = groupOrdersByCity(orders);

        for (Map.Entry<String, List<Order>> item : ordersInCity.entrySet()) {
            printCollection("Orders in " + item.getKey(), item.getValue());
        }


        printTaskHeader("                          TASK № 3                          ");
        printCollection("Initial set of orders", setOfOrders);
        printSubHeader("check if set contain order where User’s lastName is “"+SURNAMES[0]+"”");
        System.out.println("result="+setOfOrders.stream().anyMatch((Order o)->o.getUser().getLastName().equals(SURNAMES[0])));
        System.out.println();

        printSubHeader("print order with largest price using only one set method - get ");
        System.out.println("result = Order{"+setOfOrders.stream().min(Order.getByPriceComparator()).get()+"}");
        System.out.println();

        printSubHeader("delete orders where currency is USD using Iterator");
        Iterator<Order> iterator = setOfOrders.iterator();
        while (iterator.hasNext()){
            Order item = iterator.next();
            if(item.getCurrency()==Currency.USD){
                iterator.remove();
            }
        }
        printCollection("Orders with currency = EUR", setOfOrders);
    }

    private static Map<String, List<Order>> groupOrdersByCity(List<Order> orders) {
        Map<String, List<Order>> ordersInCity = new HashMap<>();
        Iterator<Order> i = orders.iterator();
        while (i.hasNext()) {
            Order currentOrder = i.next();
            String city = currentOrder.getUser().getCity();
            if (!ordersInCity.keySet().contains(city)) {
                List<Order> newList = new ArrayList<Order>();
                newList.add(currentOrder);
                ordersInCity.put(city, newList);
            } else {
                List<Order> currentList = ordersInCity.get(city);
                currentList.add(currentOrder);
            }
        } return ordersInCity;
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
        Object obj = orders.iterator().next();
        String[] objectToString = obj.toString().split(", ");
        final int maxColumnNumber = objectToString.length;
        final String[] columnName = new String[maxColumnNumber];//{"Item ", "Price ", "Shop ", "Ful name ", "City ", "Id "};
        int[] maxLength = new int[maxColumnNumber];//{5, 6, 5, 9, 5, 3};
        for (int j = 0; j < maxColumnNumber; j++) {
            String currentString = objectToString[j];
            columnName[j] = currentString.substring(0, currentString.indexOf('='));
            maxLength[j] = columnName[j].length();
        }
        String[][] strings = new String[orders.size()][maxColumnNumber];

        int rowCount = 0;
        for (Object cOrder : orders) {
            strings[rowCount] = cOrder.toString().split(", ", maxColumnNumber);
            for (int j = 0; j < maxColumnNumber; j++) {
                String currentString = strings[rowCount][j];
                strings[rowCount][j] = currentString.substring(currentString.indexOf('=') + 1, currentString.length());
                if (maxLength[j] < strings[rowCount][j].length()) maxLength[j] = strings[rowCount][j].length();
            }
            rowCount++;
        }

        String[] formatString = new String[maxColumnNumber];
        for (int j = 0; j < maxColumnNumber; j++) {
            formatString[j] = "%" + (maxLength[j] + 3) + "s";
        }

        System.out.println(listName + ":\n");
        System.out.format("%2s", "№");
        for (int j = 0; j < maxColumnNumber; j++) {
            System.out.format(formatString[j], columnName[j]);
        }
        System.out.println();
        for (int i = 0; i < orders.size(); i++) {
            System.out.format("%3d", i + 1);
            for (int j = 0; j < maxColumnNumber; j++) {
                System.out.format(formatString[j], strings[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printSubHeader(String header) {
        printTaskHeader("TASK: "+header);
    }


    public static void printTaskHeader(String header) {
        System.out.println(header);
        for (int i = 0; i < header.length(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}

