import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Dima"
                , "Kolesnikov", "sergeevich", "Java developer", "ajkhfkjsb@mail.ru"
                , "+54644338", 300000, 52);
        employees[1] = new Employee("Andrej"
                , "Mishin", "denisovich", "Java Script developer", "fhdhdhdjsb@mail.ru"
                , "+5464435638", 250000, 32);
        employees[2] = new Employee("Vaska"
                , "Pupkin", "не известен", "Piton developer", "herjytkjsb@mail.ru"
                , "+685632255", 34148000, 26);
        employees[3] = new Employee("Sergej"
                , "Durikov", "Vasilevich", "Java developer", "sdfefjsb@mail.ru"
                , "+6586684215", 150000, 45);
        employees[4] = new Employee("petia"
                , "Pupkin", "Genadievich", "Type Script developer", "affdhttb@mail.ru"
                , "+659876688", 300000, 58);

        Arrays.stream(employees).filter(employee -> employee.getAge() > 40).forEach(Employee::printInfo);
    }
}
