package surya.practice.geeks.tree;


public class PrintLeftView {
    Node root;
    static int max_level = 0;

    void leftViewUtil(Node node, int level)
    {
        if (node == null) {
            return;
        }
        if (max_level < level) {
            System.out.print(" " + node.data);
            max_level = level;
        }

        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    void leftView()
    {
        leftViewUtil(root, 1);
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        PrintLeftView tree = new PrintLeftView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(4);
        tree.root.left.left = new Node(11);
        tree.root.left.left.right = new Node(15);
        tree.root.right.left = new Node(9);
        tree.root.right.right = new Node(3);

        tree.leftView();
    }
}