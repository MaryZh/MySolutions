public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        int n= nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            int start=i;
            while(i<n-1 && nums[i+1] == nums[i]){
                i++;
            }
            if(i-start+1 > n/3)
                res.add(nums[start]);
        }
        return res;
    }
}
