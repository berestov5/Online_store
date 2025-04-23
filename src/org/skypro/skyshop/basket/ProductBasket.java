package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] productsArray = new Product[5];

    public void addProduct(Product productAdd) {
        boolean flag = true;
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i] == null) {
                productsArray[i] = productAdd;
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Невозможно добавить продукт!");
        }
    }

    public int totalCostOfTheProductBasket() {
        int sum = 0;
        for (Product product : productsArray) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public int quantitySpecialGoods() {
        int count = 0;
        for (Product product : productsArray) {
            if (product != null && product.isSpecial() == true) {
                count++;
            }
        }
        return count;
    }

    public void printProductBasket() {
        boolean arrayIsEmpty = true;
        for (Product product : productsArray) {
            if (product != null) {
                System.out.println(product);
                arrayIsEmpty = false;
            }
        }
        if (arrayIsEmpty == true) {
            System.out.println("в корзине пусто.");
        } else {
            System.out.printf("Итого: %d \nСпециальных товаров: %d\n", totalCostOfTheProductBasket(), quantitySpecialGoods());
        }
    }

    public boolean searchProductInBasket(String name) {
        for (Product product : productsArray) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void completeCleaningOfTheProductBasket() {
        Arrays.fill(productsArray, null);
    }
}
