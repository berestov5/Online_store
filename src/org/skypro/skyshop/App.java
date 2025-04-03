package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = getProductBasket();
        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места: ");
        productBasket.addProduct(new Product("Конфеты", 500));
        System.out.println("Печать содержимого корзины с несколькими товарами:");
        productBasket.printProductBasket();
        System.out.println("Получение стоимости корзины с несколькими товарами: " + productBasket.totalCostOfTheProductBasket());
        System.out.println("Поиск товара, который есть в корзине: " + productBasket.searchProductInBasket("Сыр"));
        System.out.println("Поиск товара, которого нет в корзине: " + productBasket.searchProductInBasket("Нету"));
        productBasket.completeCleaningOfTheProductBasket();
        System.out.print("Печать содержимого пустой корзины: ");
        productBasket.printProductBasket();
        System.out.println("Получение стоимости пустой корзины: " + productBasket.totalCostOfTheProductBasket());
        System.out.println("Поиск товара по имени в пустой корзине: " + productBasket.searchProductInBasket("Сыр"));
    }

    private static ProductBasket getProductBasket() {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new Product("Сыр", 250));
        productBasket.addProduct(new Product("Масло", 280));
        productBasket.addProduct(new Product("Хлеб", 50));
        productBasket.addProduct(new Product("Кефир", 90));
        productBasket.addProduct(new Product("Колбаса", 350));

        return productBasket;
    }
}
