// This is Boyer-Moore Majority Vote algorithm( https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html ). 
// Linear. 3ms

public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, counter = 0;
        for(int num:nums){
            if(counter == 0){
                candidate = num;
            }
            if(num == candidate){
                counter ++;
            }
            else{
                counter--;
            }
        }
        return candidate;
    }
}
