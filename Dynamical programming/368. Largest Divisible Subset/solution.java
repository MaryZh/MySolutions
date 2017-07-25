public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        List<Integer> res =  new ArrayList<>();
        if(n==0)
            return res;
        
        Arrays.sort(nums);
        
        int[] len = new int[n];  // the length of largestDivisibleSubset ending at i-th element
        int[] prelast = new int[n]; // the last index prior to i, that gives largestDivisibleSubset ending at i-th element
        len[0]=1;
        Arrays.fill(prelast, -1);
        
        int maxlen = 0;
        int maxlenLastIndex = 0;
        
        for(int i=1; i<n; i++){ // iterate through the array
            len[i] =1;	// initialize as 1; this is necessary in case it don't update in for loop below
            for(int j=i-1; j>=0; j--){  // check all numbers pre i
                if(nums[i]%nums[j] == 0){   // if(nums[i]%nums[j] == 0), a new DivisibleSubset ending at i has length: len[j]+1
                    if(len[j]+1 > len[i]){  // if the new length is larger
                        len[i] = len[j]+1;  // update len[i]
                        prelast[i] = j; // and update the last index prior to i
                    }
                }
            }
            // update maxlen after done with each element
            if(len[i]>maxlen){
                maxlen = len[i];
                maxlenLastIndex = i;
            }
        }
        // construct the result
        int k = maxlenLastIndex;
        while(k>=0){
            res.add(0, nums[k]);
            k = prelast[k];
        }
        
        return res;
    }
}
