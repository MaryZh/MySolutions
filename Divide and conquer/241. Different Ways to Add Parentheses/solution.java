public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            // divide the string into two parts before and after an operator
            if(c == '+' || c == '-' || c == '*'){
                String part1 = input.substring(0,i);
                String part2 = input.substring(i+1);
                List<Integer> part1Res = diffWaysToCompute(part1);
                List<Integer> part2Res = diffWaysToCompute(part2);
                for(int n1:part1Res){
                    for(int n2:part2Res){
                        int sum =0;
                        if(sum == '+')
                            sum = n1+n2;
                        else if(c == '-')
                            sum = n1-n2;
                        else
                            sum = n1*n2;
                        res.add(sum);
                    }
                }
            }
        }
        // if there is no operator
        if(res.isEmpty())
            res.add(Integer.valueOf(input));
        return res;
    }
}
