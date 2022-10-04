package com.asd.demo.pointSystem;

import javax.persistence.*;

@Entity
@Table(name = "point_system")
public class PointSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 自动生成ID
    private  Integer pointSystemID;

    @Column(name = "userID")
    private Integer userID;


    @Column(nullable = false, unique = false, length = 45, name = "point_number")
    private  Integer pointNumber;


    public Integer getPointSystemID() {
        return pointSystemID;
    }

    public void setPointSystemID(Integer pointSystemID) {
        this.pointSystemID = pointSystemID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getPointNumber() {
        return pointNumber;
    }

    public void setPointNumber(Integer pointNumber) {
        this.pointNumber = pointNumber;
    }

    @Override
    public String toString() {
        return "PointSystem{" +
                "pointSystemID=" + pointSystemID +
                ", userID=" + userID +
                ", pointNumber=" + pointNumber +
                '}';
    }
}
