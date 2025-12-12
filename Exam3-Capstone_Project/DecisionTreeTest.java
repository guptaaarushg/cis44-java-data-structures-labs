public class DecisionTreeTest {

    private DecisionTree buildSampleTree() {
        DecisionNode root = new DecisionNode("income", 60000);
        DecisionNode lowIncome = new DecisionNode("Reject");
        DecisionNode highIncome = new DecisionNode("creditscore", 650);
        DecisionNode lowCredit = new DecisionNode("Review");
        DecisionNode highCredit = new DecisionNode("Approve");

        root.setLeft(lowIncome);
        root.setRight(highIncome);
        highIncome.setLeft(lowCredit);
        highIncome.setRight(highCredit);

        return new DecisionTree(root);
    }

    private void runTest(String label, boolean condition) {
        System.out.println(label + ": " + (condition ? "PASS" : "FAIL"));
    }

    public void testNormalCase() {
        DecisionTree tree = buildSampleTree();
        Phase3Applicant app = new Phase3Applicant("John", 75000, 720, 10000);
        boolean result = tree.classify(app).equals("Approve");
        runTest("Normal Case", result);
    }

    public void testEmptyCase() {
        DecisionTree tree = new DecisionTree(null);
        Phase3Applicant app = new Phase3Applicant("Sam", 50000, 650, 5000);
        boolean result = tree.classify(app).equals("No decision reached");
        runTest("Empty Case", result);
    }

    public void testEdgeCaseInvalidAttribute() {
        DecisionNode badRoot = new DecisionNode("notReal", 10);
        badRoot.setLeft(new DecisionNode("Reject"));
        badRoot.setRight(new DecisionNode("Approve"));
        DecisionTree tree = new DecisionTree(badRoot);
        Phase3Applicant app = new Phase3Applicant("Alex", 60000, 700, 10000);
        boolean result = tree.classify(app).equals("Unknown attribute in tree");
        runTest("Edge Case (Invalid Attribute)", result);
    }

    public static void main(String[] args) {
        DecisionTreeTest t = new DecisionTreeTest();
        t.testNormalCase();
        t.testEmptyCase();
        t.testEdgeCaseInvalidAttribute();
        System.out.println("ALL TESTS COMPLETED");
    }
}
