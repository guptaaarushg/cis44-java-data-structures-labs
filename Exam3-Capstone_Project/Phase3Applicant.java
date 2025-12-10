public class Phase3Applicant {
    private String name;
    private double income;
    private int creditScore;
    private double debt;

    public Phase3Applicant(String name, double income, int creditScore, double debt) {
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
