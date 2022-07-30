package YesNoGameBinaryTree;

public class Node extends ABTreeObj{

    String data;
    Node left;
    Node right;

    //constructor
    public Node(String data) {
        this.data = data;
        left = null;
        right = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node node) {
        if (left == null)
            left = node;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node node) {
        if (right == null)
            right = node;
    }

    void printPreorder(Node Node) {
        if (Node == null)
            return;

        System.out.print(Node.data + " "); //root-lefft -right
        printPreorder(Node.left);
        printPreorder(Node.right);
    }

    void printPostorder(Node Node) { //left-right-root
        if (Node == null)
            return;

        printPostorder(Node.left);
        printPostorder(Node.right);
        System.out.print(Node.data + " ");
    }

    void printInorder(Node Node) { //left-root-right
        if (Node == null)
            return;

        printInorder(Node.left); //left
        System.out.print(Node.data + " "); //root
        printInorder(Node.right); //right
    }

    public void print() {
        print("", true);

    }

    private void print(final String prefix, final boolean isTail) {
        if (right != null) right.print(prefix + (isTail ? "|" : " ") + "   ", false);
        System.out.println(prefix + (isTail ? "\\" : "/") + "-- " + data);
        if (left != null) left.print(prefix + (isTail ? " " : "|") + "   ", true);
    }

    @Override
    public void printPreOrder() {
        System.out.print(data + " ");
        if (left != null) left.printPreOrder();
        if (right != null) right.printPreOrder();
    }

    @Override
    public void printPostOrder() {
        if (left != null) left.printPostOrder();
        if (right != null) right.printPostOrder();
        System.out.print(data + " ");
    }

    @Override
    public void printInOrder() {
        if (left != null) left.printInOrder();
        System.out.print(data + " ");
        if (right != null) right.printInOrder();
    }
}

