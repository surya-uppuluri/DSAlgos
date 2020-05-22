package surya.practice.geeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    /**
     * ----------
     * ALGORITHM
     * ----------
     * Left -> Root -> Right
     * =========================
     * Time Complexity - O(n)
     * Space Complexity - O(n) for the stack, where n is the max height of recursion tree
     * =========================
     *
     * @return
     */
    StringBuffer stringBuffer = new StringBuffer(" ");


    String inOrderTraversal(Node root) {


        if (root != null) {
            inOrderTraversal(root.left);
            stringBuffer.append(root.data).append(" ");
            System.out.println("Current in-order tree traversal: " + stringBuffer);
            inOrderTraversal(root.right);
        }

        return stringBuffer.toString();
    }

    public String preOrderTraversal(Node root) {
        if (root != null) {
            stringBuffer.append(root.data).append(" ");
            System.out.println("Current pre-order tree traversal: " + stringBuffer);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
        return stringBuffer.toString();

    }

    public String postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            stringBuffer.append(root.data).append(" ");
            System.out.println("Current post-order tree traversal: " + stringBuffer);
        }

        return stringBuffer.toString();
    }

    public String levelOrderTraversalIterative(Node root) {
        StringBuffer stringBuffer = new StringBuffer();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
            System.out.print(curr.data + " ");
            stringBuffer.append(curr.data).append(" ");
        }
        return stringBuffer.toString();
    }


    /**
     * WAY 1
     * ----------
     * ALGORITHM
     * ----------
     * 1.Append null to the first push
     * 2. If there's a null, it indicates the end of current level
     * 3. So, when there's a null encountered, push NULL so that End Of Level marker for next level is added.
     * 4. Where curr is not null, push curr's left and right nodes if they are not null
     * 4. Finally, when size becomes 1, it means queue has only null element left.
     * =========================
     * Time Complexity - O(n+h)= O(n), h = height, each level in height adds a null
     * Space Complexity - theta(width) or O(n)
     * =========================
     */

    public String levelOrderTraversalLineByLine(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size() > 1) {
            Node curr = queue.poll();
            //You have 2 cases now, element being null or a node
            if (curr == null) {
//                System.out.println();
                stringBuffer.append("\n");
                queue.add(null);
                continue;
            }
//            System.out.println(curr.data);
            stringBuffer.append(curr.data).append(" ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);

        }
        return stringBuffer.toString();
    }


    /**
     * WAY 2
     * ----------
     * ALGORITHM
     * ----------
     * 1. Use external loop to print new lines and loop over it till queue is non empty
     * 2. get the size of queue and iterate till size is done
     * 3. While doing so, if any child elements are encountered, push them to the queue as well
     * =========================
     * Time Complexity - O(n+h)= O(n), h = height, each level in height adds a null
     * Space Complexity - theta(width) or O(n)
     * =========================
     */

    public String levelOrderTraversalLineByLineUsingTwoLoops(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");
                stringBuffer.append(curr.data + " ");
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            System.out.println();
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public int getSizeIteratively(Node root) {
        int size = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            size++;
            Node curr = queue.poll();
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);

        }
        return size;
    }

    public int getSizeRecursively(Node root) {
        if (root == null) return 0;
        return 1 + getSizeRecursively(root.left) + getSizeRecursively(root.right);
    }

    public int getSizeTailRecursively(Node root, int i) {
        if (root == null) return 0;
        //TODO - Have to finish this
        return 0;
    }

    public int getMaxFromTree(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        else
            return Math.max((Integer) root.data, Math.max(getMaxFromTree(root.left), getMaxFromTree(root.right)));
    }

    public int getHeightOfTree(Node root) {
        if (root == null) return 0;
        else return Math.max(getHeightOfTree(root.left), getHeightOfTree(root.right)) + 1;
    }

    public void levelOrderTraversalRecursive(Node root) {

        //1.find height
        //2. for all levels in height, print each level

        int height = getHeightOfTree(root);
        System.out.println("Height is:" + height);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }

    }

    private void printGivenLevel(Node root, int level) {
        if (root == null) return;
        if (level == 1) System.out.print(root.data + " ");
        else {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }
}
