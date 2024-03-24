package baitaptonghop.business.implement;

import baitaptonghop.business.config.InputMethods;
import baitaptonghop.business.design.IDepartment;
import baitaptonghop.business.entity.Department;

import java.util.ArrayList;
import java.util.List;
import static baitaptonghop.business.implement.EmployeeImplement.employeeList;

public class DepartmentImplement implements IDepartment {

//    khởi tạo danh sách chứa thông tin phòng ban
    static List<Department> departmentList = new ArrayList<>();
    @Override
    public void displayAll() { // hien thi danh sach phong ban
        if (departmentList.isEmpty()){
            System.err.println("Danh sách trống");
        }else{
            departmentList.forEach(department -> department.displayData());
        }
    }

    @Override
    public void addNewElement() {
        System.out.println("Nhập số lượng phòng ban muốn thêm mới");
        byte count = InputMethods.getByte();
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhập thông tin cho phòng ban thứ "+i);
            Department department = new Department();
            department.inputData(true,departmentList);
            departmentList.add(department);
        }
        System.out.println("Đã thêm mới thành công");
    }
    @Override
    public void updateElement() {
        System.out.println("Chọn phòng ban muốn sửa đổi");
        String id = InputMethods.getString();
        Department update = findById(id);
        if (update == null){
            System.err.println("Không tìm thấy mã phòng ban");
            return;
        }
//        hiển thị thông tin cũ
        System.out.println("Thông tin cũ của phòng ban");
        update.displayData();
//        Nhập thông tin mới
        System.out.println("Nhập thông tin mới ");
        update.inputData(false,departmentList);
        System.out.println("Cập nhật thông tin thành công");
    }

    @Override
    public void deleteElement() {
        System.out.println("Hãy chọn phòng ban muốn xóa");
        String id = InputMethods.getString();
        Department delete = findById(id);
        if (delete==null){
            System.err.println("Không tìm thấy mã phòng ban");
            return;
        }
//        Kiểm tra phong ban có người hay không
        if (employeeList.stream().anyMatch(employee -> employee.getDepartment().getDepartmentId().equals(id))){
//            có nhân viên trong phòng ban
            System.err.println("Phòng ban này có nhân viên, không thể xóa");
            return;
        }
//        không có nhân viên trong phòng
        departmentList.remove(delete);
        System.out.println("Xóa phòng ban thành công");
    }

    @Override
    public Department findById(String id) {
        for (Department department : departmentList) {
            if (department.getDepartmentId().equals(id)){
                return department;
            }
        }
        return null;
    }
}
