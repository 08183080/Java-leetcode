package src.sort;

public class bucket {

    /*
    * 2023-10-14
    * 自大的人们总是想要从无序的世界中提炼出有趣，须知，有序遥不可及...
    *  【桶排序】
    *  read: https://medium.com/@entrustech/bucket-sort-algorithm-a-time-efficient-sorting-algorithm-941b9e06ca38
    *  桶排序的应用场景十分有限
    * */
    public static void bucket(int[] array) {
        int[] bucket = new int[10];

        // 数组array存储着0~9的数字
        for (int i = 0; i < array.length; i++) {
            bucket[array[i]]++;
        }

        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            for (int k = 0; k < bucket[j]; k++) {
                array[i++] = j; // 原地覆盖，神来之笔hhh~
            }
        }
    }

    public static void main(String args[]) {
        int[] b = {1,2,3,4,5,6,7,8,9,8,7,6,7,8};

        bucket(b);  // 桶排序...

        for (int i:b) {
            System.out.println(i);
        }
    }
}
