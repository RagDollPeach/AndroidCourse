public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedListImpl<>();
        //Stack<Integer> ll1 = new LinkedListStack<>(ll);
        Dequeue<Integer> ll1 = new DequeueImpl<>();

        ll1.insertRight(1);
        ll1.insertLeft(2);
        ll1.insertRight(3);
        ll1.insertLeft(4);
        ll1.insertRight(5);
        ll1.insertLeft(6);
        ll1.insertLeft(7);



        ll1.display();
    }
}
