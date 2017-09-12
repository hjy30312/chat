package com.hjy.text;

import java.util.*;

public class Printer {

    public static int[] printMatrix(int[][] mat, int n, int m) {
        // write code here
        int[] temp = new int[n * m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[ans] = mat[i][j];
                ans += 1;
            }
            //n为基数 偶数的处理
            if (i + 1 != n ) {
                i++;
            } else {
                 break;
            }
            for (int j = m-1; j >= 0; j--) {
                temp[ans++] = mat[i][j];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int [][]m ={ {1,2,3},
                    {4,5,6},
                    {7,8,9},
                    {10,11,12}
        };
        System.out.println(Arrays.toString(printMatrix(m,4,3)));
    }
}