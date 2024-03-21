package baitapmain.baitap08;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;

public class Baitap08 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
//            arr[i] = 1;
        }
        boolean a = Arrays.stream(arr).anyMatch(number -> number%2==0);

        OptionalInt optionalInt = Arrays.stream(arr).filter(value -> value%2==0).findFirst();
        System.out.println("Số chẵn đầu tiên là :"+optionalInt.orElseThrow(()->new RuntimeException("Không có số chẵn nào trong mảng")));
    }
}
