package com.karson.sort;
import java.util.Arrays;


public class Bubble {
    public static void main(String[] args) {
        Integer arr[] = {9,1,2,5,7,4,8,6,3,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("hot-fix-first-commit");
        System.out.println("master-text");
        System.out.println("push");
        System.out.println("push2");
        System.out.println("gitee");
    }
    //快速排序
    public static void sort(Comparable[] arr){
        //1.定义low和high变量，分别记录数组中最小最大的索引
        int low = 0;
        int high = arr.length - 1;
        //3.调用sort重载方法完成数组arr中，从索引low到索引high元素的排序
        sort(arr,low,high);
    }

    //对数组arr从low到high进行排序
    private static void sort(Comparable[] arr,int low,int high){
        //做安全性校验
        if (low >= high){
            return;
        }
        //需要对数组中从low索引到high索引处的元素进行分组(左子组和右子组)
        int partition = partition(arr, low, high);

        //让左子组有序
        sort(arr,low,partition-1);

        //让右子组有序
        sort(arr,partition+1,high);
    }

    private static int partition(Comparable[] arr,int low,int high){
        //确定分界值，为数组最左侧的元素
        Comparable key = arr[low];
        //定义两个指针，分别指向切分元素的最小索引处和最大索引处+1的位置
        int left = low;
        int right = high + 1;

        //切分
        while (true){
            //1.先从右往左扫描，找到一个比分界值小的元素，停止
            while (less(key,arr[--right])){
                if (right == low){
                    break;
                }
            }
            //2.先从左往右扫描，找到一个比分界值小的元素，停止
            while (less(arr[++left],key)){
                if (left == high){
                    break;
                }
            }
            //3.判断left >= right，则证明元素扫描完毕，结束循环，如果不是，则交换元素
            if (left >= right){
                break;
            }
            exch(arr,left,right);
        }
        //4.交换最后right索引处和基准值所在的索引处的值
        exch(arr,low,right);

        return right;
    }

    //比较元素v是否小于元素w
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) <= 0;
    }

    //数组元素i和元素j交换位置
    private static void exch(Comparable[] arr,int i,int j){
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
