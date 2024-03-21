package baitapmain.baitaptonghop.business.entity;

public class Department {
    private String departmentId;
    private String departmentName;
    private int totalMembers;

    public Department() {
        this.totalMembers=0;
    }

    public Department(String departmentId, String departmentName, int totalMembers) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = 0;
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

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", totalMembers=" + totalMembers +
                '}';
    }
}
