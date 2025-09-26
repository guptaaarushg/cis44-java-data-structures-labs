import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;

        do {
            System.out.println("\n=============== Text Editor ===============");
            System.out.println("1. Add text to editor");
            System.out.println("2. Undo action");
            System.out.println("3. Redo action");
            System.out.println("4. Print current text already in the Editor");
            System.out.println("5. Exit from the amazing Text Editor");
            System.out.print("Enter a number: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text to add: ");
                    String text = scanner.nextLine();
                    editor.add(text);
                    editor.printCurrent();
                    break;
                case 2:
                    editor.undo();
                    editor.printCurrent();
                    break;
                case 3:
                    editor.redo();
                    editor.printCurrent();
                    break;
                case 4:
                    editor.printCurrent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
