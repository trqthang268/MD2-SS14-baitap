package baitaptonghop.run;

import baitaptonghop.business.config.InputMethods;
import baitaptonghop.business.design.IDepartment;
import baitaptonghop.business.implement.DepartmentImplement;

public class DepartmentManagement {
    static IDepartment departmentDesign = new DepartmentImplement();

    public void displayDepartmentMenu() {
        while (true) {
            System.out.println("================Department Menu===================");
            System.out.println("1- Hiển thi \n" +
                    "2- thêm mới\n" +
                    "3- sửa \n" +
                    "4- xóa \n" +
                    "5- Quay lại ");

            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    departmentDesign.displayAll();
                    break;
                case 2:
                    departmentDesign.addNewElement();
                    break;
                case 3:
                    departmentDesign.updateElement();
                    break;
                case 4:
                    departmentDesign.deleteElement();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Nhap lua chon ko chinh xác");
            }
        }
    }
}
