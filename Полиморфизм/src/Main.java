import animails.Animal;
import animails.Cat;
import animails.Dog;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Persik");
        Animal dog = new Dog("Foka");
        Animal[] animals = new Animal[2];

        animals[0] = cat;
        animals[1] = dog;
        dog.print(dog.run(500));
        dog.print(dog.swim(10));

        cat.print(cat.run(200));
        cat.print(cat.swim(20));
        Animal.count(animals);
    }
}
