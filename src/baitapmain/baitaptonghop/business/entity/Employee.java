package baitapmain.baitaptonghop.business.entity;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private String employeeId;
    private String employeeName;
    private Date birthday;
    private boolean sex;
    private Double salary;
    private Employee manager;
    private Department department;

    public Employee() {
    }

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public Employee(String employeeId, String employeeName, Date birthday, boolean sex, Double salary, Employee manager, Department department) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", salary=" + salary +
                ", manager=" + manager +
                ", department=" + department +
                '}';
    }
}
