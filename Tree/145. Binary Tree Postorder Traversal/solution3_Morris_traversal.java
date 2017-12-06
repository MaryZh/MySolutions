// Morris traversal - for each subtree, visit left nodes first; then reverse (node -> right node) so that can retrieve right node before node

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> res = new ArrayList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode cur = dummy, pre;
        while (cur != null){
            if (cur.left == null){
                cur = cur.right;
            }
            else{
                pre = cur.left;
                while (pre.right != null && pre.right != cur)
                    pre = pre.right;

                if (pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }
                else{
                    // System.out.println("cur = "+cur.val + ", pre = "+pre.val);
                    printReverse(cur.left, pre);  // call print
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
    
    // reverse the tree nodes 'from' -> 'to'
    private void reverse(TreeNode from, TreeNode to){
        // System.out.println("from = "+from.val + ", to = "+to.val);
        if (from == to)
            return;
        TreeNode x = from, y = from.right, temp;
        while (true){
            temp = y.right;
            y.right = x;
            x = y;
            y = temp;
            if (x == to)
                break;
        }
    }

    // print the reversed tree nodes 'from' -> 'to'
    private void printReverse(TreeNode from, TreeNode to){ 
        reverse(from, to);

        TreeNode p = to;
        while (true){
            res.add(p.val);
            if (p == from)
                break;
            p = p.right;
        }

        reverse(to, from);
    }
}
