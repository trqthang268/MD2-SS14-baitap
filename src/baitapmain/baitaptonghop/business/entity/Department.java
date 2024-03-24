package baitaptonghop.business.entity;

import baitaptonghop.business.config.InputMethods;

import java.util.List;

public class Department {
    private String departmentId,departmentName;
    private int totalMembers; // giá trị mặc định của phòng là 0

    public Department() {
    }

    public Department(String departmentId, String departmentName, int totalMembers) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = totalMembers;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }
//    nhập dữ liệu phòng ban
    public void inputData(boolean isAdd,List<Department> departmentList){
        if (isAdd){
            this.departmentId = getInputDepartment(departmentList);
        }
        this.departmentName = getInputDepartmentName(departmentList);
    }
//    nhập đầu vào mã phòng có mã bắt đầu bằng D
    private String getInputDepartment(List<Department> departmentList){
        final String idRegex = "^D\\w{3}$";
        while (true){
            System.out.println("Nhập mã phòng ban ");
            String departmentIdInput = InputMethods.getString();
            if (departmentIdInput.matches(idRegex)){
                // kt đúng định dạng -> kiểm tra trùng lặp trong list
                if(departmentList.stream().noneMatch(id->id.getDepartmentId().equals(departmentIdInput))){
//                   không trùng lặp(noneMatch) return về mã phòng
                    return departmentIdInput;
                }
//                trùng lặp thì thông báo
                System.err.println("Mã phòng ban đã tồn tại, vui lòng nhập mã khác");
            }else{//không đúng đinh dạng
                System.err.println("Không đúng định dang (D___)");
            }
        }
    }
//    Nhập tên và kiểm tra trùng lặp
    private String getInputDepartmentName(List<Department> departmentList){
        while (true){
            System.out.println("Nhập tên phòng ban");
            String departmentNameInput = InputMethods.getString();
            if (!departmentNameInput.isBlank()){ // kiểm tra có rông
//                kiểm tra trùng lặp
                if (departmentList.stream().noneMatch(name->name.getDepartmentName().equals(departmentNameInput))){
//                    không trùng lặp thì trả về giá trị nameinput
                    return departmentNameInput;
                }
//                trùng lặp
                System.err.println("Tên phòng đã tồn tại, vui lòng nhập lại tên khác!");
            }else{
                System.err.println("Không được để trống");
            }
        }
    }

//    hiện danh sách phòng ban
    public void displayData(){
        System.out.printf("| ID : %-5s | Name : %-15s | TotalMembers : %-3s |\n",
                departmentId,departmentName,totalMembers);
        System.out.println("------------------------------------------------------------------------");
    }
}
