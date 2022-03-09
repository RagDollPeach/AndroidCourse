import java.util.*;

public class Backpack {

    private final int WEIGHT_LIMIT = 9;

    public List<Item> feelUpBackpack(List<Item> listOfItems, List<Item> backpack) {
        Item item;
        if (listOfItems.size() > 0) {
            item = listOfItems.stream().max(Item::compareTo).get();
        } else {
            return backpack;
        }

        int sum = 0;
        for (Item item1 : backpack) {
            sum += item1.getWeight();
        }

        if (item.getWeight() + sum <= WEIGHT_LIMIT) {
            backpack.add(item);
            listOfItems.remove(item);
        } else {
            listOfItems.remove(item);
        }

        return feelUpBackpack(listOfItems, backpack);
    }
}

