public class Robot implements Runner, Jumper, Members {

    private final double robotCanJump = 3.5;
    private final int robotCanRun = 10;

    @Override
    public String jump(Wall wallHeight) {
        if (wallHeight.getHeight() <= robotCanJump) {
            return "Win Робот успешно перепрыгнул стену";
        } else {
            return "Lost Робот не смог взять препядствие";
        }
    }

    @Override
    public String run(Treadmill treadmillLength) {
        if (treadmillLength.getLength() <= robotCanRun) {
            return "Win Робот успешно пробежал дистанцыю";
        } else {
            return "Lost Роботу не хватило энергии пробежать дистанцыю";
        }
    }
}
