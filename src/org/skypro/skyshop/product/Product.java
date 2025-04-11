package org.skypro.skyshop.product;

public abstract class Product {
    private String nameProduct;


    public Product(String nameProduct) {
        this.nameProduct = nameProduct;

    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPrice();

    public boolean isSpecial(){
        return false;
    }

    @Override
    public String toString() {
        return "имя продукта: " + nameProduct;
    }
}
