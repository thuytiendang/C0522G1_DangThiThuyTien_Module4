package com.casestudy.dto;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.customer.CustomerType;

import javax.validation.GroupSequence;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

interface First {
}

interface Second {
}
@GroupSequence(value = {CustomerDto.class, First.class, Second.class})
public class CustomerDto {
    private int customerId;

    @NotBlank(groups = First.class)
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Invalid format (ex: Đặng Thị Thủy Tiên)", groups = Second.class)
    private String customerName;

    @NotBlank(groups = First.class)
    @Pattern(regexp = "^(?:(?:31(/|-|.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/|-|.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|" +
            "[2-9]\\d)?\\d{2})$|^(?:29(/|-|.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|" +
            "[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/|-|.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]" +
            "\\d)?\\d{2})$", message = "Invalid day", groups = Second.class)
    private String customerBirthday;

    @NotBlank(groups = First.class)
    private String customerGender;

    @NotBlank(groups = First.class)
    @Pattern(regexp = "^(\\d{9}|\\d{12})$", message = "Invalid Id card (ex: 206236476)", groups = Second.class)
    private String customerIdCard;

    @NotBlank(groups = First.class)
    @Pattern(regexp = "^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$", message = "Invalid phone number (ex: 0905849025)", groups = Second.class)
    private String customerPhone;

    @NotBlank(groups = First.class)
    @Email(message = "invalid email (ex: thuytiendang2003@gmail.com)", groups = Second.class)
    private String customerEmail;

    @NotBlank(groups = First.class)
    private String customerAddress;

    private boolean isDelete;

    private CustomerType customerType;

    private Set<Contract> contracts;

    public CustomerDto() {
    }

    public CustomerDto(int customerId, String customerName, String customerBirthday, String customerGender,
                       String customerIdCard, String customerPhone, String customerEmail, String customerAddress,
                       boolean isDelete, CustomerType customerType, Set<Contract> contracts) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.isDelete = isDelete;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
