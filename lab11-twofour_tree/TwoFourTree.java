import java.util.ArrayList;
import java.util.Collections;

class TwoFourNode {
    ArrayList<Integer> vals;
    ArrayList<TwoFourNode> kids;
    TwoFourNode up;

    public TwoFourNode() {
        vals = new ArrayList<>();
        kids = new ArrayList<>();
        up = null;
    }

    boolean leaf() {
        return kids.size() == 0;
    }

    void addVal(int x) {
        vals.add(x);
        Collections.sort(vals);
    }

    TwoFourNode pick(int x) {
        int i = 0;
        while (i < vals.size() && x > vals.get(i)) i++;
        return kids.get(i);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int x) {
        TwoFourNode n = root;
        while (!n.leaf()) n = n.pick(x);

        n.addVal(x);

        while (n.vals.size() == 4) n = doSplit(n);
    }

    private TwoFourNode doSplit(TwoFourNode n) {

        int leftA = n.vals.get(0);
        int leftB = n.vals.get(1);
        int rightA = n.vals.get(2);
        int rightB = n.vals.get(3);

        int promote = leftB;

        TwoFourNode L = new TwoFourNode();
        TwoFourNode R = new TwoFourNode();

        L.vals.add(leftA);
        R.vals.add(rightA);
        R.vals.add(rightB);

        if (!n.leaf()) {
            L.kids.add(n.kids.get(0));
            L.kids.add(n.kids.get(1));
            R.kids.add(n.kids.get(2));
            R.kids.add(n.kids.get(3));
            R.kids.add(n.kids.get(4));

            for (TwoFourNode c : L.kids) c.up = L;
            for (TwoFourNode c : R.kids) c.up = R;
        }

        if (n.up == null) {
            TwoFourNode nr = new TwoFourNode();
            nr.vals.add(promote);
            nr.kids.add(L);
            nr.kids.add(R);
            L.up = nr;
            R.up = nr;
            root = nr;
            return nr;
        }

        TwoFourNode p = n.up;
        p.addVal(promote);

        int pos = p.vals.indexOf(promote);
        p.kids.remove(n);
        p.kids.add(pos, L);
        p.kids.add(pos + 1, R);

        L.up = p;
        R.up = p;

        return p;
    }

    public void inorder() {
        walk(root);
        System.out.println();
    }

    private void walk(TwoFourNode n) {
        if (n.leaf()) {
            for (int v : n.vals) System.out.print(v + " ");
            return;
        }

        for (int i = 0; i < n.vals.size(); i++) {
            walk(n.kids.get(i));
            System.out.print(n.vals.get(i) + " ");
        }
        walk(n.kids.get(n.kids.size() - 1));
    }
}
