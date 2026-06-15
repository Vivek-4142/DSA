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
        List<List<Integer>> list2 = new ArrayList<>();
        if(root == null){
            return list2;
        }
       Queue<TreeNode> que = new LinkedList<>();
       que.offer(root);
       while(!que.isEmpty()){
        List<Integer> list = new ArrayList<>();
        int size = que.size();
        for(int i =0;i<size;i++){
            TreeNode temp = que.poll();
            list.add(temp.val);
            if(temp.left!= null){
                que.offer(temp.left);
            }
            if(temp.right!=null){
                que.offer(temp.right);
            }
        }
        list2.add(list);
       }

       return list2;
        

    }
}
