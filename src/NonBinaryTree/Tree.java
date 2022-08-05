package NonBinaryTree;

import java.util.*;

public class Tree {
    private Node root;

    public void setRoot(Node root){
        this.root = root;
    }

    public boolean isEmpty(){
        return (root ==null);
    }
    public void print(){
        root.print("", true);
    }

}
