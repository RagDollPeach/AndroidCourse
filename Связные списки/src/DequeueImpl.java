

public class DequeueImpl<E> implements Dequeue<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    @Override
    public boolean insertLeft(E value) {
        first = new Node<>(value, first, last);
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {

        return  false;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        Dequeue.Node<E> removedNode = last;
        last = removedNode.prev;
        removedNode.prev = null;
        size--;
        return removedNode.item;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        Dequeue.Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    @Override
    public boolean insert(E value) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peekFront() {
        return first.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Dequeue.Node<E> current = first;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }
}
