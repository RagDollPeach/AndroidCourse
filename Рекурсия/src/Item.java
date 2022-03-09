public class Item implements Comparable<Item> {

    private String name;
    private int price;
    private int weight;

    public Item(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Item -" +
                " name = " + name +
                ", price = " + price +
                ", weight = " + weight;
    }

    @Override
    public int compareTo(Item o) {
        if (this.getPrice() == o.getPrice()) {
            return 0;
        }
        return this.getPrice() > o.getPrice() ? 1 : -1;
    }
}
