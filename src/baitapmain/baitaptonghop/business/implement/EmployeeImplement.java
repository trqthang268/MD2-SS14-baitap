package baitaptonghop.business.implement;

import baitaptonghop.business.config.InputMethods;
import baitaptonghop.business.design.IEmployee;
import baitaptonghop.business.entity.Department;
import baitaptonghop.business.entity.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static baitaptonghop.business.implement.DepartmentImplement.departmentList;

public class EmployeeImplement implements IEmployee {
    static List<Employee> employeeList = new ArrayList<>();
    @Override
    public void detailInfo() {
        System.out.println("Chọn phòng ban muốn xem chi tiết");
        String id = InputMethods.getString();
        Employee employee = findById(id);
        if (employee == null){
            System.err.println("Không tìm thấy mã phòng ban");
            return;
        }
        System.out.println("Chi tiết thông tin");
        employee.displayData();

    }

    @Override
    public void getListEmployeeByDepartment() {
        System.out.println("Danh sách phòng ban");
        departmentList.forEach(department -> System.out.printf("| Mã : %-5s | Tên phòng ban : %-15s | \n",department.getDepartmentId(),department.getDepartmentName()));
        System.out.println("Nhập mã phòng ban muốn xem danh sách");
        String id = InputMethods.getString();
        if (departmentList.stream().noneMatch(department -> department.getDepartmentId().equals(id))){
//          tìm trong danh sách có tồn tại mã phòng k
            System.err.println("Mã phòng ban không tồn tại");
            return;
        }
//        có tồn tại
        List<Employee> filterList = employeeList.stream().filter(e->e.getDepartment().getDepartmentId().equals(id)).collect(Collectors.toList());
        if (filterList.isEmpty()){
            System.err.println("Phòng ban này không có nhân viên");
        }else{
            filterList.forEach(employee -> employee.displayNameId());
        }
    }

    @Override
    public void getAvgEmployeePerDepartment() {
        System.out.println("Số lượng nhân viên trung bình là "+(employeeList.size()/departmentList.size()));
    }

    @Override
    public void findTopManager() {
//        sắp xếp bằng comparator
        Comparator<Employee> comparator = (o1,o2)->Long.compare(countEmployeeManager(o2),countEmployeeManager(o1));
        Optional<Employee> employeeOptional = employeeList.stream().min(comparator);
        Employee manager = employeeOptional.orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên"));
        System.out.println("Người quản lí có nhiều nhân viên nhất là ");
        manager.displayData();
        System.out.println("Số lượng nhân viên đang quản lí hiện tại là "+countEmployeeManager(manager));

    }
    private long countEmployeeManager(Employee manager){ // phương thức lấy ra số lượng người đang quản lí
        return employeeList.stream().filter(employee -> employee.getManager()!=null&&employee.getManager().equals(manager)).count();
    }

    @Override
    public void findTop5oldest() {
        System.out.println("Top 5 nhân viên lớn tuổi nhất là");
        employeeList.stream().sorted().sorted(((o1, o2) -> {
            return o2.getBirthday().compareTo(o1.getBirthday());
        })).limit(5).forEach(employee -> employee.displayNameId());
    }

    @Override
    public void findTop5HighestSalary() {
        System.out.println("Top 5 nhân viên có lương cao nhất là");
        employeeList.stream().sorted((o1, o2) -> (int) (o2.getSalary()- o1.getSalary())).limit(5).forEach(employee -> employee.displayNameId());
    }

    @Override
    public void findTop5DepartmentCrowded() {
        System.out.println("Top 5 phòng ban có có số lượng nhân viên đông nhất");
        departmentList.stream().sorted(Comparator.comparingInt(Department::getTotalMembers)).limit(5).forEach(department -> department.getDepartmentName());
    }

    @Override
    public void displayAll() {
//        kiểm tra danh sách có trống không
        if (employeeList.isEmpty()){
            System.err.println("Danh sách trống");
        }else{ // hiển thị id và name
            employeeList.forEach(employee -> employee.displayNameId());
        }
    }

    @Override
    public void addNewElement() {
        if (departmentList.isEmpty()){
            System.err.println("Chưa có phòng ban nào, hãy thêm phòng ban trước");
            return;
        }
        System.out.println("Nhập số lượng nhân viên muốn thêm");
        byte count = InputMethods.getByte();
        for (int i = 1; i <= count ; i++) {
            System.out.println("Nhập thông tin cho nhân viên thứ "+i);
            Employee employee = new Employee(); // khới tạo -> nhập tt -> thêm vào danh sách
            employee.inputData(true,employeeList,departmentList);
            employeeList.add(employee);
        }
        System.out.println("Đã thêm mới nhân viên thành công");
    }

    @Override
    public void updateElement() {
        System.out.println("Hãy nhập mã nhân viên muốn chỉnh sửa");
        String id = InputMethods.getString();
        Employee edit = findById(id);
        if (edit == null){
            System.err.println("Không tìm thấy nhân viên");
            return;
        }
//        hiển thị thông tin cũ
        System.out.println("Thông tin cũ của nhân viên");
        edit.displayData();
//        trừ số lượng nhân viên trong phòng ban cũ đi 1 trước khi thêm mới lại
        Department oldDepmt = edit.getDepartment();
        oldDepmt.setTotalMembers(oldDepmt.getTotalMembers()-1);
//        sau khi trừ đi thì thêm mới lại
        System.out.println("Nhập thông tin mới của nhân viên");
        edit.inputData(false,employeeList,departmentList);
        System.out.println("Cập nhật thông tin thành công");
    }

    @Override
    public void deleteElement() {
        System.out.println("Nhập mã nhân viên muốn xóa");
        String id = InputMethods.getString();
        Employee delete = findById(id);
        if (delete == null){
            System.err.println("Không tìm thấy nhân viên");
            return;
        }
//        xác nhận nhân viên này có quản lí nhân viên nào không
        if (employeeList.stream().anyMatch(employee -> employee.getManager().getEmployeeId().equals(id))){
//            có quản lí
            System.err.println("Nhân viên này đang có quản lí nhân viên khác");
            return;
        }
//        trừ số lượng nhân viên trong phòng ban mà nv đang ở hiện tại đi 1
        Department deleteDepartment = delete.getDepartment();
        deleteDepartment.setTotalMembers(deleteDepartment.getTotalMembers()-1);
//        xòa nhân viên
        employeeList.remove(delete);
        System.out.println("Xóa nhân viên thành công");
    }

    @Override
    public Employee findById(String id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equals(id)){
                return employee;
            }
        }
        return null;
    }

}
