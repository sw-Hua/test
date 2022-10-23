package com.asd.demo.portfolio;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="customer")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 自动生成ID
    private Integer ID;

    @Column(nullable = false, unique = false, length = 45, name="user_ID") //
    private Integer userID;

    @Column(nullable = false, unique = false, length = 45, name="user_name") //
    private String userName;

    @Column(nullable = false, unique = false, length = 45, name="user_email") //
    private String userEmail;

    @Column(unique = false, length = 45, name="address")
    private String Address;

    @Column(unique = false, length = 45, name="phone")
    private Integer Phone;

    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    private boolean enabled;

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "ID=" + ID +
                ", userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone=" + Phone +
                ", verificationCode='" + verificationCode + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
