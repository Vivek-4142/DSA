class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> list2 = new ArrayList<>();
            int size = que.size();
            for(int i =0;i<size;i++){
                TreeNode temp = que.poll();
                list2.add(temp.val);
                if(temp.left != null){
                que.offer(temp.left);
                }
                if(temp.right != null){
                que.offer(temp.right);
                }
            }
            list.add(list2.get(list2.size()-1));

        }

        return list;
    }
}


// we solve this BFS problem by using a queue to traverse the tree level by level. For each level, we keep track of the last node's value and add it to the result list. This way, we can get the right side view of the binary tree.
//ArrayList is very usefull than normal array we can get traverse any element in arraylist by using index and we can add or remove any element from arraylist.