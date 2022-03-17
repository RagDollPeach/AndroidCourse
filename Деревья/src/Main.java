public class Main {
    public static void main(String[] args) {
        TreeImpl<Integer> tree;

        for (int i = 0; i < 20; i++) {
            tree = new TreeImpl<>();
            for (int j = 0; j < 15; j++) {
                tree.add((int) Math.round(Math.random() * 50 -25));
            }

            tree.display();
            System.out.println(isBalanced(tree.getRoot()));
            tree.traverse(Tree.TraversMode.IN_ORDER);
            System.out.println();
            tree.traverse(Tree.TraversMode.PRE_ORDER);
            System.out.println();
            tree.traverse(Tree.TraversMode.POST_ORDER);
            System.out.println();
            System.out.println("============================================================");
        }


    }

    public static <E extends Comparable<? super E>> boolean isBalanced(Node<E> node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static <E extends Comparable<? super E>> int height(Node<E> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
