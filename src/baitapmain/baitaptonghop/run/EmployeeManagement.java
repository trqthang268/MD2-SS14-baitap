package baitaptonghop.run;

import baitaptonghop.business.config.InputMethods;
import baitaptonghop.business.design.IEmployee;
import baitaptonghop.business.implement.EmployeeImplement;

import java.util.Scanner;

public class EmployeeManagement {
    static IEmployee employeeDesign = new EmployeeImplement();

    public void displayEmployeeMenu() {
        while (true) {
            System.out.println("================Employee Menu===================");
            System.out.println("1- Hiển thi \n" +
                    "2- thêm mới\n" +
                    "3- sửa \n" +
                    "4- xóa \n" +
                    "5- xem chi tiết thông tin "+
                    "6- Quay lại ");

            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    employeeDesign.displayAll();
                    break;
                case 2:
                    employeeDesign.addNewElement();
                    break;
                case 3:
                    employeeDesign.updateElement();
                    break;
                case 4:
                    employeeDesign.deleteElement();
                    break;
                case 5:
                    employeeDesign.detailInfo();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Nhap lua chon ko chinh xác");
            }
        }
    }
}
