package com.casestudy.dto;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.employee.Division;
import com.casestudy.model.employee.EducationDegree;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.employee.Position;

import javax.validation.GroupSequence;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

interface First2 {
}

interface Second2 {
}
@GroupSequence(value = {EmployeeDto.class, First2.class, Second2.class})
public class EmployeeDto {
    private int employeeId;

    @NotBlank(groups = First2.class)
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Invalid format (ex: Đặng Thị Thủy Tiên)", groups = Second2.class)
    private String employeeName;

    @NotBlank(groups = First2.class)
    @Pattern(regexp = "^(?:(?:31(/|-|.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/|-|.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|" +
            "[2-9]\\d)?\\d{2})$|^(?:29(/|-|.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|" +
            "[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/|-|.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]" +
            "\\d)?\\d{2})$", message = "Invalid day", groups = Second2.class)
    private String employeeBirthday;

    @NotBlank(groups = First2.class)
    @Pattern(regexp = "^(\\d{9}|\\d{12})$", message = "Invalid Id card (ex: 206236476)", groups = Second2.class)
    private String employeeIdCard;

    @NotBlank(groups = First2.class)
    @Min(value = 0, message = "Salary must be greater than 0", groups = Second2.class)
    private double employeeSalary;

    @NotBlank(groups = First2.class)
    @Pattern(regexp = "^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$", message = "Invalid phone number (ex: 0905849025)", groups = Second2.class)
    private String employeePhone;

    @NotBlank(groups = First.class)
    @Email(message = "invalid email (ex: thuytiendang2003@gmail.com)", groups = Second.class)
    private String employeeEmail;

    @NotBlank(groups = First.class)
    private String employeeAddress;

    private boolean isDelete;

    private Division division;

    private EducationDegree educationDegree;

    private Position position;

    private Set<Contract> contracts;

    public EmployeeDto() {
    }

    public EmployeeDto(int employeeId, String employeeName, String employeeBirthday, String employeeIdCard, double employeeSalary,
                       String employeePhone, String employeeEmail, String employeeAddress, boolean isDelete, Division division,
                       EducationDegree educationDegree, Position position, Set<Contract> contracts) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.isDelete = isDelete;
        this.division = division;
        this.educationDegree = educationDegree;
        this.position = position;
        this.contracts = contracts;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
