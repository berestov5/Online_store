package org.skypro.skyshop.product;

import org.skypro.skyshop.articles.Searchable;

public abstract class Product implements Searchable {
    private String nameProduct;


    public Product(String nameProduct) {
        this.nameProduct = nameProduct;

    }

    @Override
    public String getSearchTerm() {
        return nameProduct;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return nameProduct;
    }

//    public String getNameProduct() {
//        return nameProduct;
//    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "имя продукта: " + nameProduct;
    }
}
