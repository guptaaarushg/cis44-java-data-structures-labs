import java.util.Random;

public class Matrix {
    private int[][] data;

    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }

    public Matrix(int[][] data) {
        this.data = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, data[i].length);
        }
    }

    public void populateRandom() {
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = rand.nextInt(10) + 1;
            }
        }
    }

    public Matrix add(Matrix other) {
        if (other.data.length != data.length || other.data[0].length != data[0].length) {
            throw new IllegalArgumentException();
        }
        Matrix result = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (data[0].length != other.data.length) {
            throw new IllegalArgumentException();
        }
        Matrix result = new Matrix(data.length, other.data[0].length);
        for (int i = 0; i < result.data.length; i++) {
            for (int j = 0; j < result.data[0].length; j++) {
                for (int k = 0; k < data[0].length; k++) {
                    result.data[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : data) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}