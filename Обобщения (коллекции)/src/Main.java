import java.util.*;

public class Main {
    public static void main(String[] args) {

//=================== Задание 1 ===========================================//
        String[] string = {"A", "B","R","T","A","C","B","C","R","H","A","B","C","F","A","C"};

        print(collectionOperation(string));

//=================== Задание 2 ===========================================//
        Phonebook phonebook = new Phonebook(feelUpMap());
        phonebook.add("Gena", "15481541644", "26544132655");
        phonebook.add("Lena", "684164165165146");
        phonebook.add("Marina", "15481541644", "26544132655","51648816515161");

        phonebook.printPhoneBook();

        phonebook.get("Gena");
        phonebook.get("Lena");
        phonebook.get("Dmitrij8");
        phonebook.get("Marina");
        phonebook.get("Dmitrij5");
    }

    public static Map<String, List<String>> feelUpMap() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list;
        int digit;
        for (int i = 0; i < 10; i++) {
            digit = (int) Math.round(Math.random() * 10);
            list = new ArrayList<>();
            if (digit % 2 == 0) {
                for (int j = 0; j < 3; j++) {
                    long a = Math.round(Math.random() * 100000000000L);
                    list.add(Long.toString(a));
                }
            } else {
                for (int j = 0; j < 1; j++) {
                    long a = Math.round(Math.random() * 100000000000L);
                    list.add(Long.toString(a));
                }
            }
            map.put("Dmitrij" + i , list);
        }
        return map;
    }

    public static void print(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static Map<String, Integer> collectionOperation(String[] array) {
        List<String> strings = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Collections.addAll(strings, array);
        Set<String> set = new HashSet<>(strings);
        int sum = 0;
        for (String str : set) {
            for (String str1 : strings) {
                if (str.equals(str1)) {
                    sum++;
                }
            }
            map.put(str, sum);
            sum = 0;
        }
        return map;
    }
}
