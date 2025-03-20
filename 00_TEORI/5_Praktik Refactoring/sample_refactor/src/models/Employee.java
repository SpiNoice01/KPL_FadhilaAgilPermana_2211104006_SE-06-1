package models;
public class Employee {
    private String name;
    private String phone;
    private String adress;
    private String birthCity;
    // private int birthYear;
    // private int birthMonth;
    // private int birthDay;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String emergencyContactAddress;
    private String employeeId;
    private Float salary;
    // private int department ; 1; HR, 2; IT, 3; Finance
    private String department;
    private String joinDate;


    public Employee(String name, String phone, String adress, String birthCity,
            String emergencyContactName, String emergencyContactPhone, String emergencyContactAddress,
            String employeeId, Float salary, String department, String joinDate) {
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.birthCity = birthCity;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
        this.emergencyContactAddress = emergencyContactAddress;
        this.employeeId = employeeId;
        this.salary = salary;
        this.department = department;
        this.joinDate = joinDate;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAdress() {
        return adress;
    }


    public void setAdress(String adress) {
        this.adress = adress;
    }


    public String getBirthCity() {
        return birthCity;
    }


    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }


    public String getEmergencyContactName() {
        return emergencyContactName;
    }


    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }


    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }


    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }


    public String getEmergencyContactAddress() {
        return emergencyContactAddress;
    }


    public void setEmergencyContactAddress(String emergencyContactAddress) {
        this.emergencyContactAddress = emergencyContactAddress;
    }


    public String getEmployeeId() {
        return employeeId;
    }


    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    public Float getSalary() {
        return salary;
    }


    public void setSalary(Float salary) {
        this.salary = salary;
    }


    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public String getJoinDate() {
        return joinDate;
    }


    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}

