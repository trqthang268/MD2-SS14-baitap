package baitapmain.baitap01;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchMax {
    public static void main(String[] args) {
        List<Integer> ramdom = Stream.generate(()-> new Random().nextInt(1000)).limit(100).sorted().collect(Collectors.toList());
        System.out.println("List :"+ramdom);
        Optional<Integer> max = ramdom.stream().max(Comparator.naturalOrder());
        System.out.println("Giá trị lớn nhất : "+max.orElseThrow(()-> new RuntimeException("Không có phần tử")));
    }
}
