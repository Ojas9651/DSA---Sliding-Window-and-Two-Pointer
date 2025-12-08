/*
    Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

    Return the number of nice sub-arrays.

    If we consider all the even numbers as 0 and all the odd numbers as 1 then this will be same as find the SubArrays_Where_Sum-Equals_Goal.

    arr = [1,1,2,1,1]; -> arr[1,1,0,1,1] (odd -> 1; Even -> 0) if k = 2 so all the subarrays where there 2 odd numbers will be equivalent to sum of odd numbers

*/
public class Count_Number_of_Nice_Subarrays {

    public static int findSubarrays(int[] arr, int k){
        if(k < 0) return 0;
        int l = 0;
        int r = 0;
        int count = 0;
        int sum = 0;
        while(r < arr.length){
            sum = sum + arr[r]%2;
            while(sum > k){
                sum = sum - arr[l]%2;
                l++;
            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int subarrays_k_odd = findSubarrays(nums, k);
        int subaarsys_k_1_odd = findSubarrays(nums, k-1);
        return subarrays_k_odd - subaarsys_k_1_odd;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(nums, 2));
    }
}
