package baitaptonghop.business.entity;

import baitaptonghop.business.config.Config;
import baitaptonghop.business.config.InputMethods;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private LocalDate birthday;
    private boolean sex;
    private double salary;
    private Employee manager;
    private Department department;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, LocalDate birthday, boolean sex, double salary, Employee manager, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
//    Nhập dữ liệu cho nhân viên
    public void inputData(boolean isAdd, List<Employee>employeeList,List<Department>departmentList){
        if (isAdd){
            this.employeeId = getInputEmployeeId(employeeList);
        }
        this.employeeName = getInputEmployeeName();
        this.birthday = getInputBirthDay();
        this.salary = InputMethods.getDouble();
        this.sex = InputMethods.getBoolean();
        System.out.println("Nhân viên này có cần quản lí hay không?");
        System.out.println("1. Có");
        System.out.println("2. Không");
        while (true){
            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    this.manager = getInputManager(employeeList);
                    break;
                case 2:
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ , vui lòng nhập lại");
            }
            if (choice == 1 || choice == 2){
                break;
            }
        }
        this.department = getInputDepartment(departmentList);
    }

    private Department getInputDepartment(List<Department> departmentList) {
        System.out.println("Danh sách phòng ban");
//        hiển thị danh sách phòng ban
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.printf("stt : %d | Name : %-15s | \n",i+1,departmentList.get(i).getDepartmentName());
        }
        while (true){
            System.out.println("Nhâp vào vị trí phòng ban theo stt");
            int index = InputMethods.getInteger();
            if (index>=1 && index <= departmentList.size()){
                Department department1 = departmentList.get(index-1);
//                tăng số nhân viên lên 1
                department1.setTotalMembers(department1.getTotalMembers()+1);
                return department1;
            }
            System.err.println("Vị trí nhập không hợp lệ, vui lòng nhập giá trị hợp lệ!");
        }
    }

    private Employee getInputManager(List<Employee> managerList) {
//        Hiển thị danh sách nhân viên và quản lí
        System.out.println("Danh sách quản lí");
        for (int i = 0; i < managerList.size(); i++) {
            System.out.printf("stt : %%d | Name : %-15s | \n",i+1,managerList.get(i).employeeName);
        }
//        chọn quản lí trong danh sách nhân viên và quản lí
        while (true){
            System.out.println("Nhập vào quản lí của nhân viên (theo stt)");
            int index = InputMethods.getInteger();
            if (index>=1 && index<=managerList.size()){ // số nhập vào phải nằm trong số nv đang tồn tại
                return managerList.get(index-1);
            }
            System.err.println("Vị trí nhập không hợp lệ, vui lòng nhập vị trí hợp lệ");
        }
    }

    private LocalDate getInputBirthDay() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Nhập ngày sinh dd/MM/yyyy");
            String employeeBirthDayInput = scanner.nextLine();
            try {
                return LocalDate.parse(employeeBirthDayInput, Config.DTF);
            }catch (DateTimeParseException e){
                System.err.println("Không đúng định dạng dd/MM/yyyy");
            }
        }
    }

    private String getInputEmployeeName() {
        System.out.println("Nhập tên nhân viên");
        return InputMethods.getString();
    }

    //  Nhập mã nhân viên có bắt đầu bằng E và dài 5 kí tự
    private String getInputEmployeeId(List<Employee> employeeList) {
        final String idRegex = "^E\\w{4}$";
        while (true){
            System.out.println("Nhập mã nhân viên");
            String employeeIdInput = InputMethods.getString();
            if (employeeIdInput.matches(idRegex)){
//                đúng định dạng yêu cầu -> kiểm tra trùng lặp
                if (employeeList.stream().noneMatch(id->id.getEmployeeId().equals(employeeIdInput))){
//                    ko trùng lặp
                    return employeeIdInput;
                }
//                trùng lặp thì thông báo
                System.err.println("Mã nhân viên đã tồn tại, vui lòng nhập mã khác");
            }else{
                System.err.println("Không đúng đinh dạng (E____)");
            }
        }
    }
    public void displayNameId(){
        System.out.printf("| ID : %-5s | Name : %-15s |\n",
                employeeId,employeeName);
        System.out.println("===============================================");
    }
    public void displayData(){
        System.out.printf("| ID : %-5s | Name : %-15s | DoB : %-10s | Sex : %-3s | Salary : %-10s | Manager: %-15s | Department : %-15s |\n",
                employeeId,employeeName,birthday.format(Config.DTF),sex?"Nam":"Nữ",salary,manager!=null?manager.getEmployeeName():"null",department.getDepartmentName());
        System.out.println("------------------------------------------------------------------");
    }
}
