public class TwoFourTreeDriver {
    public static void main(String[] args) {

        TwoFourTree tree = new TwoFourTree();

        int[] nums = {12, 50, 5, 7, 20, 60, 15, 80, 30, 40, 25, 90, 100};

        for (int x : nums) tree.insert(x);

        System.out.print("Inorder: ");
        tree.inorder();

        System.out.println("Expected: 5 7 12 15 20 25 30 40 50 60 80 90 100");
    }
}
