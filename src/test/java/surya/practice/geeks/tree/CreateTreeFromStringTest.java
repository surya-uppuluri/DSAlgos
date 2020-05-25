package surya.practice.geeks.tree;

import org.junit.jupiter.api.Test;

class CreateTreeFromStringTest {

    @Test
    void createTree() {

        CreateTreeFromString createTreeFromString = new CreateTreeFromString();
        System.out.println(inOrder(createTreeFromString.createTree("1 2 3 N N 4 6 N 5 N N 7 N"), ""));
    }

    private String inOrder(Node node, String resp) {
        if (node == null) return resp;
        inOrder(node.left, resp+" "+node.val);
        inOrder(node.right, resp+" "+node.val);

        return resp;
    }
}