public class Human implements Runner, Jumper, Members {

    private final double humanCanJump = 1.5;
    private final int humanCanRun = 5;


    @Override
    public String jump(Wall wallHeight) {
        if (wallHeight.getHeight() <= humanCanJump) {
            return "Win Человек перепрыгнул препядствие";
        } else {

            return "Lost Человек не перепрыгнул стену";
        }
    }

    @Override
    public String run(Treadmill treadmillLength) {
        if (treadmillLength.getLength() <= humanCanRun) {
           return "Win Человек пробежал дистанцию";
        } else {
            return "Lost Человек не пробежал дистанцию";
        }
    }
}
