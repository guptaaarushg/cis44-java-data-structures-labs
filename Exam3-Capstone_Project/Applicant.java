public class Applicant {
    private String name;
    private double income;
    private int creditScore;
    private double debt;

    public Applicant(String name, double income, int creditScore, double debt) {
        this.name = name;
        this.income = income;
        this.creditScore = creditScore;
        this.debt = debt;
    }

    public String getName() {
        return name;
    }

    public double getIncome() {
        return income;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getDebt() {
        return debt;
    }
}

public class DecisionNode {
    private String attribute;
    private double threshold;
    private DecisionNode left;
    private DecisionNode right;

    public DecisionNode(String attribute, double threshold) {
        this.attribute = attribute;
        this.threshold = threshold;
    }

    public String getAttribute() {
        return attribute;
    }

    public double getThreshold() {
        return threshold;
    }

    public DecisionNode getLeft() {
        return left;
    }

    public void setLeft(DecisionNode left) {
        this.left = left;
    }

    public DecisionNode getRight() {
        return right;
    }

    public void setRight(DecisionNode right) {
        this.right = right;
    }
}

public class DecisionTree {
    private DecisionNode root;

    public DecisionTree(DecisionNode root) {
        this.root = root;
    }

    public String classify(Applicant app) {
        DecisionNode current = root;
        while (current != null) {
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
                    return "Unknown";
            }
            if (value <= current.getThreshold()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return "Decision reached";
    }
}
