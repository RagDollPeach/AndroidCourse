import cats.Cat;
import plates.Plate;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat("Персик", 10);
        Cat cat1 = new Cat("Барсик", 8);
        Cat cat2 = new Cat("Маркиз", 12);
        Cat cat3 = new Cat("Филя", 14);

        Plate plate = new Plate(11);

        Cat[] cats = new Cat[4];
        cats[0] = cat;
        cats[1] = cat1;
        cats[2] = cat2;
        cats[3] = cat3;

        for (Cat cat4 : cats) {
            cat4.eat(plate);
            cat4.print(plate);
            System.out.println();
        }

        Arrays.stream(cats).filter(Cat::isHungry)
                .forEach(c -> System.out.println("Hungry cat name - " + c.getName()));
    }
}
