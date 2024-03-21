package baitapmain.baitaptonghop.business.designimpl;

import baitapmain.baitaptonghop.business.design.IDepartment;
import baitapmain.baitaptonghop.business.entity.Department;
import baitapmain.baitaptonghop.config.InputMethods;

import java.util.ArrayList;
import java.util.List;

public class DepartmentImpl implements IDepartment {
    public static List<Department> departmentList = new ArrayList<>();
    @Override
    public Department findById(String id) {
        for (Department d : departmentList) {
            if (d.getDepartmentId() == id){
                return d;
            }
        }
        return null;
    }

    @Override
    public void addNewElement() {
        System.out.println("Nhập số lượng phòng ban muốn thêm");
        int count = InputMethods.getInteger();
//        duyệt vào list phòng ban
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho phòng ban ");
            Department department = inputData(true);
            departmentList.add(department);
        }
        System.out.println("Đã thêm thành công "+count+" phòng ban");
    }

    @Override
    public void editElement() {
        System.out.println("Nhập id của phòng ban");
        String idEdit = InputMethods.getString();
        Department departmentEdit = findById(idEdit);
        if (departmentEdit == null){
            System.out.println("Không tìm thấy phòng ban");
        }else{
//           hiển thị thông tin cũ
            System.out.println("Thông tin phòng ban cũ là :");
            System.out.println(departmentEdit);
            System.out.println("Nhập thông tin mới :");
            departmentEdit = inputData(false);
            departmentEdit.setDepartmentId(idEdit);//không thay đổi id của phòng
//            ghi đè thông tin mới lên thông tin cũ
            departmentList.set(departmentList.indexOf(findById(idEdit)),departmentEdit);
            System.out.println("Đã cập nhật thông tin");
        }
    }

    @Override
    public void deleteElement() {
        System.out.println("Nhập mã phòng ban muốn xóa");
        String idDelete = InputMethods.getString();
        Department departmentDel = findById(idDelete);
        if (departmentDel == null){
            System.out.println("Không tìm thấy");
        } else if (departmentDel.getTotalMembers() != 0) {
            System.out.println("Phòng ban có tồn tại nhân viên. Không thể xóa");
        }else{
            departmentList.remove(departmentDel);
            System.out.println("Xóa thành công phòng ban");
        }
    }

    @Override
    public void displayElement() {
        if (departmentList.isEmpty()){
            System.out.println("Danh sách phòng ban rỗng");
        }else{
            for (Department department : departmentList) {
                System.out.println(department);
            }
        }
    }

    @Override
    public Department inputData(boolean isAdd) {
        Department newDepmt = new Department();
        if (isAdd){
            System.out.println("Nhập mã phòng ban ");
            newDepmt.setDepartmentId(InputMethods.getString());
        }
        System.out.println("Nhập tên phòng ban");
        newDepmt.setDepartmentName(InputMethods.getString());
        return newDepmt;
    }
}
