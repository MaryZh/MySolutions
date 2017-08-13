// in-oder iterator

public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        pushLeft(root); // (1)
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();    // (2)
        pushLeft(node.right);   // (3)
        return node.val;    // (2)
    }
    // push in all the left nodes rooted at node(inclusive)
    private void pushLeft(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}
