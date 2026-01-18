/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while(queue.size()>0) {
            int size = queue.size();
            List<Integer> temp = new ArrayList();
            while(size>0) {
                TreeNode cur = queue.poll();
                if(cur.left!=null) {
                    queue.add(cur.left);
                }

                if(cur.right!=null) {
                    queue.add(cur.right);
                }
                temp.add(cur.val);
                size--;
            }

            if(temp.size()>0) {
                ans.add(temp);
            }
        }
        return ans;
    }
}