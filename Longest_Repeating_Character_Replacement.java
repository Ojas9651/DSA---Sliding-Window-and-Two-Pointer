/*
    Brute Force Solution -

    1. We have to declare a frequncy Array for 26 letters
    2. 2 loops , j will move from i to string.length();
    3. hashArray will count the frquency of each letter by hashArray(s.charAt(j) - 'A');
    4. Now count the max frequency of the letters in the current subarray
    5. Now find if there is any change of character by (j-i+1) - max frequency
    6. Check if changes change <= k , update the max else break

    TC - O(N^2)
    SC - O(26)
*/

public class Longest_Repeating_Character_Replacement {
    public static int characterReplacement(String s, int k) {
        int max = 0;
        for(int i=0; i<s.length(); i++){
            int[] hashArr = new int[26]; //1
            int maxfr = 0;
            for(int j=i; j<s.length(); j++){
                hashArr[s.charAt(i) - 'A']++; //3 
                maxfr = Math.max(maxfr, hashArr[s.charAt(j)-'A']); // 4
                int changes = j-i+1 - maxfr; 
                if(changes <= k){
                    max = Math.max(max, j-i+1);
                }else{
                    break;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "ABAB";
        System.out.println(characterReplacement(s, 2));
    }
}

