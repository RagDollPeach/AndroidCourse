
public class Node<E extends Comparable<? super E>> {

    private E value;

    private Node<E> leftChild;

    private Node<E> rightChild;

    private int repeat;

    private boolean isRed;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<E> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<E> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeftChild(E value) {
        return getValue().compareTo(value) > 0;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlyOneChild() {
        // return leftChild == null && rightChild != null || leftChild != null && rightChild == null;
         return rightChild != null ^ leftChild != null;
    }
}
