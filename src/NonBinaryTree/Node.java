package NonBinaryTree;
import java.util.*;

public class Node {

    private List<Node> children = new ArrayList<Node>();
    private Node parent;
    private String data;


    public Node(){};

    public Node(String data){
        setData(data);
    }


    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }

    public List<Node> getChildren(){
        return children;
    }

    public void addChildren(Node node){
        node.parent = this;
        this.children.add(node);
    }

    public void removeChildren(){
        children = new ArrayList<Node>();
    }

    public Node getParent(){
        return parent;
    }

    public void print(String prefix, boolean isTall){
        System.out.print(prefix + (isTall? "\\-" : "|-")+ data);
        for (int i = 0; i< children.size()-1; i++){
            children.get(i).print(prefix + (isTall? " " : "| "), false);
        }
        if (children.size()>0){
            children.get(children.size()-1).print(prefix+(isTall? " ": "| "), true);
        }
    }
}
