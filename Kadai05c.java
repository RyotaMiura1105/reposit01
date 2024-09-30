//22D81011040E Miura Ryota 三浦僚太　2024年5月17日

import java.util.Scanner;

public class Kadai05c{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m;
        m = sc.nextInt();
        int[][] a = new int[m][m];
        for(int n = 0; n < m; n++){
            for(int k = 0; k < m; k++){
                if(k == 0){
                    a[n][k] = 1;
                }else if(n == 0){
                    a[n][k] = 0;
                }else{
                    a[n][k] = a[n-1][k-1] + a[n-1][k];
                }
            }
        }
        for(int n = 0; n < m; n++){
            for(int k = 0; k < m; k++){
                System.out.printf("%4d", a[n][k]);
            }
            System.out.println("\n");
        }
    }
}