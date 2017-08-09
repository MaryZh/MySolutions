// Use the fact that the product of num1[i]*num2[j] is at indices [i+j, i+j+1].

public class Solution {
    public String multiply(String num1, String num2) {
        int m= num1.length(), n=num2.length();
        int[] res = new int[m+n];   // to store each digit in the product
        for(int i= m-1; i>=0; i--){
            for(int j= n-1; j>=0; j--){
                int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                
                int p1= i+j, p2 = i+j+1;
                // int sum = res[p2] +product%10;   // add product to numbers at p1, p2 digit by digit
                // res[p2] = sum%10;
                // res[p1] += product/10 + sum/10;
                int sum = res[p2]+product;  // add product to p2, and carry to p1 (equivalent to the above method)
                res[p2] = sum%10;
                res[p1] += sum/10;
            }
        }
        
        String result="";
        for(int i=0; i<res.length; i++){
            if(result.length()==0 && res[i] == 0)   // remove leading 0's
                continue;
            result += res[i];
        }
        return result.length()==0?"0":result;
    }
}
