package com.asd.demo.payment;

import javax.persistence.*;

@Entity
@Table(name="reward")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 自动生成ID
    private Integer rewardID;

    @Column(nullable = false, unique = false, length = 45) // email is require
    private Double discount;
    @Column(unique = false, length = 45, name="voucher_name")
    private String voucherName;

    public Integer getRewardID() {
        return rewardID;
    }

    public void setRewardID(Integer rewardID) {
        this.rewardID = rewardID;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "rewardID=" + rewardID +
                ", discount=" + discount +
                ", voucherName='" + voucherName + '\'' +
                '}';
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }
}
