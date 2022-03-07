public class Item {

    private  String name;
    private  int price;
    private  int weight;

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
                " name = " + name  +
                ", price = " + price +
                ", weight = " + weight;
    }
}
