package surya.practice.geeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CreateTreeFromString {

    public Node createTree(String s) {
        String[] nodes = s.split(" ");
        int i = 0;
        Node root = new Node(Integer.parseInt(nodes[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        i++;
        while (queue.size() > 0 && i < nodes.length) {
            Node curr = queue.poll(); //poll = peek+remove
            handleLeft(nodes[i], queue, curr);
            i++;
            if (i > nodes.length) break;
            handleRight(nodes[i], queue, curr);
            i++;
        }
        return root;
    }

    private void handleRight(String node, Queue<Node> queue, Node curr) {
        if (!(node.equals("N"))) {
            curr.right = new Node(Integer.parseInt(node));
            queue.add(curr.right);
        }
    }

    private void handleLeft(String node, Queue<Node> queue, Node curr) {

        if (!node.equals("N")) {
            curr.left = new Node(Integer.parseInt(node));
            queue.add(curr.left);
        }
    }
}
