package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.sql.Array;
import java.util.*;

public class ProductBasket {
    //    private List<Product> productsList = new LinkedList<>();
    private Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product productAdd) {
        productsMap.computeIfAbsent(productAdd.getName(), k -> new ArrayList<>()).add(productAdd);
    }

    public List removeProductByName(String name) {
        List<Product> removeProduct = new LinkedList<>();
        Iterator<Product> iterator = productsMap.getOrDefault(name, removeProduct).iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removeProduct.add(product);
            }
        }
        productsMap.remove(name);

        if (removeProduct.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removeProduct;
    }

    public int totalCostOfTheProductBasket() {
        int sum = 0;
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                sum += product.getPrice();

            }
        }
        return sum;
    }

    public int quantitySpecialGoods() {
        int count = 0;
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                if (product.isSpecial()) count++;
            }
        }
        return count;
    }

    public void printProductBasket() {
        for (Map.Entry product : productsMap.entrySet()) {
            System.out.println(product);
        }

        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто.");
        } else {
            System.out.printf("Итого: %d \nСпециальных товаров: %d\n", totalCostOfTheProductBasket(), quantitySpecialGoods());
        }
    }

    public boolean searchProductInBasket(String name) {
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void completeCleaningOfTheProductBasket() {
        productsMap.clear();
    }
}

