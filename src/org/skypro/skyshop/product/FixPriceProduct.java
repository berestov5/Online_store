package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int FIX_PRICE = 30;

    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "<" + super.getName() + ">:" +
                " Фиксированная цена" +
                "<" + getPrice() + ">";
    }
}
