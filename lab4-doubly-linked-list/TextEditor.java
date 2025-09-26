public class TextEditor {
    private static class Node {
        String textState;
        Node prev;
        Node next;

        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }

    public void add(String newText) {
        String updatedText = currentNode.textState + newText;
        currentNode.next = null;
        Node newNode = new Node(updatedText, currentNode, null);
        currentNode.next = newNode;
        currentNode = newNode;
    }

    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
            return currentNode.textState;
        } else {
            System.out.println("Cannot undo.");
            return currentNode.textState;
        }
    }

    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
            return currentNode.textState;
        } else {
            System.out.println("Cannot redo.");
            return currentNode.textState;
        }
    }

    public void printCurrent() {
        System.out.println("Current Text: \"" + currentNode.textState + "\"");
    }
}