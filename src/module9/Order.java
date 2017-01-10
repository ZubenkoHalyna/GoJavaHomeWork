package module9;

/**
 * Created by g.zubenko on 11.12.2016.
 */
public class Order {
    private long id;
    private int price;
    private Currency currency;
    private String itemName;
    private String shopIdentificator;
    private User user;
    private static IdProvider idProvider = UuidProvider.getInstance();
    private static OrderComparator byPriceComparator = new OrderComparator(
            (Order o1, Order o2) -> o2.price - o1.price);
    private static OrderComparator byPriceAndCityComparator = new OrderComparator(
            (Order o1, Order o2) -> (o1.user.getCity().equals(o2.user.getCity())) ?
                    o1.price - o2.price : o1.user.getCity().compareTo(o2.user.getCity()));
    private static OrderComparator byItemAndOrderAndCityComparator = new OrderComparator(
            (Order o1, Order o2) -> (o1.user.getCity().equals(o2.user.getCity())) ?
                    (o1.itemName.equals(o2.itemName)) ?
                            (o2.id > o1.id)? 1: -1 :
                            o1.itemName.compareToIgnoreCase(o2.itemName) :
                    o1.user.getCity().compareTo(o2.user.getCity()));


    public Order(int price, Currency currency, String itemName, String shopIdentificator, User user) {
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
        this.user = user;
        this.id = getNewId();
    }

    public Order(Order orderToCopy) {
        id = orderToCopy.id;
        price = orderToCopy.price;
        currency = orderToCopy.currency;
        itemName = orderToCopy.itemName;
        shopIdentificator = orderToCopy.shopIdentificator;
        user = orderToCopy.user;
    }

    public Order() {
    }

    protected long getNewId() {
        return idProvider.getNewId();
    }

    @Override
    public String toString() {
        return "Order{item=" + itemName +
                ", price=" + price + " " + currency +
                ", shop=" + shopIdentificator +
                ", user=" + user.getShortDescription() +
                ", id=" + id +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (price != order.price) return false;
        if (currency != order.currency) return false;
        if (!itemName.equals(order.itemName)) return false;
        if (!shopIdentificator.equals(order.shopIdentificator)) return false;
        return user.equals(order.user);

    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + currency.hashCode();
        result = 31 * result + itemName.hashCode();
        result = 31 * result + shopIdentificator.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    public static OrderComparator getByPriceComparator() {
        return byPriceComparator;
    }

    public static OrderComparator getByPriceAndCityComparator() {
        return byPriceAndCityComparator;
    }

    public static OrderComparator getByItemAndOrderAndCityComparator() {
        return byItemAndOrderAndCityComparator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getShopIdentificator() {
        return shopIdentificator;
    }

    public void setShopIdentificator(String shopIdentificator) {
        this.shopIdentificator = shopIdentificator;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
