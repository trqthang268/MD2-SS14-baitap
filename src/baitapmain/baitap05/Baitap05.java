package baitapmain.baitap05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Baitap05 {
    public static void main(String[] args) {
        //        tạo danh sach
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
//        Sử dụng Stream API và phương thức filter() để lọc các số lớn hơn một giá trị xác định mà người dùng nhập vào.
        System.out.println("Nhập giá trị xác định :");
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        System.out.println("Mang :"+ Arrays.toString(arr));
        Arrays.stream(arr)
                .filter(number -> number>input)
                .forEach(System.out::println);
        //Sử dụng phương thức forEach() để in các số đã lọc ra màn hình.
    }
}
