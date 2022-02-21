import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sort sort = new Sort();
        Notebook[] notebooks = getNoteBooks();
        Arrays.stream(notebooks).forEach(System.out::println);
        sort.sortSelect(notebooks);
        System.out.println("=========================================================================");
        Arrays.stream(notebooks).forEach(System.out::println);
    }

    public static Notebook[] getNoteBooks() {
        Notebook[] notebooks = new Notebook[10000];
        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = new Notebook(companyName(), price(), ram());
        }
        return notebooks;
    }

    private static String companyName() {
        String str1 = "Lenovo";
        String str2 = "Asus";
        String str3 = "Apple";
        String str4 = "Esser";
        String str5 = "Xsiaomi";
        Random random = new Random();
        return switch (random.nextInt(5)) {
            case 1 -> str1;
            case 2 -> str2;
            case 3 -> str3;
            case 4 -> str4;
            default -> str5;
        };
    }

    private static int price() {
        Random random = new Random();
        return random.nextInt(500, 2000);
    }

    private static int ram() {
        int a = 0;
        while (a == 0) {
            a = (int) Math.round(Math.random() * 16) * 1000;
        }
        return a;
    }
}
