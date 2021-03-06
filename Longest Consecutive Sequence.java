/*
Question: Longest Consecutive Sequence
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
*/

public class Solution {
    public int longestConsecutive(int[] num) {       
        //always remember Arrays.sort();
        java.util.Arrays.sort(num);
        int maxLen=1, temp=1;        
        for(int i=0;i<num.length-1;i++){
            //don't forget the duplicate numbers
            if(num[i]==num[i+1]){
                continue;
            }
            //if it's consecutive
            if(num[i]+1==num[i+1]){
                temp++;
                if(temp>maxLen){
                    maxLen=temp;
                }
            }
            //otherwise, reset the temp variable
            else{
                temp=1;
            }
        }
        return maxLen;
    }
}
