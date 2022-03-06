import fruits.Fruit;


import java.util.ArrayList;
import java.util.List;

public class Box<E extends Fruit> implements Comparable<Box<E>> {

    private List<E> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void myAdd(E fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        return this.fruits.get(0).getWeight() * fruits.size();
    }

    public Box<E> sprinkle(Box<E> box) {
        List<E> sublist = this.fruits.subList(0, this.fruits.size());
        this.fruits.removeAll(sublist);

        this.fruits.addAll(box.fruits);
        List<E> sublist1 = box.fruits.subList(0, box.fruits.size());
        box.fruits.removeAll(sublist1);

        return this;
    }

    public boolean myCompareTo(Box box) {
        return compareTo(box) == 0;
    }

    @Override
    public int compareTo(Box o) {
        if (this.getWeight() == o.getWeight()) {
            return 0;
        }
        return this.getWeight() > o.getWeight() ? 1 : -1;
    }

    public List<E> getFruits() {
        return fruits;
    }
}
