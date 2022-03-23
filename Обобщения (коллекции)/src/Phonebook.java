import java.util.*;

public class Phonebook {

    private Map<String, List<String>> phoneBook;

    public Phonebook(Map<String, List<String>> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void add(String name, String... numbers) {
        List<String> list = new ArrayList<>(Arrays.asList(numbers));
        phoneBook.put(name, list);
    }

    public void get(String name) {
        System.out.println("===============================================");
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            if (entry.getKey().equals(name)) {
                System.out.println(entry.getKey());
                entry.getValue().forEach(System.out::println);
            }
        }
        System.out.println("===============================================");
    }

    public void printPhoneBook() {
        System.out.println("===============================================");
        System.out.println("All numbers:");
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("===============================================");
    }
}
