package models;

public class jobinfo {
    private String empoyeeid;
    private float salary;
    private String department;
    private String joindate;
    public jobinfo(String empoyeeid, float salary, String department, String joindate) {
        this.empoyeeid = empoyeeid;
        this.salary = salary;
        this.department = department;
        this.joindate = joindate;
    }
    public String getEmpoyeeid() {
        return empoyeeid;
    }
    public void setEmpoyeeid(String empoyeeid) {
        this.empoyeeid = empoyeeid;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getJoindate() {
        return joindate;
    }
    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }
}
