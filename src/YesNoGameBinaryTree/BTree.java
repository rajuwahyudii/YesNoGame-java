package YesNoGameBinaryTree;

import java.util.Objects;

public class BTree {
    private Node root;
    private Node currentNode;

    public BTree() {
//        root = null;
        this(null);
    }

    public  BTree(final Node root ){
        setRoot(root);
    }
    //-----------
    public boolean search(String data) {
        return search(root, data);
    }

    public void printInorder() {
        root.printInorder(root);
    }

    public void printPreOrder() {
        root.printPreorder(root);
    }

    public void printPostOrder() {
        root.printPostorder(root);
    }
    public void print() {
        root.print();
    }




//--
    public boolean isEmpty() {
        return root == null;
    }
    public int countNodes() {
        return countNodes(root);
    }
    public int countNodes(final Node node) {
        if (node == null) return 0;
        int count = 1;
        count += countNodes(node.getLeft());
        count += countNodes(node.getRight());
        return count;
    }

//    private int countNodes(Node node) {
//        int count = 1;
//        if (node == null) {
//            return 0;
//        }
//        else {
//            count += countNodes(node.getLeft());
//            count += countNodes(node.getRight());
//            return count;
//        }
//    }

    private boolean search(Node node,String data) {
        if (node.getData() == data)
            return true;
        if (node.getLeft() != null)
            if (search(node.getLeft(),data))
                return true;
        if (node.getRight() != null)
            if (search(node.getRight(),data))
                return true;
        return false;
    }







    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    public Node getCurrent() {
        return currentNode;
    }
    public void setCurrent(Node node) {
        this.currentNode = node;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}