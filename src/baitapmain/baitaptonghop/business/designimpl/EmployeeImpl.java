package baitapmain.baitaptonghop.business.designimpl;

import baitapmain.baitaptonghop.business.design.IEmployee;
import baitapmain.baitaptonghop.business.entity.Department;
import baitapmain.baitaptonghop.business.entity.Employee;
import baitapmain.baitaptonghop.config.InputMethods;

import java.util.ArrayList;
import java.util.List;

import static baitapmain.baitaptonghop.business.designimpl.DepartmentImpl.departmentList;

public class EmployeeImpl extends Department implements IEmployee {
    public static List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee findById(String id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId()==id){
                return employee;
            }
        }
        return null;
    }

    @Override
    public void addNewElement() {
        System.out.println("Nhập số lượng nhân viên cần thêm :");
        byte count = InputMethods.getByte();
//        duyêt vào list nhân viên
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho nhân viên thứ " + (i + 1));
            Employee employee = inputData(true);
//            them vao list nhan vien
            employeeList.add(employee);
        }
        System.out.println("Đã thêm thành công " + count + " nhân viên");
    }

    @Override
    public void editElement() {
        System.out.println("Nhập mã nhân viên cần sửa thông tin");
        String idEdit = InputMethods.getString();
        Employee employeeEdit = findById(idEdit);
        if (employeeEdit == null) {
            System.err.println("Khong tim thay");
        } else {
            // hiển thi thông tin cũ
            System.out.println("thông tin cũ là :");
            System.out.println(employeeEdit);
            System.out.println("Nhập thông tin mới");
            employeeEdit = inputData(false);
            employeeEdit.setEmployeeId(idEdit); // ko thay đổi id
            // set nó lại vào danh sách
            employeeList.set(employeeList.indexOf(findById(idEdit)), employeeEdit);
            System.out.println("Đã cập nhật thông tin");
        }
    }

    @Override
    public void deleteElement() {
        System.out.println("Nhập id của nhân viên cần xóa");
        String idDel = InputMethods.getString();
        Employee employeeDel = findById(idDel);
        if (employeeDel == null) {
            System.err.println("Khong tim thay");
        } else {
            employeeList.remove(employeeDel);
            System.out.println("Xóa thanh công");
        }
    }


    @Override
    public void displayElement() {
        for (Employee employee : employeeList) {
            System.out.print("Mã nhân viên :" + employee.getEmployeeId());
            System.out.println(" | Tên nhân viên :" + employee.getEmployeeName());
            System.out.println("--------------------");
        }
    }

    @Override
    public Employee inputData(boolean isAdd) {
        Employee newEmpl = new Employee();
        if (isAdd) {
            System.out.println("Nhập mã nhân viên");
            newEmpl.setEmployeeId(InputMethods.getString());
        }
        System.out.println("Nhập tên nhân viên");
        newEmpl.setEmployeeName(InputMethods.getString());
        System.out.println("Nhập ngày tháng năm sinh nhân viên");
        newEmpl.setBirthday(InputMethods.getDate());
        System.out.println("Nhập giới tinh nhân viên");
        newEmpl.setSex(InputMethods.getBoolean());
        System.out.println("Nhập lương nhân viên");
        newEmpl.setSalary(InputMethods.getDouble());
        System.out.println("Nhập người quản lí ");
        newEmpl.setManager(inputManager());
        System.out.println("Nhập phòng ban");
        newEmpl.setDepartment(inputDepm());
        return newEmpl;
    }

    public Employee inputManager() {
        Employee newManager = new Employee();
        System.out.println("Nhập tên quản lí ");
        newManager.setEmployeeName(InputMethods.getString());
        return newManager;
    }

    public Department inputDepm() {
        Department newDepartment = new Department();
        System.out.println("Nhập mã phòng ban");
        String idDep = InputMethods.getString();
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentId() == idDep) {
                newDepartment = departmentList.get(i);
                departmentList.get(i).setTotalMembers(getTotalMembers() + 1);
            } else {
                System.out.println("Phòng ban không tồn tại");
            }
        }
        return newDepartment;
    }
}
