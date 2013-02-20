/*
Question: Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
*/
public class Solution {
    public boolean isPalindrome(String s) {     
        s=s.replaceAll("\\W","");
        s=s.toLowerCase();
        char[] temp=s.toCharArray();
        int flag=1;
        for(int i=0;i<temp.length;i++){
            if(temp[i]!=temp[temp.length-i-1]){
                flag=0;
                break;
            }
        }
        if(flag==1){
            return true;
        }
        else{
            return false;
        }
    }
}
