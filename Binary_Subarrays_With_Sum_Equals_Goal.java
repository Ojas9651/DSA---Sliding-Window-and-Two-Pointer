/*
    This problem is similar to Finding Subarrays with the Given Sum K TC was O(N) and SC was O(N)
    We are optimising -

        If we find the subarrays where (sum <= goal) and subaarsys where (sum <= goal-1)
        then, sybarrays where (sum == goal) = (sum <= goal) - sum <= goal-1)
*/

public class Binary_Subarrays_With_Sum_Equals_Goal {

    public static int findSubarrays(int[] arr, int goal){
        if(goal < 0) return 0; //if goal given 0 then goal will become -1 that is why we are writing this condition
        int l = 0, r = 0;
        int count = 0, sum = 0;
        while(r < arr.length){
            sum += arr[r];
            while(sum > goal){
                sum = sum - arr[l];
                l++;
            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }

    public static int numSubarraysWithSum(int[] arr, int goal){
        int subarrays_less_than_equal_to_goal = findSubarrays(arr, goal);
        int subarrays_less_than_equal_to_goal_1 = findSubarrays(arr, goal-1);
        return subarrays_less_than_equal_to_goal - subarrays_less_than_equal_to_goal_1;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(arr, 2));
    }
}
