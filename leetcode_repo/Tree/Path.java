import java.util.*;

public class Path {

    void printPathToLeaf(TreeNode n) {
        traverse(n, new ArrayList<TreeNode>());
    }

    void traverse(TreeNode n, List<TreeNode> path) {
        path.add(n);
        if (n.left  == null && n.right == null) {
            printPathfromRoot(path);
        } else {
            if (n.left != null) {
                traverse(n.left, path);
            }
            if (n.right != null) {
                traverse(n.right, path);
            }    
        }
        path.remove(n);
    }

    void printPathfromRoot(List<TreeNode> path) {
        System.out.print("Path:\t");
        for (TreeNode a: path) {
            System.out.print(a.val+ "->");
        }
        System.out.println("Leaf");
    }

    public static void main(String[] args) {
        TreeNode l11 = new TreeNode(11);
        TreeNode l12 = new TreeNode(12);
        TreeNode l1 = new TreeNode(10, l11, l12);

        TreeNode r11 = new TreeNode(31);
        TreeNode r12 = new TreeNode(32);
        TreeNode r1 = new TreeNode(30, r11, r12);
        
        TreeNode root = new TreeNode(20, l1, r1);

        new Path().traverse(root,  new LinkedList<TreeNode>());
    }
}