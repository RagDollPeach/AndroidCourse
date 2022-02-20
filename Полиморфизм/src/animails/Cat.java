package animails;

public class Cat extends Animal {
    private String name;
    private int runLimit = 200;

    public Cat(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String run(int miters) {
       return (miters <= runLimit) ? "cat runs " + miters + " miters" : "Cat cant run more than 200 miters";

    }

    @Override
    public String swim(int miters) {
        return "cat cant swim";
    }
}
