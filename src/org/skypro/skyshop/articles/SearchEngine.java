package org.skypro.skyshop.articles;

import org.skypro.skyshop.exception.BestResultNotFound;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> searchableList = new ArrayList<>();

    public Searchable searchTheBestElement(String search) throws BestResultNotFound {
        int indexBestElement = 0, countMax = 0, indexElement = 0;
        for (Searchable el : searchableList) {
            int index = 0, count = 0;
            int indexSubstring = el.getSearchTerm().indexOf(search, index);
            indexElement++;
            while (indexSubstring != -1) {
                count++;
                index = indexSubstring + search.length();
                indexSubstring = el.getSearchTerm().indexOf(search, index);

            }

            if (count > 0 && countMax < count) {
                countMax = count;
                indexBestElement = indexElement;
            }
        }

        if (countMax == 0) {
            throw new BestResultNotFound("Для запроса " + "\"" + search + "\"" + " не нашлось подходящей статьи.");
        } else {
            return searchableList.get(--indexBestElement);
        }
    }

    public Map<String, Searchable> search(String text) {
        Map<String, Searchable> treeMapResult = new TreeMap<>();

        for (Searchable searchable : searchableList) {
            if (searchable != null && searchable.getSearchTerm().contains(text)) {
                treeMapResult.put(searchable.getName(), searchable);
            }
        }
        return treeMapResult;
    }

    public void add(Searchable searchable) {
        searchableList.add(searchable);
    }

    @Override
    public String toString() {
        return searchableList.toString();
    }
}
