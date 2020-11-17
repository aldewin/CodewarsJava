/**
 * 4 kyu Twice linear
 *
 * https://www.codewars.com/kata/5672682212c8ecf83e000050/solutions/java
 */

package codewarsKyu4;

public class KataTwiceLinear {
    public static void main(String[] args) {
        System.out.println(dblLinear(20));
    }

    public static int dblLinear(int n) {
        int[] sequence = new int[n+1];
        sequence[0] = 1;

        int idx1 = 0;
        int idx2 = 0;
        for (int i = 1; i <= n; i++) {
            int y = 2 * sequence[idx1] + 1;
            int z = 3 * sequence[idx2] + 1;

            sequence[i] = Math.min(y, z);

            if (sequence[i] == y)
                idx1++;
            if (sequence[i] == z)
                idx2++;
        }

        return sequence[n];
    }
}


//    n = 10
//    function dblLinear(n) {
//
//        var u = [1], pt2 = 0, pt3 = 0; //two pointer
//
//        for(var i = 1;i<=n;i++){
//            u[i] = Math.min(2* u[pt2] + 1, 3*u[pt3] + 1);
//            if(u[i] == 2 * u[pt2] + 1) pt2++;
//            if(u[i] == 3 * u[pt3] + 1) pt3++;
//        }
//
//        return u[n];
//
//    }


