import java.util.*;

public class Backpack {

    private final int WEIGHT_LIMIT = 9;

    public List<Item> feelUpBackpack(List<Item> listOfItems, List<Item> backpack) {
        Item item;
        if (listOfItems.size() > 0){
            item = getExpensiveItem(listOfItems);
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

    public Item getExpensiveItem(List<Item> list) {
        Item temp = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getPrice() > temp.getPrice()) {
                temp = list.get(i);
            }
        }
        return temp;
    }
}

