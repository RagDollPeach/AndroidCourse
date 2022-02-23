package plates;

import java.util.Scanner;

public class Plate {
    private int foodCount;
    private final Scanner sc = new Scanner(System.in);

    public Plate(int foodCount) {
        this.foodCount = foodCount;
    }

    public int decreaseFood(int catAppetite) throws InterruptedException {
        while (true) {
            if (catAppetite == 0 || foodCount == 0) {
                if (foodCount == 0 && feelUpFoodPlate().equals("y")) {
                    System.out.println("Fell up food plate");
                    foodCount = sc.nextInt();
                } else {
                    break;
                }
            } else {
                foodCount--;
                catAppetite--;
                Thread.sleep(500);
                System.out.println("Cat eating - " + catAppetite + " " + "food in plate - " + foodCount);
            }
        }
        return catAppetite;
    }

    public String feelUpFoodPlate() {
        System.out.println("Will you fell up the plate? y/n");
        return sc.nextLine();
    }

    public int getFoodCount() {
        return foodCount;
    }
}
