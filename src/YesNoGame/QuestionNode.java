package YesNoGame;
import YesNoGameBinaryTree.*;

public class QuestionNode extends Node {
    private boolean animal;
    public QuestionNode(final String data) {
        super(data);
        this.animal = false;
    }

    public QuestionNode getYesNode() {
        return (QuestionNode) getRight();
    }

    public void setYesNode(final QuestionNode yesNode) {
        setRight(yesNode);
    }
    public QuestionNode getNoNode() {
        return (QuestionNode) getLeft();
    }

    public void setNoNode(final QuestionNode noNode) {
        setLeft(noNode);
    }

    public boolean isAnimal() {
        return animal;
    }

    public void setAnimal(final boolean animal) {
        this.animal = animal;
    }

}
