// an optimization over mysolution

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res =  new ArrayList<>();
        int n = nums.length;
       
        for(int i=0; i<n; i++){
            int start =i;
            while(i<n-1 && nums[i+1]-nums[i]==1){
                i++;
            }
            if(nums[i] != nums[start])
                res.add(nums[start] +"->"+nums[i]);
            else
                res.add(nums[start]+"");
        }
        
        return res;
    }
}
