package animails;

public class Dog extends Animal {
    private String name;
    private int runLimit = 500;
    private int swimLimit = 10;

    public Dog(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String run(int miters) {
        return (miters <= runLimit) ? "dog runs " + miters : "Dog cant run more than 500 miters";
    }

    @Override
    public String swim(int miters) {
        return (miters <= swimLimit) ? "dog swim " + miters : "Dog cant swim more than 10 miters";
    }
}
