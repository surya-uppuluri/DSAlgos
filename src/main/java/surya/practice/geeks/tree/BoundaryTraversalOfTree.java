package surya.practice.geeks.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Boundary Traversal Of Binary Tree
 * Given a binary tree. Given a binary tree, return the values of its boundary in anti-clockwise direction starting from the root.
 * Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
 * <p>
 * Left boundary is defined as the path from the root to the left-most node.
 * Right boundary is defined as the path from the root to the right-most node.
 * If the root doesn’t have left subtree or right subtree, then the root itself is left boundary or right boundary.
 * Note this definition only applies to the input binary tree, and not applies to any subtrees.
 * <p>
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 * <p>
 * The right-most node is also defined by the same way with left and right exchanged.
 * <p>
 * Return an array of integers denoting the boundary values of tree in anti-clockwise order.
 * <p>
 * For Example
 * <p>
 * Input 1:
 * _____1_____
 * /           \
 * 2             3
 * / \            /
 * 4   5          6
 * / \        / \
 * 7   8      9  10
 * Output 1:
 * [1, 2, 4, 7, 8, 9, 10, 6, 3]
 * Explanation 1:
 * The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 * The leaves are node 4,7,8,9,10.
 * The right boundary are node 1,3,6,10. (10 is the right-most node).
 * So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 * <p>
 * Input 2:
 * 1
 * / \
 * 2   3
 * / \  / \
 * 4   5 6  7
 * Output 2:
 * [1, 2, 4, 5, 6, 7, 3]
 **/

public class BoundaryTraversalOfTree {
    List<Integer> res = new ArrayList<>();

    public int[] solve(Node A) {
        if (A == null) return new int[0];
        res.add(A.val);
        leftB(A.left);
        leaves(A.left);
        leaves(A.right);
        rightB(A.right);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void leftB(Node a) {
        if (a == null) return;
        if (a.left != null) {
            res.add(a.val);
            leftB(a.left);
        } else if (a.right != null) {
            res.add(a.val);
            leftB(a.right);
        }
    }

    public void leaves(Node a) {
        if (a == null) return;
        leaves(a.left);

        if (a.left == null && a.right == null) {
            res.add(a.val);
        }
        leaves(a.right);
    }

    public void rightB(Node a) {
        if (a == null) return;
        if (a.right != null) {
            rightB(a.right);
            res.add(a.val);
        } else if (a.left != null) {
            rightB(a.left);
            res.add(a.val);
        }
    }
}
