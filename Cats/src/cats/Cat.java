package cats;

import plates.Plate;

public class Cat {
    private final String name;
    private int appetite;
    private boolean hungry = true;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) throws InterruptedException {
        hungry = (appetite = plate.decreaseFood(appetite)) != 0;
    }

    public void print(Plate plate) {
        System.out.println(this);
        System.out.println("Food left in plate - " + plate.getFoodCount());
        System.out.println((hungry) ? "Cat still hungry" : "Cat well-fed and HAPPY!!!");
    }

    @Override
    public String toString() {
        return String.format("\nCat name - %s\nappetite - %d", name, appetite);
    }

    public boolean isHungry() {
        return hungry;
    }

    public String getName() {
        return name;
    }
}
