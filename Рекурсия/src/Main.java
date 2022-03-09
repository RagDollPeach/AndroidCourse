import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(multiply(5, 5));

        List<Item> items = new ArrayList<>();
        items.add(new Item("iPodm", 800, 5));
        items.add(new Item("iPod", 800, 2));
        items.add(new Item("Food", 50, 4));
        items.add(new Item("NoteBook", 1500, 3));
        items.add(new Item("smartphone", 800, 1));
        items.add(new Item("player", 200, 1));
        items.add(new Item("console", 900, 2));

        List<Item> list = new ArrayList<>();

        Backpack backpack = new Backpack();
        backpack.feelUpBackpack(items, list).forEach(System.out::println);
    }

    public static long multiply(long value, int exponent) {
        if (exponent < 1) {
            return value;
        }
        return multiply(value, exponent - 1) * value;
    }
}
