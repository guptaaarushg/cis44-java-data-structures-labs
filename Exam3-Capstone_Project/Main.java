public class Main {
    public static void main(String[] args) {

        DecisionNode root = new DecisionNode("income", 60000);
        DecisionNode lowIncome = new DecisionNode("Reject");
        DecisionNode highIncome = new DecisionNode("creditscore", 650);
        DecisionNode lowCredit = new DecisionNode("Review");
        DecisionNode highCredit = new DecisionNode("Approve");

        root.setLeft(lowIncome);
        root.setRight(highIncome);
        highIncome.setLeft(lowCredit);
        highIncome.setRight(highCredit);

        DecisionTree tree = new DecisionTree(root);

        Phase3Applicant normalApp = new Phase3Applicant("John", 75000, 720, 15000);
        String result1 = tree.classify(normalApp);
        System.out.println("Normal Case: " + (result1.equals("Approve") ? "PASS" : "FAIL"));

        DecisionTree emptyTree = new DecisionTree(null);
        String result2 = emptyTree.classify(normalApp);
        System.out.println("Empty Case: " + (result2.equals("No decision reached") ? "PASS" : "FAIL"));

        DecisionNode badRoot = new DecisionNode("banana", 10);
        badRoot.setLeft(new DecisionNode("Reject"));
        badRoot.setRight(new DecisionNode("Approve"));
        DecisionTree badTree = new DecisionTree(badRoot);

        String result3 = badTree.classify(normalApp);
        System.out.println("Edge Case (Invalid Attribute): " +
                (result3.equals("Unknown attribute in tree") ? "PASS" : "FAIL"));
    }
}
