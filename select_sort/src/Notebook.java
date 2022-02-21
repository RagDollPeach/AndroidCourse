public class Notebook {
    private String companyName;
    private int price;
    private int ram;

    public Notebook(String companyName, int price, int ram) {
        this.companyName = companyName;
        this.price = price;
        this.ram = ram;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return String.format("\nCompany name - %s\nprice - %d\nram - %d", companyName, price, ram);
    }
}
