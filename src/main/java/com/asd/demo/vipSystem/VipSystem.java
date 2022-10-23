package com.asd.demo.vipSystem;

import javax.persistence.*;

@Entity
@Table(name = "vipSystem")
public class VipSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 自动生成ID
    private Integer vipID;

    @Column(nullable = false, unique = false, length = 45) //
    private Integer userID;

    public Integer getVipID() {
        return vipID;
    }

    public void setVipID(Integer vipID) {
        this.vipID = vipID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "VipSystem{" +
                "vipID=" + vipID +
                ", userID=" + userID +
                '}';
    }
}
