public class Main {
    public static void main(String[] args) {

        Robot robot = new Robot();
        Cat cat = new Cat();
        Human human = new Human();

        Obstacles[] obstacles = new Obstacles[5];
        obstacles[0] = new Treadmill(2);
        obstacles[1] = new Wall(1.2);
        obstacles[2] = new Treadmill(4);
        obstacles[3] = new Wall(2.5);
        obstacles[4] = new Treadmill(12);

        Members[] members = new Members[3];
        members[0] = human;
        members[1] = cat;
        members[2] = robot;

        start(obstacles, members);
    }

    public static void start(Obstacles[] obstacles, Members[] members) {
        for (Members member : members) {
            for (Obstacles obstacle : obstacles) {
                if (obstacle.getClass() == Treadmill.class) {
                    if (member.run((Treadmill) obstacle).charAt(0) == 'L') {
                        System.out.println(member.run((Treadmill) obstacle));
                        break;
                    }
                    System.out.println(member.run((Treadmill) obstacle));
                } else {
                    if (member.jump((Wall) obstacle).charAt(0) == 'L') {
                        System.out.println(member.jump((Wall) obstacle));
                        break;
                    }
                    System.out.println(member.jump((Wall) obstacle));
                }
            }
        }
    }
}
