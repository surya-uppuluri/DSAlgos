package surya.practice.geeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder("");
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node!=null)
            {
                sb.append(node.val).append("/");
                q.offer(node.left);
                q.offer(node.right);
            }
            else
            {
                sb.append("null").append("/");
            }
        }
        return sb.toString().substring(0, sb.toString().length()-1);
      
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
   
        String[] dats = data.split("/");
        Queue<TreeNode> q = new LinkedList<>();
      if (dats.length == 0) {
        return null;
      }
        TreeNode root = getNode(0,dats);
        q.offer(root);
        int i =0;
        int len = dats.length;
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            i++;
            if(i<len)
            {
                TreeNode left = getNode(i,dats);
                if(left!=null)
                {
                    q.offer(left);
                }
                curr.left = left;
            }
            i++;
               if(i<len)
            {
                TreeNode right = getNode(i,dats);
                if(right!=null)
                {
                    q.offer(right);
                }
                curr.right = right;
            }
        }
        return root;
    }
    
    public TreeNode getNode(int index, String[] dats)
    {
      if (dats[index].equals("null")) {
        return null;
      } else {
        return new TreeNode(Integer.parseInt(dats[index]));
      }
    }
}
