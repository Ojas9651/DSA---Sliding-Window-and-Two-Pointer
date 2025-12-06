/*
    Optimal Solution -

    Approach - In better solution we were updating the max frequency every time changes > k
            But we need not to calculate the max frequency as we already have a max length 
            If were subtracting the maxfrequency we will not going to get the maxlen more than current
            That's why no need to calculate the max frequency

            We also can remove the inner while loop by moving left only by one place foward we keep maintaining the 
            window

    1. Maintian a Hash Array 
    2. If (right - left + 1 - maxfr) > k : hashArr[s.charAt(l)-'A']--; l++;
    3. If (right - left + 1 - maxfr) <= k : maxlen updated;
*/

public class Longest_Repeating_Character_Replacement {
    public static int characterReplacement(String s, int k) {
        int[] hashArr = new int[26];
        int maxfr = 0;
        int l = 0;
        int r = 0;
        int maxlen = 0;
        while(r < s.length()){
            hashArr[s.charAt(r)-'A']++;
            maxfr = Math.max(maxfr, hashArr[s.charAt(r) - 'A']);
            if((r-l+1)-maxfr > k){
                hashArr[s.charAt(l)-'A']--;
                l++;
            }
            if(r-l+1 - maxfr <= k){
                maxlen = Math.max(maxlen, r-l+1);
            }
            r++;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        System.out.println(characterReplacement(s, 1));
    }
}

/*
    Better Solution -

    1. We will iterate Once
    2. We will maintain a Hash Array that counts the frequency of letters 
    3. For every iteration we calculate the Total Max Frequency in HashArray
    4. We check changes required by changes = right - left + 1 - maxFrequency
    5. If changes <= k update the MaxLength else loop till changes > k
    6. While looping always before moving left iterator reducing the freqeucncy of current alphabet by 1 in HashMap
    7. After reducing frequency again check the changes and if changes < k loop completed
    8. Move right
    
    TC - O(2N) * 26
    SC - O(26)

public class Longest_Repeating_Character_Replacement {
    public static int characterReplacement(String s, int k) {
        int[] hashArr = new int[26];
        int maxfr = 0;
        int l = 0;
        int r = 0;
        int maxlen = 0;
        while(r < s.length()){
            hashArr[s.charAt(r)-'A']++;
            maxfr = Math.max(maxfr, hashArr[s.charAt(r) - 'A']);
            while((r-l+1)-maxfr > k){
                hashArr[s.charAt(l)-'A']--;
                maxfr = 0;
                for(int i=0; i<26; i++){
                    maxfr = Math.max(maxfr, hashArr[i]);
                }
                l++;
            }
            if(r-l+1 - maxfr <= k){
                maxlen = Math.max(maxlen, r-l+1);
            }
            r++;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        String s = "ABAB";
        System.out.println(characterReplacement(s, 2));
    }
}
*/

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

