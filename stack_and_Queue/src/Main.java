public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,9,10};
        int[] ar = {};
        int[] arr = {1,2,3,4,5,6};
        System.out.println(lostDigitSearch(array));
    }

    public static int lostDigitSearch(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int base;

        while (start <= end) {
            base = (start + end) / 2;
            if (array[base] - base == 1) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }
        return start + 1;
    }
}
