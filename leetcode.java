public class leetcode {

    public static String[] reverse(String[] s){
        for(int i=0; i<s.length; i++){
            StringBuilder str = new StringBuilder(s[i]);
            s[i] = str.reverse().toString();
        }
        return s;
    }
    public static void main(String[] args) {
        int[] n = {4,5,4};
        String[] arr = new String[n.length];
        for(int i=0; i<n.length; i++){
            arr[i] = Integer.toBinaryString(n[i]);
        }
        arr = reverse(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        int[] newArr = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            newArr[i] = Integer.parseInt(arr[i], 2);
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(newArr[i]+" ");
        }
        Boolean isSort = false;
        while(isSort == false){
            isSort = true;
            for(int i=0; i<newArr.length-1; i++){
                if(newArr[i] > newArr[i+1]){
                    int temp = newArr[i];
                    newArr[i] = newArr[i+1];
                    newArr[i+1] = temp;
                    isSort = false;
                }
            }
        }
        for(int i=0; i<newArr.length; i++){
            arr[0] = Integer.toBinaryString(newArr[i]);
        }
        arr = reverse(arr);
        for(int i=0; i<arr.length; i++){
            newArr[i] = Integer.parseInt(arr[i],2);
        }
        System.out.println();
        for(int i=0; i<arr.length; i++){
            System.out.print(newArr[i]+" ");
        }
    }
    
}
