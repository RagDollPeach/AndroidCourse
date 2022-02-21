
public class Sort {

    public void sortSelect(Notebook[] array) {
        int out, in, mark;
        for (out = 0; out < array.length; out++) {
            mark = out;
            for (in = out + 1; in < array.length; in++) {
                if (array[in].getPrice() < array[mark].getPrice()) {
                    mark = in;
                }
                if (array[in].getPrice() == array[mark].getPrice()) {
                    if (array[in].getRam() < array[mark].getRam()) {
                        mark = in;
                    }
                }
                if (array[in].getPrice() == array[mark].getPrice()) {
                    if (array[in].getRam() == array[mark].getRam()) {
                        if (array[in].getCompanyName().charAt(0) < array[mark].getCompanyName().charAt(0)) {
                            mark = in;
                        }
                    }
                }
            }
            change(array, out, mark);
        }
    }

    private void change(Notebook[] array, int a, int b) {
        Notebook tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
