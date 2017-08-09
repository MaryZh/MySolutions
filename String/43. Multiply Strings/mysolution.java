public class Solution {
    public String multiply(String num1, String num2) {
        int n= num2.length();
        if(num1.equals("0") || num2.equals("0") )
            return "0";
        String res ="";
        for(int i=0; i<n; i++){
            res = add(res+"0", multiplyByOneDigit(num1, num2.charAt(i)) );
        }
        return res;
    }
    private String multiplyByOneDigit(String num1, char c){
        int n =num1.length();
        
        String res = "";
        int carry = 0;
        
        for(int i=n-1; i>=0; i--){
            int product = carry;
            product += (num1.charAt(i)-'0')*(c-'0');
            res = product%10+ res;
            carry = product/10;
        }
        if(carry != 0)
            res = carry+res;
        return res;
    }
    private String add(String s1, String s2){
        if(s1.equals("0"))
            return s2;
        if(s2.equals("0"))
            return s1;
        
        int m=s1.length(), n=s2.length();
        int i=m-1, j=n-1;
        int sum=0, carry=0;
        String res="";
        
        while(i>=0 || j >= 0){
            sum = carry;
            if(i>=0)
                sum += s1.charAt(i--)-'0';
            if(j>=0)
                sum += s2.charAt(j--)-'0';
            res = sum%10 +res;
            carry = sum/10;
        }
        if(carry != 0)
            res = carry +res;
        return res;
    }
}
