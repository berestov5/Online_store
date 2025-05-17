package org.skypro.skyshop.product;

import org.skypro.skyshop.articles.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private String nameProduct;


    public Product(String nameProduct) {
        if(nameProduct == null || nameProduct.isBlank()) throw new IllegalArgumentException("Наименование продукта не может быть null " +
                "или пустым, введите корректное наименование!");
        this.nameProduct = nameProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
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
