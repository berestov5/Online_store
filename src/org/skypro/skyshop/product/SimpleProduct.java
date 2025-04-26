package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int productPrice;

    public SimpleProduct(String nameProduct, int productPrice) {
        super(nameProduct);
        if(productPrice <= 0) throw new IllegalArgumentException("Цена продукта \"" + nameProduct + "\" должна быть больше нуля!");
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
        return "<" + super.getName() + ">: " +
                "<" + getPrice() + ">";
    }
}
