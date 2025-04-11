package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int productPrice;

    public SimpleProduct(String nameProduct, int productPrice) {
        super(nameProduct);
        this.productPrice = productPrice;
    }

    @Override
    public int getPrice() {
        return productPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "<" + super.getNameProduct() + ">: " +
                "<" + getPrice() + ">";
    }
}
