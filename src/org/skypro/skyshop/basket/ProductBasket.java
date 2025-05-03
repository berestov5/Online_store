package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private List<Product> productsList = new LinkedList<>();

    public void addProduct(Product productAdd) {
        productsList.add(productAdd);
    }

    public List removeProductByName(String name) {
        List<Product> removeProduct = new LinkedList<>();
        Iterator<Product> iterator = productsList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removeProduct.add(product);
                iterator.remove();
            }
        }

        if (removeProduct.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removeProduct;
    }

    public int totalCostOfTheProductBasket() {
        int sum = 0;
        for (Product product : productsList) {
            sum += product.getPrice();

        }
        return sum;
    }

    public int quantitySpecialGoods() {
        int count = 0;
        for (Product product : productsList) {
            if (product.isSpecial() == true) {
                count++;
            }
        }
        return count;
    }

    public void printProductBasket() {
        for (Product product : productsList) {
            System.out.println(product);
        }

        if (productsList.isEmpty()) {
            System.out.println("в корзине пусто.");
        } else {
            System.out.printf("Итого: %d \nСпециальных товаров: %d\n", totalCostOfTheProductBasket(), quantitySpecialGoods());
        }
    }

    public boolean searchProductInBasket(String name) {
        for (Product product : productsList) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void completeCleaningOfTheProductBasket() {
        productsList.clear();
    }
}
