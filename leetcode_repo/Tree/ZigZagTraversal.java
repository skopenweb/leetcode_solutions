import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false; // Flag to determine the order
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>(); // Using LinkedList for efficient insertion

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (zigzag) {
                    level.addFirst(node.val); // Insert at the beginning for reverse order
                } else {
                    level.addLast(node.val); // Insert at the end for normal order
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
            zigzag = !zigzag; // Flip the flag for the next level
        }

        return result;
    }

    void bfs(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            System.out.print(" "+n.val);
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ZigZagTraversal traversal = new ZigZagTraversal();
        List<List<Integer>> result = traversal.zigzagLevelOrder(root);

        // Print the result
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
