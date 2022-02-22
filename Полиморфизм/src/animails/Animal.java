package animails;

public class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String run(int miters) {
      return "Animal runs " + miters;
    }

    public String swim(int miters) {
        return "Animal swim " + miters;
    }

    public void print(String animal) {
        System.out.println(name + " " + animal);
    }

    public static void count(Animal[] animals) {
        int countCats = 0;
        int countDogs = 0;
        for (Animal animal : animals) {
            if (animal.getClass().equals(Cat.class)) {
                countCats++;
            } else {
                countDogs++;
            }
        }
        System.out.println("Dogs - " + countDogs + " Cats - " + countCats);
    }
}
