public class Employee {

     private String name;
     private String lastName;
     private String fathersName;
     private String position;
     private String eMail;
     private String phoneNumber;
     private int salary;
     private int age;

    public Employee(String name, String lastName, String fathersName, String position, String eMail, String phoneNumber, int salary, int age) {
        this.name = name;
        this.lastName = lastName;
        this.fathersName = fathersName;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("""
                1) Имя: %s
                2) Фамилия: %s
                3) Отчество: %s\040
                4) Должность: %s
                5) ел-почта: %s
                6) тел. номер: %s
                7) зарплата: %d
                8) возраст: %d
                """, name,lastName,fathersName,position,eMail,phoneNumber,salary,age);
    }
}
