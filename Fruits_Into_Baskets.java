/*
    Take a Map store the tree and the times it appears
    Start with the basket 1 and 1 by storing first 2 fruits
    Store all the fruits if a fruits value is greater in hashmap put that into basket

    TC - O(N)
    SC - O(N)
*/

import java.util.HashMap;

public class Fruits_Into_Baskets {
    public static int totalFruits(int[] fruits) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int a = -1;
        int count_a = 0;
        int b = -1;
        int count_b = 0;
        for(int i=0; i<fruits.length; i++){
          if(hm.containsKey(fruits[i])){
            hm.put(fruits[i], hm.get(fruits[i])+1);
            if(a == fruits[i]){
              count_a++;
            }else if(b == fruits[i]){
              count_b++;
            }else{
              if(hm.get(fruits[i]) > hm.get(fruits[a]) || hm.get(fruits[i]) > hm.get(fruits[b])){
                if(hm.get(fruits[i]) > hm.get(fruits[a])){
                  a = fruits[i];
                  count_a = hm.get(fruits[i]);
                }else{
                  b = fruits[i];
                  count_b = hm.get(fruits[i]);
                }
              }
            }
          }else{
            hm.put(fruits[i], 1);
            if(a == -1){
              a = fruits[i];
              count_a++;
            }else if(b == -1){
              b = fruits[i];
              count_b++;
            }else{
              
            }
          }
        }
        return count_a+count_b;
    }
    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
        System.out.println(totalFruits(fruits));
    }
}

