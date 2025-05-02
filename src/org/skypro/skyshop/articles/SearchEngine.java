package org.skypro.skyshop.articles;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] arraySearchable;
    private int count;

    public SearchEngine(int size) {
        this.arraySearchable = new Searchable[size];
    }

    public Searchable searchTheBestElement(String search) throws BestResultNotFound {
        int indexBestElement = 0, countMax = 0;
        for (int i = 0; i < arraySearchable.length; i++) {
            int index = 0, count = 0;
            int indexSubstring = arraySearchable[i].getSearchTerm().indexOf(search, index);

            while (indexSubstring != -1) {
                count++;
                index = indexSubstring + search.length();
                indexSubstring = arraySearchable[i].getSearchTerm().indexOf(search, index);
            }

            if (count > 0 && countMax < count) {
                countMax = count;
                indexBestElement = i;
            }
        }

        if (countMax == 0) {
            throw new BestResultNotFound("Для запроса " + "\"" + search + "\"" + " не нашлось подходящей статьи.");
        } else {
            return arraySearchable[indexBestElement];
        }
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
