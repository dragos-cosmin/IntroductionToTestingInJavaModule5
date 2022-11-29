package com.monotonic.testing.m5.spring_xml;

public class Sale {
    private String product;
    private String store;
    private int number;
    private int pricePerItem;


    public Sale(String product, String store, int number, int pricePerItem) {
        this.product = product;
        this.store = store;
        this.number = number;
        this.pricePerItem = pricePerItem;
    }

    public String getProduct() {
        return product;
    }

    public String getStore() {
        return store;
    }

    public int getValue(){
        return number*pricePerItem;
    }


}
