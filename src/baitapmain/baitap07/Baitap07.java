package baitapmain.baitap07;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Baitap07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so nguyen dau tien");
        int a = scanner.nextInt();
        System.out.println("Nhap so nguyen thu hai");
        int b = scanner.nextInt();
        IntStream stream = IntStream.range(a,b);
        stream.forEach(System.out::println);
    }
}
