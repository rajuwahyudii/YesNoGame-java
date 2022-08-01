package YesNoGame;
import java.io.*;
import java.util.*;


public class Game {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static QuestionTree tree;

    public static void main(String[] args) {
        loadTree();
        System.out.println("Let's play a game! I know " + tree.countAnimals() + " youtuber");
        System.out.println("You think of a youtuber, and I have to find out which one it is!");
        mainLoop();
    }
    private static void loadTree() {
        try {
            final var file = new File("tree.dat");
            if (file.exists() && !file.isDirectory()) {
                final var objectInputStream = new ObjectInputStream(new FileInputStream("tree.dat"));
                tree = (QuestionTree) objectInputStream.readObject();
                objectInputStream.close();
                tree.setCurrent(tree.getRoot());
            } else createTree();
        } catch (IOException | ClassNotFoundException ignored) {
            System.out.println("Error loading tree data.");
            createTree();
        }

    }
    private static void createTree() {
        tree = new QuestionTree();
        tree.setRoot(new QuestionNode("Is it a girl ?"));
        tree.setCurrent(tree.getRoot());
    }
    private static void saveTree() {
        try {
            final var objectOutputStream = new ObjectOutputStream(new FileOutputStream("tree.dat"));
            objectOutputStream.writeObject(tree);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException ignored) {
            System.out.println("Error saving tree data.");
        }
    }
    private static String inputPrompt() {
        try {
            final var readString = reader.readLine();
            return readString.equals("") ? inputPrompt() : readString;
        } catch (IOException ignored) {
            System.out.println("Something went wrong. Please try again.");
            return inputPrompt();
        }
    }
    private static void mainLoop() {
        if (tree.getRoot() == null || tree.getCurrent() == null) return;
        var switchFlag = false;
        System.out.println("(d: tree diagram)");
        System.out.println("(q: quit)");
        System.out.println(tree.getCurrent().getData() + " (y/n)");
        var inputString = inputPrompt().toLowerCase(Locale.ROOT);
        if (Objects.equals(inputString, "q")) {
            saveTree();
            return;
        }
        if (Objects.equals(inputString, "d")) tree.print();
        if (Objects.equals(inputString, "y")) {
            if (tree.getCurrent().getYesNode() != null)
                tree.setCurrent(tree.getCurrent().getYesNode());
            else {
                if (tree.getCurrent().isAnimal()) {
                    System.out.println("I knew it!\nLet's play again!");
                    tree.setCurrent(tree.getRoot());
                } else {
                    inputString = "n";
                    switchFlag = true;
                }
            }
        }
        if (Objects.equals(inputString, "n")) {
            if (tree.getCurrent().getNoNode() != null && !switchFlag)
                tree.setCurrent(tree.getCurrent().getNoNode());
            else {
                System.out.println("Really? I have no idea then!\nWho is that youtuber?");
                var animalString = inputPrompt();
                System.out.println("Please enter a yes/no question for " + animalString + ":");
                var questionString = inputPrompt();
                if (!questionString.endsWith("?")) questionString += "?";
                System.out.println("And what would the answer be? (y/n)");
                var answerString = inputPrompt().toLowerCase(Locale.ROOT);
                while (!(Objects.equals(answerString, "y")) && !(Objects.equals(answerString, "n"))) {
                    System.out.println("Please enter y or n:");
                    answerString = inputPrompt().toLowerCase(Locale.ROOT);
                }
                var question = new QuestionNode(questionString);
                var animalQuestion = new QuestionNode("Is it a " + animalString + "?");
                animalQuestion.setAnimal(true);
                if (Objects.equals(answerString, "y")) question.setYesNode(animalQuestion);
                if (Objects.equals(answerString, "n")) question.setNoNode(animalQuestion);
                if (switchFlag) tree.getCurrent().setYesNode(question);
                else tree.getCurrent().setNoNode(question);
                System.out.println("Okay!\nLet's play again!");
                tree.setCurrent(tree.getRoot());
            }
        }

        mainLoop();
    }



}
