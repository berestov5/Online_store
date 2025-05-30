package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

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

        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    private int quantitySpecialGoods() {
        return (int) productsMap.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printProductBasket() {
        productsMap.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

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

