package baitapmain.baitap02;

import java.util.Arrays;
import java.util.Random;

public class Baitap02 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
//        lọc các số chẵn trong mảng bằng filter
        int [] newArr = Arrays.stream(arr).filter(value -> value%2==0).toArray();
        System.out.println(Arrays.toString(newArr));
    }
}
