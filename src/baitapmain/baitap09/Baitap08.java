package baitapmain.baitap09;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Baitap08 {
    public static void main(String[] args) {
//        Bài tập 1: Viết chương trình để lấy ngày hiện tại của hệ thống và các nơi bao gồm : Asia/Tokyo, Australia/Sydney ,America/Sao_Paul
        ZonedDateTime tokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime sydney = ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
        ZonedDateTime saopaulo = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println("now of tokyo is :"+ tokyo+"\nnow of sydney is :"+sydney+"\nnow of saopaul  is :"+saopaulo);

//        Bài tập 2: Viết chương trình để lấy thời gian hiện tại (giờ phút giây).
        LocalTime localTime = LocalTime.now();
        System.out.println("Thời gian hiện tại là "+localTime);

//        Bài tập 3: Viết chương trình để tính toán số ngày giữa hai ngày (LocalDate) nhập vào .
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhap so ngay cua ngay thu nhat");
//        int day1 = scanner.nextInt();
//        System.out.println("Nhap so thang cua ngay thu nhat");
//        int month1 = scanner.nextInt();
//        System.out.println("Nhap so nam cua ngay thu nhat");
//        int year1 = scanner.nextInt();
//        System.out.println("Nhap so ngay cua ngay thu hai");
//        int day2 = scanner.nextInt();
//        System.out.println("Nhap so thang cua ngay thu hai");
//        int month2 = scanner.nextInt();
//        System.out.println("Nhap so nam cua ngay thu hai");
//        int year2 = scanner.nextInt();
//        LocalDate firstDay = LocalDate.of(year1,month1,day1);
//        LocalDate secondDay = LocalDate.of(year2,month2,day2);
//        long dayLength = Duration.between(firstDay.atStartOfDay(),secondDay.atStartOfDay()).toDays();
//        System.out.println("Khoang cach giua 2 ngay "+firstDay+" va "+secondDay+" la :"+dayLength);

//        Bài tập 4: Viết chương trình để tính toán số ngày trong tháng hiện tại.
        LocalDate hientai = LocalDate.now();
        int monthNow = hientai.lengthOfMonth(); // lengthOfMonth : trả về độ dài 1 tháng
        System.out.println("So ngay trong thang hien tai la :"+monthNow);

//        Bài tập 5: Viết chương trình để tính toán số ngày trong năm hiện tại.
        int yearNow = hientai.lengthOfYear();
        System.out.println("So ngay trong nam hien tai la :"+yearNow);

//        Bài tập 6: Viết chương trình để chuyển đổi một chuỗi ngày sang một đối tượng LocalDate.
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        System.out.println("Nhap chuoi ngay :");
//        String inputDay = scanner.nextLine();
//        LocalDate lcd = LocalDate.parse(inputDay,df);
//        System.out.println(lcd);

//        Bài tập 7: Viết chương trình để chuyển đổi một đối tượng LocalDate sang một chuỗi ngày (dd/MM/yyyy).
        LocalDate iDay = LocalDate.of(2000,6,12);
        System.out.println(iDay.format(df));

//        Bài tập 8: Viết chương trình để chuyển đổi một đối tượng LocalDateTime sang một chuỗi ngày(dd/MM/yyyy HH:mm:ss).
        DateTimeFormatter dfs = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime iDay1 = LocalDateTime.of(2020,6,11,22,22,22);
        System.out.println(iDay1.format(dfs));

//        Bài tập 9: Viết chương trình để so sánh hai ngày LocalDate ( trả về int ).
        LocalDate dayS1 = LocalDate.of(2002,7,21);
        LocalDate dayS2 = LocalDate.of(2012,2,12);
        int asd = dayS1.compareTo(dayS2);
        System.out.println(asd);

//        Bài tập 10: Viết chương trình để so sánh hai thời gian  LocalTime
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(12,12,12);
        int qwe = localTime1.compareTo(localTime2);
        System.out.println(qwe);

//        Bài tập 11: Viết chương trình để thêm hoặc bớt một số ngày, giờ,
//        phút, giây hoặc mili giây vào một ngày hoặc thời gian nhập vào.
        LocalDateTime ldt = LocalDateTime.of(2019,1,1,19,15,30);
        System.out.println("Ngay' goc :"+ldt.toString());
        LocalDateTime ldtAfter = ldt.plusDays(90);
        System.out.println("Ngay sau khi them thoi gian :"+ldtAfter);

//        Bài tập 12: Viết chương trình để tính toán ngày (LocalDate)
//        tiếp theo hoặc ngày trước đó của một ngày.
        LocalDateTime prevDay = ldt.minusDays(1);
        LocalDateTime nextDay = ldt.plusDays(1);
        System.out.println("ngày trước đó là :"+prevDay);
        System.out.println("ngày tiếp theo là :"+nextDay);

//        Bài tập 13: Viết chương trình để tính toán thời gian (LocalTime)
//        tiếp theo hoặc thời gian trước đó của một thời gian.
        LocalTime lct = LocalTime.of(9,20);
        LocalTime nextTime = lct.plusHours(2);
        LocalTime prevTime = lct.minusHours(2);
        System.out.println("Thoi gian goc : "+lct);
        System.out.println("Thoi gian tiep theo : "+nextTime);
        System.out.println("Thoi gian truoc do : "+prevTime);

    }

}
