package com.asd.demo.vip;

import javax.persistence.*;

@Entity
@Table(name = "vip_user")
public class VipUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 自动生成ID
    private Integer vipID;

    @Column(nullable = false, unique = true, length = 45) // email is require
    private String email;

    @Column(unique = false, length = 45, name="vip_name")
    private String vipName;

    public Integer getVipID() {
        return vipID;
    }

    public void setVipID(Integer vipID) {
        this.vipID = vipID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    @Override
    public String toString() {
        return "VipUser{" +
                "vipID=" + vipID +
                ", email='" + email + '\'' +
                ", vipName='" + vipName + '\'' +
                '}';
    }
}
