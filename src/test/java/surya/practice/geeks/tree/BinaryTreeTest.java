package surya.practice.geeks.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {

    @Test
    @DisplayName(" In-order traversal of Binary Tree - Positive Test")
    void inOrderTraversal() {
        Node root = getABinaryTreeWithSize5();
        BinaryTree binaryTree = new BinaryTree();
        String traversal = binaryTree.inOrderTraversal(root);
        assertEquals(" 20 10 40 30 50 ", traversal);
    }


    @Test
    @DisplayName(" Pre-order traversal of Binary Tree - Positive Test")
    void preOrderTraversal() {
        Node root = getABinaryTreeWithSize5();
        BinaryTree binaryTree = new BinaryTree();
        String traversal = binaryTree.preOrderTraversal(root);
        assertEquals(" 10 20 30 40 50 ", traversal);
    }


    @Test
    @DisplayName(" Post-order traversal of Binary Tree - Positive Test")
    void postOrderTraversal() {
        Node root = getABinaryTreeWithSize5();
        BinaryTree binaryTree = new BinaryTree();
        String traversal = binaryTree.postOrderTraversal(root);
        assertEquals(" 20 40 50 30 10 ", traversal);
    }


    @Test
    @DisplayName(" Level-order traversal of Binary Tree - Positive Test")
    void levelOrderTraversalIterative() {
        Node root = getABinaryTreeWithSize5();
        BinaryTree binaryTree = new BinaryTree();
        String traversal = binaryTree.levelOrderTraversalIterative(root);
        assertEquals("10 20 30 40 50 ", traversal);
    }

    @Test
    @DisplayName(" Level-order traversal of Binary Tree - Positive Test")
    void levelOrderTraversalRecursive() {
        Node root = getABinaryTreeWithSize5();
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.levelOrderTraversalRecursive(root);
        //assertEquals("10 20 30 40 50 ", traversal);
    }


    @Test
    @DisplayName(" LineByLine Level Order Traversal - Way1 Test")
    public void TestThatLevelOrderLineByLineTraversalWay1Works() {
        Node root = getABinaryTreeWithSize5();
        BinaryTree binaryTree = new BinaryTree();
        String traversal = binaryTree.levelOrderTraversalLineByLine(root);
        assertEquals(" 10 \n" +
                "20 30 \n" +
                "40 50 ", traversal);


    }

    @Test
    @DisplayName(" LineByLine Level Order Traversal - Way2 Test")
    void levelOrderTraversalLineByLineUsingTwoLoops() {
        Node root = getABinaryTreeWithSize5();
        BinaryTree binaryTree = new BinaryTree();
        String traversal = binaryTree.levelOrderTraversalLineByLineUsingTwoLoops(root);
        assertEquals(" 10 \n" +
                "20 30 \n" +
                "40 50 \n", traversal);
    }

    @Test
    @DisplayName(" FindingSizeOfTree - Iterative Test")
    public void TestThatFindingSizeOfTreeWorksIteratively() {
        Node root = getABinaryTreeWithSize5();
        BinaryTree binaryTree = new BinaryTree();
        assertEquals(5, binaryTree.getSizeIteratively(root));
        ;
    }

    @Test
    @DisplayName(" FindingSizeOfTree - Recursive Test")
    public void TestThatFindingSizeOfTreeWorksRecursively() {
        Node root = getABinaryTreeWithSize5();
        BinaryTree binaryTree = new BinaryTree();
        assertEquals(5, binaryTree.getSizeRecursively(root));
        ;
    }

    @Test
    @DisplayName(" FindingSizeOfTree - Tail Recursive Test")
    public void TestThatFindingSizeOfTreeWorksTailRecursively() {
/*        Node root = getABinaryTreeWithSize5();
        BinaryTree binaryTree = new BinaryTree();
        assertEquals(5, binaryTree.getSizeTailRecursively(root, 0));*/

    }


    @Test
    @DisplayName(" MaximumInATree -  Test")
    public void TestThatMaximumInATreeWorks() {
        BinaryTree binaryTree = new BinaryTree();
        Node root = getABinaryTreeWithSize5();

        assertEquals(50, binaryTree.getMaxFromTree(root));
    }


    @Test
    @DisplayName(" HeightOfTree -  Test")
    public void TestThatHeightOfATreeWorks() {
        BinaryTree binaryTree = new BinaryTree();
        Node root = getABinaryTreeWithSize5();
        assertEquals(3, binaryTree.getHeightOfTree(root));
    }


    private Node getABinaryTreeWithSize5() {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        return root;
    }
}