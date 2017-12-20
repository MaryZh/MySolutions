// Binary Indexed tree - array implementation
// initialization: time O(n log n), space O(n)
// sumRange/update: time O(log n), space O(1)

class NumArray {
    private int[] nums;
    private int[] tree;
    private int n;  // size of nums

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        // initialize tree, 1-indexed
        tree = new int[n+1];
        for(int i=0; i<n; i++)
            add(i, nums[i]);
    }
    
    // add number at index i with value val to the tree
    private void add(int i, int val){
        i++;    // 1-indexed tree
        while(i<=n){
            tree[i] += val;
            i += (i & -i);  // (i & -i) extracts the last 1-bit of i, then add it from i
        }
    }
    // update number at index i to val
    public void update(int i, int val) {
        int dif = val-nums[i];
        // update nums, here actually we only want sumRange, then updating tree is enough
        nums[i] = val;
        // update tree
        add(i, dif);
    }
    // find range sum (1, i), assuming nums is 1-indexed
    private int sum(int i){
        int result=0;
        i++;    // 1-indexed tree
        while(i>0){
            result += tree[i];
            i -= (i & -i);  // subtract last 1-bit of i
        }
        return result;
    }
    
    public int sumRange(int i, int j) {
        return sum(j)-sum(i-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
