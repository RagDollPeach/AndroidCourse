package fruits;

public class Apple extends Fruit {

    private final String name;
    private final double weight;

    public Apple(String name, double weight) {
        super(weight);
        this.name = name;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("фрукт - %s вес - %s", name, weight);
    }
}
