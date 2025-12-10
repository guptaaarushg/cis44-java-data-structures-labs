public class DecisionTree {
    private DecisionNode root;

    public DecisionTree(DecisionNode root) {
        this.root = root;
    }

    public String classify(Phase3Applicant app) {
        DecisionNode current = root;

        while (current != null) {
            if (current.isLeaf()) {
                return current.getDecision();
            }

            double value;
            switch (current.getAttribute().toLowerCase()) {
                case "income":
                    value = app.getIncome();
                    break;
                case "creditscore":
                    value = app.getCreditScore();
                    break;
                case "debt":
                    value = app.getDebt();
                    break;
                default:
                    return "Unknown attribute in tree";
            }

            if (value <= current.getThreshold()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        return "No decision reached";
    }
}
