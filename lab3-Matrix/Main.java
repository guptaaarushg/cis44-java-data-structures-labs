public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(2, 3);
        Matrix m2 = new Matrix(2, 3);

        m1.populateRandom();
        m2.populateRandom();

        System.out.println("Matrix 1: " + m1);
        System.out.println("Matrix 2: " + m2);

        try {
            Matrix sum = m1.add(m2);
            System.out.println("Sum: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot add matrices of different dimensions.");
        }

        Matrix m3 = new Matrix(3, 2);
        m3.populateRandom();
        System.out.println("Matrix 3: " + m3);

        try {
            Matrix product = m1.multiply(m3);
            System.out.println("Product: " + product);
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot multiply these matrices.");
        }

        try {
            m1.add(m3);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: Cannot add matrices of different dimensions.");
        }

        try {
            m2.multiply(m2);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: Cannot multiply these matrices.");
        }
    }
}
