package com.asd.payment;

public class Food {
    private int id;
    private String foodname;
    private String type;
    private int price;
    int num;

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public String getFoodname() {
        return foodname;
    }

    public Food(){

    }
    public Food(int id, String foodname, String type, int price,int num){
        this.id = id;
        this.foodname = foodname;
        this.type = type;
        this.price = price;
        this.num = num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFoodName(String foodname) {
        this.foodname = foodname;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getfoodname() {
        return foodname;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

}
