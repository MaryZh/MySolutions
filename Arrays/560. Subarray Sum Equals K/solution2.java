// HashMap method. The idea is that we don't care about the indices, only about the sum. So we can put the sum up to all indices,
// together with the frequency they appear into a HashMap, i.e. (sum, frequency) pairs. Along the way we go it(iterate through index),
// we search in the HashMap for sum-k.
//
// Time complexity: O(n).

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum =  0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);   // this take into acount when there is a single element =k
        for(int i=0; i<n; i++){
            sum += nums[i];
            res += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}
