package com._520.leetcode.test;

public class Book {
    private String name;    // 图书的名称
    private int stock;      // 库存
    private int price;      // 价格

    public Book(String name, int stock, int price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
