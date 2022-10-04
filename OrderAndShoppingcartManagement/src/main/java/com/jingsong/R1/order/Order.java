package com.jingsong.R1.order;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OrderID;

    @Column(nullable = false, unique = true, name = "Account")
    private String CustomerEmail;

    @Column(length = 45)
    private String ProductName;

    @Column(nullable = false)
    private Integer Quantity;

    @Column(length = 15, nullable = false)
    private Double Price;

    public boolean isVip() {
        return Vip;
    }

    public void setVip(boolean vip) {
        Vip = vip;
    }

    private boolean Vip;

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderID=" + OrderID +
                ", CustomerEmail='" + CustomerEmail + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", Quantity=" + Quantity +
                ", Price=" + Price +
                '}';
    }
}
