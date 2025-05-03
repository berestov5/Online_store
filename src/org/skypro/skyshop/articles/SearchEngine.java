package org.skypro.skyshop.articles;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchableList = new ArrayList<>();
    private int count;


    public Searchable searchTheBestElement(String search) throws BestResultNotFound {
        int indexBestElement = 0, countMax = 0;
        for (int i = 0; i < searchableList.size(); i++) {
            int index = 0, count = 0;
            int indexSubstring = searchableList.get(i).getSearchTerm().indexOf(search, index);

            while (indexSubstring != -1) {
                count++;
                index = indexSubstring + search.length();
                indexSubstring = searchableList.get(i).getSearchTerm().indexOf(search, index);
            }

            if (count > 0 && countMax < count) {
                countMax = count;
                indexBestElement = i;
            }
        }

        if (countMax == 0) {
            throw new BestResultNotFound("Для запроса " + "\"" + search + "\"" + " не нашлось подходящей статьи.");
        } else {
            return searchableList.get(indexBestElement);
        }
    }

    public List<Searchable> search(String text) {
        List<Searchable> arraylistResult = new ArrayList<>();

        for (Searchable searchable : searchableList) {
            if (searchable != null && searchable.getSearchTerm().contains(text)) {
                arraylistResult.add(searchable);
            }
        }
        return arraylistResult;
    }

    public void add(Searchable searchable) {
        searchableList.add(searchable);
    }

    @Override
    public String toString() {
        return searchableList.toString();
    }
}
