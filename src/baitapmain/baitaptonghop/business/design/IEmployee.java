package baitaptonghop.business.design;

import baitaptonghop.business.entity.Employee;

public interface IEmployee extends IGeneric<Employee,String>{
//    những chức năng của employee
//    hiện chi tiết empl
    void detailInfo();
//    hiện danh sách nhân viên theo phòng
    void getListEmployeeByDepartment();
//    tính trung bình nhân viên trên mỗi phòng
    void getAvgEmployeePerDepartment();
//    tìm quản lí có nhiều nv nhất
    void findTopManager();
//    tìm 5 nhân viên già nhất
    void findTop5oldest();
//    tìm 5 nhân viên có lương cao nhất
    void findTop5HighestSalary();
//    tìm 5 phòng đông nhất
    void findTop5DepartmentCrowded();

}
