public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode l, TreeNode r) {
        this.val = val;
        this.left = l;
        this.right = r;
    }

    @Override public String toString() {
        String l = left == null ? "Leaf" : String.valueOf(left.val);
        String r = right == null ? "Leaf" : String.valueOf(right.val);
        // return String.format("[%s <- %d -> %s]", l, val, r);
        return String.format("(%d)", val);
    }
}
