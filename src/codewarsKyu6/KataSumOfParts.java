package codewarsKyu6;

import java.util.Arrays;

public class KataSumOfParts {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumParts(new int[]{0, 1, 3, 6, 10})));
    }

    public static int[] sumParts(int[] ls) {
        int[] sumOfList = new int[ls.length + 1];

        int index = ls.length-1;
        int sum = 0;
        for( int i = sumOfList.length-1; i >= 0; i--){
            sumOfList[i]=sum;

            if(index>=0){
                sum =sum + ls[index];
                index--;
            }
        }
        return sumOfList;
    }
}
