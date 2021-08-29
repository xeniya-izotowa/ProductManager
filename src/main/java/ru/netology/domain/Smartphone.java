package ru.netology.domain;

public class Smartphone extends Product {
    private String manufactured;

    public Smartphone() {

    }

    public Smartphone(int id, String name, int price, String manufactured) {
        super(id, name, price);
        this.manufactured = manufactured;
    }

    public Smartphone(String manufactured) {
        this.manufactured = manufactured;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }
}
