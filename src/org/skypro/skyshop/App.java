package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = getProductBasket();
        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места: ");
        productBasket.addProduct(new SimpleProduct("Конфеты", 500));
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
        productBasket.addProduct(new SimpleProduct("Сыр", 250));
        productBasket.addProduct(new DiscountedProduct("Масло", 280, 20));
        productBasket.addProduct(new FixPriceProduct("Хлеб"));
        productBasket.addProduct(new FixPriceProduct("Кефир"));
        productBasket.addProduct(new DiscountedProduct("Колбаса", 350, 15));

        return productBasket;
    }
}
