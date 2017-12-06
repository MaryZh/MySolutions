// based on Morris traveral for in-order

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode cur, pre;
    private int res;    // next value

    public BSTIterator(TreeNode root) {
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null;
    }

    /** @return the next smallest number */
    public int next() {
        while( cur != null){
            if(cur.left == null){
                res = cur.val;  // changed this line from inorder traversal
                cur = cur.right;
                break;
            }
            else{
                pre = cur.left;
                while(pre.right != null && pre.right != cur)    // find precedence node of cur
                    pre = pre.right;
                
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }
                else{
                    pre.right = null;  // recover the tree
                    res=cur.val;     // changed this line from inorder traversal
                    cur = cur.right;
                    break;
                }
            }
        }
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
