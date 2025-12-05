import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {
        public static int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> hm = new HashMap<>();
            int max = 0;
            int low = 0;
            int high = 0;
            while(high < s.length()){
                if(hm.containsKey(s.charAt(high))){
                    if(hm.get(s.charAt(high)) >= low){
                        low = hm.get(s.charAt(high)) + 1;
                    }
                    max = Math.max(max, high-low+1);
                    hm.put(s.charAt(high), high);
                    high++;
                }else{
                    max = Math.max(max, high-low+1);
                    hm.put(s.charAt(high), high);
                    high++;
                }  
            }
            return max;
        }
        public static void main(String[] args) {
            String s = "abcabcbb";
            System.out.println(lengthOfLongestSubstring(s));
        }  
}
