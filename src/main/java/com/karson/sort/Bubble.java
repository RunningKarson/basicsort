package com.karson.sort;
import java.util.Arrays;


public class Bubble {
    public static void main(String[] args) {
        //测试
        Integer[] arr = {4,5,6,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("hot-fix-first-commit");
    }
    //冒泡排序
    public static void sort(Comparable[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            boolean flag = false; //标识变量，表示一次循环中是否有进行值的交换
            for (int j = 0; j < i; j++) {
                //比较索引j和索引j+1处的值
                if (greater(arr[j],arr[j+1])){
                    flag = true;
                    exch(arr,j,j+1);
                }
            }
            if (!flag){
                break;
            }
            flag = false;
        }
    }

    //比较元素v是否大于元素w
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

    //数组元素i和元素j交换位置
    private static void exch(Comparable[] arr,int i,int j){
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}