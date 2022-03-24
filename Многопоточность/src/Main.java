import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        float[] array = new float[100000000];
        Arrays.fill(array, 1);
        long time = System.currentTimeMillis();

        //firstMethod(array);
        secondMethod(array);

        System.out.println(System.currentTimeMillis() - time);
    }

    public static void firstMethod(float[] array) {
        Thread th = new Thread(() -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });

        th.start();

        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void secondMethod(float[] array) {
        Thread th = new Thread(() -> {
            for (int i = 0; i < array.length / 2; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < array.length / 2; i++) {
                array[i + array.length / 2] = (float) (array[i + array.length / 2] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });

        th.start();
        th1.start();

        try {
            th.join();
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
