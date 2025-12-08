/*
    Given a string s consisting only of characters a, b and c.

    Return the number of substrings containing at least one occurrence of all these characters a, b and c.      

    For every character there is a substring that ends
    For every character check whether we have all 3 characters previous of the current
    Declare a hash Array of size 3 assign to -1
    Update the last seen index of the characters
    if at current character we have all the 3 characters in the hash Array
    find the min index and add it to the count + 1 for the current substring.
*/

import java.util.Arrays;

public class Number_of_Substrings_Containing_All_Three_Characters {
    public static int numberOfSubstrings(String s) {
        int[] hash = new int[3];
        Arrays.fill(hash, -1);
        int r = 0;
        int count = 0;
        while(r < s.length()){
            hash[s.charAt(r) - 'a'] = r;
            if(hash[0] > -1 && hash[1] > -1 && hash[2] > -1){
                int min = Math.min(Math.min(hash[0], hash[1]), hash[2]);
                count = count + min + 1;
            }
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}

