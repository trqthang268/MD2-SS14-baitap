package baitapmain.baitap06;

import java.util.Arrays;

public class Baitap06 {
    public static void main(String[] args) {
        String[] str = {"asd","cjkvhb","asdjw","vcduu"};
//  Sử dụng Stream API và phương thức map() để chuyển các chuỗi thành chữ in hoa.
        Arrays.stream(str).map(s -> s.toUpperCase()).forEach(System.out::println);
    }

}
