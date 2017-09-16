package com.hjy.text;

/*
给定一个数组序列，
使得区间经过如下计算的值是所有区间中最大的:
区间中的最小数*区间所有数的和

        如[6，2，1]，则求出区间为[6]
        输入:
        3
        6 2 1

        输出:
        36
*/
public class test {
    public static int function(int[] arr) {
        int len = arr.length;
        int[] sum = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            //右边界
            sum[i] = arr[i];
            for (int j = i+1; j < len; j++) {
                if (arr[j] >= arr[i]) {
                    sum[i] += arr[j];
                } else {
                    break;
                }
            }
            //左边界
            for (int j = i-1; j >= 0;j--) {
                if (arr[j] >= arr[i]) {
                    sum[i] += arr[j];
                } else {
                    break;
                }
            }
            ans = Math.max(ans,sum[i]*arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,4};
        System.out.println(function(arr));
    }
}