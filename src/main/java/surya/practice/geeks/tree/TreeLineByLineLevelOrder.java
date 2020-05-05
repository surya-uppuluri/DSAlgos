package surya.practice.geeks.tree;/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC102. Binary Tree Level Order Traversal
 * Medium
 * <p>
 * 2550
 * <p>
 * 65
 * <p>
 * Add to List
 * <p>
 * Share
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * Accepted
 * 556.5K
 * Submissions
 * 1.1M
 *//*
Runtime: 1 ms, faster than 56.29% of Java online submissions for Binary Tree Level Order Traversal.
        Memory Usage: 39.7 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.*/
class LineByLinePrint {
    public List<List<Integer>> levelOrderWithIntMinAsDelimiter(TreeNode root) {

        List result = new ArrayList<>();
        if (root == null) return new ArrayList<>(new ArrayList<>());

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        q.add(new TreeNode(Integer.MIN_VALUE));
        while (!q.isEmpty() && q.peek().val != Integer.MIN_VALUE) {
            ArrayList<Integer> currLev = new ArrayList();
            assert q.peek() != null;
            while (q.peek().val != Integer.MIN_VALUE) {
                TreeNode currRoot = q.poll();
                currLev.add(currRoot.val);
                if (currRoot.left != null) q.add(currRoot.left);
                if (currRoot.right != null) q.add(currRoot.right);
            }
            q.poll();
            q.add(new TreeNode(Integer.MIN_VALUE));

            result.add(currLev);
        }
        return result;
    }

    /*
    Runtime: 1 ms, faster than 56.29% of Java online submissions for Binary Tree Level Order Traversal.
    Memory Usage: 40.4 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.
     */
    public List<List<Integer>> levelOrderWithoutDelimiter(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        ArrayList<Integer> eachList = new ArrayList<>();
        List<List<Integer>> resList = new ArrayList<>();
        while (true) {
            TreeNode treeNode = queue.poll();

            if (treeNode == null) {
                if (eachList.size() > 0) {
                    resList.add(eachList);
                    eachList = new ArrayList<>();
                    queue.add(null); /* This is the crucial part of this approach **/
                } else {
                    //in the final iteration where all elements are null in the queue, quit the loop
                    break;
                }
            } else {
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
                eachList.add(treeNode.val);
            }

        }
        return resList;
    }

    /**
     * Runtime: 1 ms, faster than 56.29% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 41 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.
     * @param root
     * @return
     */
    public List<List<Integer>> withClassicLevelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>(new ArrayList());

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                currLevel.add(node.val);
            }
            res.add(currLevel);
        }
        return res;
    }
}

public class TreeLineByLineLevelOrder {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<List<Integer>> withIntMinAsDelimiter = new LineByLinePrint().levelOrderWithIntMinAsDelimiter(root);
            List<List<Integer>> withOutADelimiter = new LineByLinePrint().levelOrderWithoutDelimiter(root);
            List<List<Integer>> withClassicLevelOrder = new LineByLinePrint().withClassicLevelOrder(root);

            String outWithIntMinAsDelimiter = int2dListToString(withIntMinAsDelimiter);
            String outwithOutADelimiter = int2dListToString(withOutADelimiter);
            String classicLevelOrder = int2dListToString(withClassicLevelOrder);

            System.out.println("outWithIntMinAsDelimiter " + outWithIntMinAsDelimiter);
            System.out.println("outwithOutADelimiter " + outwithOutADelimiter);
            System.out.println("classicLevelOrder" + classicLevelOrder);

        }
    }
}