// linear scan

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res =  new ArrayList<>();
        int n = nums.length;
        if(n==0)
            return res;
        if(n==1){
            res.add(nums[0]+"");
            return res;
        }
            
        int start =0;
        int i=0;
        for(i=0; i<n-1; i++){
            if(nums[i+1]-nums[i]!=1){
                if(i>start)
                    res.add(nums[start] +"->"+nums[i]);
                else
                    res.add(nums[start]+"");
                start = i+1;
            }
        }
        if(nums[n-1]-nums[n-2] == 1)
            res.add(nums[start] +"->"+nums[n-1]);
        else
            res.add(nums[n-1]+"");
        return res;
    }
}
