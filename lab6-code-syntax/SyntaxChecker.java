import java.util.EmptyStackException;

interface Stack<E> {
    void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
}

class ArrayStack<E> implements Stack<E> {
    private E[] data;
    private int top = -1;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void push(E item) {
        if (top == data.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        data[++top] = item;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top--];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}

public class SyntaxChecker {

    public static boolean isBalanced(String line) {
        Stack<Character> buffer = new ArrayStack<>(line.length());
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                buffer.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (buffer.isEmpty()) {
                    return false;
                }
                char open = buffer.pop();
                if (!isMatchingPair(open, ch)) {
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }";
        String line2 = "int x = (5 + [a * 2]);";
        String line3 = "System.out.println('Hello');)";
        String line4 = "List list = new ArrayList<{String>();";
        String line5 = "if (x > 0) {";
        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}
