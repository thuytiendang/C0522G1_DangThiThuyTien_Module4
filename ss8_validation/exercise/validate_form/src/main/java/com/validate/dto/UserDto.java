package com.validate.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserDto implements Validator {

    private int id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private int age;
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstname, String lastname, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String number = userDto.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        ValidationUtils.rejectIfEmpty(errors, "firstname", "firstname.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastname", "lastname.empty");
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
        if (userDto.getFirstname().length()<5 || userDto.getFirstname().length()>45){
            errors.rejectValue("firstname", "firstname.length");
        }
        if (userDto.getLastname().length()<5 || userDto.getLastname().length()>45){
            errors.rejectValue("lastname", "lastname.length");
        }
        if (userDto.getAge() < 18){
            errors.rejectValue("age", "age.min");
        }
        if (!userDto.getEmail().matches("(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]{2,}(\\.[A-Za-z0-9]{2,}){1,2}$)")){
            errors.rejectValue("email", "email.regex");
        }
    }
}
