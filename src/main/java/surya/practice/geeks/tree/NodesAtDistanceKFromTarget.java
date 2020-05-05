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
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;Stoc
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class PrintAtLevel {
    List<Integer> res = new ArrayList();
    public List<Integer> distanceK
            (TreeNode root, TreeNode target, int dist) {
        printGivenLevel(target, dist, target);
        printGivenLevel(root, dist-1, target);
        return res;
    }

    void printGivenLevel(TreeNode target, int dist, TreeNode actual)
    {
        if(target==null) return;
        if(dist==0) {if(target.val!=actual.val) {res.add(target.val);}}
        else{
            printGivenLevel(target.left, dist-1, actual);
            printGivenLevel(target.right, dist-1,actual);
        }
    }

    int findDistance(TreeNode root, TreeNode target, int dist)
    {
        if(root == null) return 0;
        if(root == target) {
            //System.out.println("Returning dist as:"+ dist);
            return dist;
        }
        else
            findDistance(root.left, target, dist+1);
        findDistance(root.right, target, dist+1);
        return 0;
    }
}


    public class NodesAtDistanceKFromTarget {
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

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                TreeNode root = stringToTreeNode(line);
                line = in.readLine();
                int target = Integer.parseInt(line);
                line = in.readLine();
                int K = Integer.parseInt(line);

                List<Integer> ret = new PrintAtLevel().distanceK(root, new TreeNode(target), K);

                String out = integerArrayListToString(ret);

                System.out.print(out);
            }
        }
    }