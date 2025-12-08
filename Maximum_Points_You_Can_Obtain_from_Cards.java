/*
    Approach -
    
    1. Find the sum of first K elements
    2. store the max = sum;
    3. place left = k-1;
    4. place right = n-1;
    5. Loop till (left >= 0)
    6. Ever iteration -> sum = sum - nums[left] + nums[r];
    7. Store -> max = Math.max(max, sum);
    8. return max;
*/
public class Maximum_Points_You_Can_Obtain_from_Cards {
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += cardPoints[i];
        }
        int max = sum;
        int l = k-1;
        int r = n-1;
        while(l >= 0){
            sum = sum - cardPoints[l] + cardPoints[r];
            max = Math.max(max, sum);
            l--;
            r--;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        System.out.println(maxScore(cardPoints, 3));
    }
}
