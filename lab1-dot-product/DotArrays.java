import java.util.Random;

public class DotArrays {
    public static void main(String[] args) {
        
        int n = 5;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        Random r = new Random();

        
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10); 
            b[i] = r.nextInt(10);
        }

        
        for (int i = 0; i < n; i++) {
            c[i] = a[i] * b[i];
        }

        
        System.out.print("a: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.print("b: ");
        for (int i = 0; i < n; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        System.out.print("c: ");
        for (int i = 0; i < n; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
    }
}

