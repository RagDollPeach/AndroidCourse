import fruits.Apple;
import fruits.Orange;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c", "d", "e", "f"};
        Integer[] digits = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(arrayChange(strings)));
        System.out.println();

        Box<Apple> boxWithApples = new Box<>();
        Box<Orange> boxWithOranges = new Box<>();
        Box<Orange> boxWithBigOranges = new Box<>();

        for (int i = 0; i < 10; i++) {
            boxWithOranges.myAdd(new Orange("Orange", 1.0));

        }

        for (int i = 0; i < 10; i++) {
            boxWithApples.myAdd(new Apple("Apple", 1.0));
            boxWithBigOranges.myAdd(new Orange("Orange", 2.0));
        }

        System.out.println(boxWithApples.getWeight());
        System.out.println(boxWithOranges.getWeight());
        System.out.println(boxWithApples.myCompareTo(boxWithOranges));

        System.out.println();
        boxWithOranges.sprinkle(boxWithBigOranges).getFruits()
                .forEach(System.out::println);
    }

// Задание 1.

    public static Object[] arrayChange(Object[] objects) {
        for (int i = 1; i < objects.length; i += 2) {
            Object temp = objects[i];
            objects[i] = objects[i - 1];
            objects[i - 1] = temp;
        }
        return objects;
    }
}
