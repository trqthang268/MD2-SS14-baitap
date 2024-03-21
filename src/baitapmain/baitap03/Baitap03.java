package baitapmain.baitap03;

import java.util.Arrays;
import java.util.Random;

public class Baitap03 {
    public static void main(String[] args) {
//        tạo danh sach
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
        System.out.println("Mang :"+arr);
//        tinh tổng bằng reduce
        int tong = Arrays.stream(arr).reduce(0,Integer::sum);
        System.out.println(tong);
    }
}
