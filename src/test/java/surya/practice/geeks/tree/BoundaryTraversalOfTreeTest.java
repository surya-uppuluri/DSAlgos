package surya.practice.geeks.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class BoundaryTraversalOfTreeTest {


    @Test
    @DisplayName(" BoundaryTraversalOfTreeTest With 5 level manually constructed tree")
    public void TestThatTreeTraversalIsOverBoundaryElementsOnly() {
        BoundaryTraversalOfTree binaryTree = new BoundaryTraversalOfTree();
        Node root = getABinaryTreeWithRepresentation();
        log.info("The levelOrderTraversal of input tree is: {}", new BinaryTree().levelOrderTraversalLineByLine(root));
        //**======== 10 20 40 60 100 80 110 90 50 30 ========== **//
        assertEquals("[10, 20, 40, 60, 100, 80, 110, 90, 50, 30]", Arrays.toString(binaryTree.solve(root)));
    }

    @Test
    @DisplayName(" BoundaryTraversalOfTreeTest With 6 level tree  constructed  from string")
    public void TestTreeTraversalIsOverBoundaryElementsOnly() {
        BoundaryTraversalOfTree binaryTree = new BoundaryTraversalOfTree();
        Node root = getABinaryTreeFromInputString();
        log.info("The levelOrderTraversal of input tree is: {}", new BinaryTree().levelOrderTraversalLineByLine(root));
        assertEquals("[10, 20, 40, 70, 80, 110, 120, 100, 60, 30]", Arrays.toString(binaryTree.solve(root)));
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

    private Node getABinaryTreeFromInputString() {
        /*
         *
         *                     10
         *              /            \
         *             20             30
         *            /\            /  \
         *           N  40         50   60
         *              /\        /\    /\
         *            70 80      90 N  N 100
         *            /\  /\     / \  /  \
         *           N  N N N   110 N N   120
         *
         */
        CreateTreeFromPreOrderString createTreeFromLevelOrderString = new CreateTreeFromPreOrderString();
        return createTreeFromLevelOrderString.createTree("10 20 30 N 40 50 60 70 80 90 N N 100 N N N N 110 N N 120");

    }
}