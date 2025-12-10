public class DecisionNode {
    private String attribute;
    private double threshold;
    private DecisionNode left;
    private DecisionNode right;
    private String decision;

    public DecisionNode(String decision) {
        this.decision = decision;
    }

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

    public boolean isLeaf() {
        return decision != null;
    }

    public String getDecision() {
        return decision;
    }
}
