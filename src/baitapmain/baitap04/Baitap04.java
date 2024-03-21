package baitapmain.baitap04;

import java.util.Arrays;
import java.util.Comparator;

public class Baitap04 {
    public static void main(String[] args) {
        String[] arrStr = new String[100];
        for (int i = 0; i < arrStr.length; i++) {
            Student student = new Student("SV00"+i);
            arrStr[i] = String.valueOf(student.hashCode());
        }
        System.out.println(Arrays.toString(arrStr));
//        Dùng sorted để sắp xếp danh sách theo thứ tự bảng chữ cái
        Arrays.stream(arrStr).sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }
}
