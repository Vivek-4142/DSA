class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = giveList(root);
        return list.get(k - 1);
    }

    public List<Integer> giveList(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list; 
        }

        List<Integer> left = giveList(root.left);
        List<Integer> right = giveList(root.right);

        list.addAll(left);   
        list.add(root.val);  
        list.addAll(right);  

        return list;
    }
}

// In BST inorder traversal gives sorted order of elements. So we can do inorder traversal and store the elements in a list and return the kth element from the list.
// if our return type is list integer than in left right it will save trree node value not trre node directly
