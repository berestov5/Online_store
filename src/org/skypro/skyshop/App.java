package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.SimpleProduct;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = getProductBasket();

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

        System.out.println("Изменения по домашке - Java Collections Framework: List");
        ProductBasket productBasket2 = getProductBasket();
        System.out.println("Удаление продукта по имени и возврат массива удаленных продуктов: " + productBasket2.removeProductByName("Хлеб"));
        System.out.println("Печать содержимого корзины после удаления продукта: ");
        productBasket2.printProductBasket();
        System.out.println("Удаление несуществующего продукта");
        productBasket2.removeProductByName("неХлеб");
        System.out.println("Печать содержимого корзины после удаления несуществующего продукта: ");
        productBasket2.printProductBasket();

        SearchEngine searchEngine = getSearchEngine();
        System.out.println("Список заполненый: \n" + searchEngine);


        System.out.println(searchEngine.search("Масло"));

        printArraySearch(searchEngine, "Сыр");
        printArraySearch(searchEngine, "мясо");
        printArraySearch(searchEngine, "Доярки");
        printArraySearch(searchEngine, "инкогнито");
        printArraySearch(searchEngine, "кефир");

        System.out.println("Демонстрация проверки \"неправильных\" продуктов:");
        showProductWitsErrors();

        System.out.println("Демонстрация нового метода поиска:");
        demoSearchTheBestElement("Хлеб");
        demoSearchTheBestElement("Икра");

        SearchEngine searchEngineHashSet = getSearchEngineHashSet();
        System.out.println("Вывод отсортированного множества HashSet : \n" + searchEngineHashSet.search("Хле"));
    }

    static void demoSearchTheBestElement(String search) {
        SearchEngine searchEngine = getSearchEngine();
        try {
            System.out.println(searchEngine.searchTheBestElement(search));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    private static ProductBasket showProductWitsErrors() {
        ProductBasket productBasket = new ProductBasket();
        try {
            productBasket.addProduct(new SimpleProduct(null, 250));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            productBasket.addProduct(new SimpleProduct("Окунь", 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            productBasket.addProduct(new DiscountedProduct("Масло", 280, 120));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            productBasket.addProduct(new DiscountedProduct("Колбаса", 0, 15));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            productBasket.addProduct(new SimpleProduct("  ", 90));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            productBasket.addProduct(new DiscountedProduct("Колбаса", 350, 15));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return productBasket;
    }

    private static void printArraySearch(SearchEngine engine, String text) {
        System.out.println("Поиск по запросу - " + text);

        Set<Searchable> searchable = engine.search(text);
        if (searchable.isEmpty()) {
            System.out.println("Нечего не найдено!");
            return;
        }

        for (Searchable el : searchable) {
            if (el != null) {
                System.out.println(el.getName() + " " + el.getContentType());
            }
        }
    }

    private static ProductBasket getProductBasket() {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new SimpleProduct("Сыр", 250));
        productBasket.addProduct(new DiscountedProduct("Масло", 280, 20));
        productBasket.addProduct(new FixPriceProduct("Хлеб"));
        productBasket.addProduct(new FixPriceProduct("Кефир"));
        productBasket.addProduct(new DiscountedProduct("Колбаса", 350, 15));
        productBasket.addProduct(new SimpleProduct("Хлеб", 50));
        return productBasket;
    }

    private static SearchEngine getSearchEngine() {
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(new Article("Хлеб всему голова!!", "Урожайность пшеницы за полярным кругом бьет рекорды!"));
        searchEngine.add(new Article("Молочный рай.", "Доярки села Кукуева рапортуют..."));
        searchEngine.add(new Article("Космический кефир!", "Китай вывел спутник на орбиту земли используя двигатели на кефире."));
        searchEngine.add(new Article("Конические кони.", "Колбаса и вечность. Наблюдения."));
        searchEngine.add(new SimpleProduct("мясо", 500));
        searchEngine.add(new SimpleProduct("Сыр", 250));
        searchEngine.add(new DiscountedProduct("Масло", 280, 20));
        searchEngine.add(new FixPriceProduct("Хлеб"));
        searchEngine.add(new FixPriceProduct("Кефир"));
        searchEngine.add(new DiscountedProduct("Колбаса", 350, 15));
        searchEngine.add(new SimpleProduct("Хлеб", 50));
        return searchEngine;
    }

    private static SearchEngine getSearchEngineHashSet() {
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(new Article("Хлеб всему голова!!", "Урожайность пшеницы за полярным кругом бьет рекорды!"));
        searchEngine.add(new Article("Кто съел весь Хлеб?", "Криминальные разборки на пищекомбинате \"Хлебный\""));
        searchEngine.add(new FixPriceProduct("Хлеп"));
        searchEngine.add(new FixPriceProduct("Хлеб"));
        searchEngine.add(new SimpleProduct("Хлебушек", 50));
        searchEngine.add(new SimpleProduct("Хлебашек", 50));
        return searchEngine;
    }
}
