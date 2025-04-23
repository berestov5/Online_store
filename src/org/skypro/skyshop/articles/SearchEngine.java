package org.skypro.skyshop.articles;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] arraySearchable;
    private int count;


    public SearchEngine(int size) {
        this.arraySearchable = new Searchable[size];
    }

    public Searchable[] search(String text) {
        Searchable[] arrayResult = new Searchable[5];
        int counter = 0;
        for (Searchable searchable : arraySearchable) {
            if (counter >= 5) break;
            if (searchable != null && searchable.getSearchTerm().contains(text)) {
                arrayResult[counter++] = searchable;
            }
        }
        return arrayResult;
    }

    public void add(Searchable searchable) {
        if (count < arraySearchable.length) {
            arraySearchable[count] = searchable;
            count++;
        } else {
            System.out.println("Массив заполнен!");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arraySearchable);
    }
}
