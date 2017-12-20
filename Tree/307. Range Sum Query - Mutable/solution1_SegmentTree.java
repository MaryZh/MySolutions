// segment tree: array implementation
// initilization: time O(n), space O(n)
// sumRange/update: time O(log n), space O(1)

class NumArray {
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        n=nums.length;
        if(n>0){
            tree=new int[2*n-1];    // n leaves, plus n-1 internal nodes
            // build tree
            // leaves stored at n-1 to 2*n-2
            for(int i=n-1; i<2*n-1; i++)
                tree[i]=nums[i-(n-1)];
            // internal nodes stored at 0 to n-2, parent[i]=leftchild[2*i+1]+rightchild[2*i+2]
            for(int i=n-2;i>=0;i--)
                tree[i]=tree[2*i+1]+tree[2*i+2];
        }
    }
    
    public void update(int i, int val) {
        // nodes that contain i(one per level) should be updated; so time complexity is O(h), h=tree height
        // update leave
        i += n-1;
        tree[i]=val;
        // update parents; i is either a left/right child of a parent
        while(i>0){ // i=0 is the root, which is not any one's child, so only need to loop over i>0
            int left=i;
            int right=i;
            if(i%2 == 1)    // that means i is left child, parent is (i-1)/2
                right = i+1;
            else    // i is right child, parent is (i-2)/2 = (i-1)/2
                left = i-1;
            // update parent
            tree[(i-1)/2]=tree[left]+tree[right];
            i = (i-1)/2;
        }
        // for(int k=0; k<2*n-1; k++)
        //     System.out.print(tree[k]+" ");
    }
    
    public int sumRange(int i, int j) {
        // if i is left child of a parent, go to parent; if i is right child of a parent, go to node to the right of parent
        // if j is right ...; if j is left ... , ... left ...
        int sum=0;
        i += n-1;
        j += n-1;
        while(i<=j){
            // System.out.println("i= "+i+", j="+j);
            if(i%2==0){  // i is right child
                sum += tree[i];
                i ++;
            }
            if(j%2==1){  // j is left child
                sum += tree[j];
                j --;
            }
            i = i>=1 ? (i-1)/2: -1;
            j = j>=1? (j-1)/2: -1;
            // i = (i-1)/2;
            // j = (j-1)/2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
