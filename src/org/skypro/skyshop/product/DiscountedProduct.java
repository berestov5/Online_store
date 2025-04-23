package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountInPercent;

    public DiscountedProduct(String nameProduct, int basePrice, int discountInPercent) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discountInPercent = discountInPercent;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discountInPercent) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "<" + super.getName() + ">: " +
                "<" + getPrice() + ">" +
                "(" + discountInPercent + "%)";
    }
}
