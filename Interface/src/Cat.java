public class Cat implements Runner, Jumper, Members{

    private final double catCanJump = 2.2;
    private final int catCanRun = 3;

    @Override
    public String jump(Wall wallHeight) {
        if (wallHeight.getHeight() <= catCanJump) {
            return "Win Кот перепрыгнул препядствие";
        } else {
            return "Lost Кот не перепрыгнул стену";
        }
    }

    @Override
    public String run(Treadmill treadmillLength) {
        if (treadmillLength.getLength() <= catCanRun) {
            return "Win кот пробежал дистанцию";
        } else {
            return "Lost кот не пробежал дистанцию";
        }
    }
}
