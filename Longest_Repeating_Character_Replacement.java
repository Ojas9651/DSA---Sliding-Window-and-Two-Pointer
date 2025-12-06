/*
    Better Solution -

    1. We will iterate Once
    2. We will maintain a HashMap that counts the frequency of letters
    3. For every iteration we calculate the Total Max Frequency in HashMap
    4. We check changes required by changes = right - left + 1 - maxFrequency
    5. If changes <= k update the MaxLength else loop till changes > k
    6. While looping always before moving left iterator reducing the freqeucncy of current alphabet by 1 in HashMap
    7. After reducing frequency again check the changes and if changes < k loop completed
    8. Move right
    
    TC - O(2N)
    SC - O(26)
*/

import java.util.HashMap;

public class Longest_Repeating_Character_Replacement {
    public static int findMax(HashMap<Character, Integer> hm){
        int max = 0;
        for(Character ch: hm.keySet()){
            max = Math.max(max, hm.get(ch));
        }
        return max;
    }
    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxfr = 0;
        int l = 0;
        int r = 0;
        int maxlen = 0;
        int max = 0;
        int changes = 0;
        while(r < s.length()){
            if(hm.containsKey(s.charAt(r))){
                hm.put(s.charAt(r), hm.get(s.charAt(r))+1);
                max = findMax(hm);
                maxfr = Math.max(maxfr, max);
                changes = r-l+1 - maxfr;
                if(changes <= k){
                    maxlen = Math.max(maxlen, r-l+1);
                    r++;
                }else{
                    while(changes > k){
                        hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                        l++;
                        maxfr = findMax(hm);
                        changes = r-l+1 - maxfr;
                    }
                    r++;
                }
            }else{
                hm.put(s.charAt(r), 1);
                max = findMax(hm);
                maxfr = Math.max(maxfr, max);
                changes = r-l+1 - maxfr;
                if(changes <= k){
                    maxlen = Math.max(maxlen, r-l+1);
                    r++;
                }else{
                    while(changes > k){
                        hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                        l++;
                        maxfr = findMax(hm);
                        changes = r-l+1 - maxfr;
                    }
                    r++;
                }
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        String s = "ABAB";
        System.out.println(characterReplacement(s, 2));
    }
}
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
*/

