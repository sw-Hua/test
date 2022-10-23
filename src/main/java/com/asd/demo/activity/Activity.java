package com.asd.demo.activity;

import javax.persistence.*;

@Entity
@Table(name="voucher")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 自动生成ID
    private Integer voucherID;

    @Column(nullable = false, unique = false, length = 45) //
    private Integer userID;

    @Column(unique = false, length = 45, name="productName")
    private String productName;

    public Integer getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(Integer voucherID) {
        this.voucherID = voucherID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "voucherID=" + voucherID +
                ", userID=" + userID +
                ", productName='" + productName + '\'' +
                '}';
    }
}
