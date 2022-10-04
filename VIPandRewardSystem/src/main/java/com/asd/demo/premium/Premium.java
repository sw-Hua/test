package com.asd.demo.premium;

import javax.persistence.*;

@Entity
@Table(name = "premium")
public class Premium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 自动生成ID
    @Column(nullable = true, length = 45, name = "premium_id")
    private Integer premiumID;

    @Column(nullable = false, length = 45, name = "userid")
    private Integer userID;

    @Column(unique = false, length = 45, name="vipid")
    private Integer vipID;


    public Integer getPremiumID() {
        return premiumID;
    }

    public void setPremiumID(Integer premiumID) {
        this.premiumID = premiumID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getVipID() {
        return vipID;
    }

    public void setVipID(Integer vipID) {
        this.vipID = vipID;
    }

    @Override
    public String toString() {
        return "Premium{" +
                "premiumID=" + premiumID +
                ", userID=" + userID +
                ", vipID=" + vipID +
                '}';
    }
}
