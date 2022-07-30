package YesNoGame;

import YesNoGameBinaryTree.*;
public class QuestionTree extends BTree {
    public QuestionTree(){
        this(null);
    }

    public QuestionTree(final QuestionNode root){
        super(root);
    }

    public int countAnimals(){
        return countAnimals((QuestionNode)getRoot());
    }

    private int countAnimals(final QuestionNode node){
        if(node == null) return 0;
        int count = node.isAnimal() ? 1:0;
        count += countAnimals(node.getYesNode());
        count += countAnimals(node.getNoNode());
        return count;
    }

    @Override
    public QuestionNode getCurrent(){
        return  (QuestionNode) super.getCurrent();
    }
}
