package surya.practice.geeks.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoundaryTraversalOfTreeTest {


    @Test
    @DisplayName(" BoundaryTraversalOfTreeTest")
    public void TestThatTreeTraversalIsOverBoundaryElementsOnly() {
        BoundaryTraversalOfTree binaryTree = new BoundaryTraversalOfTree();
        Node root = getABinaryTreeWithRepresentation();
        //**======== 10 20 40 60 100 80 110 90 50 30 ========== **//
        assertEquals("[10, 20, 40, 60, 100, 80, 110, 90, 50, 30]", Arrays.toString(binaryTree.solve(root)));
    }


    private Node getABinaryTreeWithRepresentation() {
        /**
         *
         *                10
         *              /   \
         *             20   30
         *            /\     /\
         *           X  40  50 X
         *              /\   /\
         *            60 70 80 90
         *               /      \
         *             100      110
         *
         */


        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.right = new Node(40);
        root.left.right.left = new Node(60);
        root.left.right.right = new Node(70);
        root.left.right.right.left = new Node(100);

        root.right.left = new Node(50);
        root.right.left.left = new Node(80);
        root.right.left.right = new Node(90);
        root.right.left.right.left = new Node(110);
        return root;
    }
}