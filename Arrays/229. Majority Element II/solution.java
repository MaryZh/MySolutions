// Boyer-Moore Majority Vote algorithm. And since the requirement is finding the majority for more than ceiling of [n/3], 
// the answer would be less than or equal to two numbers. So we can modify the algorithm to maintain two counters for two majorities.
//
// They are not necessarily be the 2 most frequent elements after the 1st round. So we need round 2 to check.

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        
        // find two "possible" candidates
        int candidate1=0, candidate2=0, counter1=0, counter2=0;
        for(int n: nums){
            if(candidate1 == n) // if n is one of the candidates
                counter1++;
            else if(candidate2 == n)
                counter2++;
            else if(counter1 == 0){
                candidate1=n;
                counter1 =1;
            }
            else if(counter2==0){
                candidate2=n;
                counter2=1;
            }
            else{
                counter1--;
                counter2--;
            }
        }
        // check if there are real majorities
        int count1=0, count2=0;
        for(int n:nums){
            if(n==candidate1)
                count1++;
            else if(n == candidate2)    // use "else if" instead of "if" in case the two candidates are the same
                count2++;
        }
        if(count1 > len/3)
            res.add(candidate1);
        if(count2 > len/3)
            res.add(candidate2);
        
        return res;
    }
}
