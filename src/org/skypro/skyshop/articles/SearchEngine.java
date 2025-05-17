package org.skypro.skyshop.articles;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchableHashSet = new HashSet<>();

    public Searchable searchTheBestElement(String search) throws BestResultNotFound {
        Searchable bestElement = null;
        int countMax = 0;
        for (Searchable el : searchableHashSet) {
            int index = 0, count = 0;
            int indexSubstring = el.getSearchTerm().indexOf(search, index);

            while (indexSubstring != -1) {
                count++;
                index = indexSubstring + search.length();
                indexSubstring = el.getSearchTerm().indexOf(search, index);

            }

            if (count > 0 && countMax < count) {
                countMax = count;
                bestElement = el;
            }
        }

        if (countMax == 0) {
            throw new BestResultNotFound("Для запроса " + "\"" + search + "\"" + " не нашлось подходящей статьи.");
        } else {
            return bestElement;
        }
    }

    public Set<Searchable> search(String text) {
        Set<Searchable> treeSetResult = new TreeSet<>(new SearchComparator());

        for (Searchable searchable : searchableHashSet) {
            if (searchable != null && searchable.getSearchTerm().contains(text)) {
                treeSetResult.add(searchable);
            }
        }
        return treeSetResult;
    }

    public void add(Searchable searchable) {
        searchableHashSet.add(searchable);
    }

    @Override
    public String toString() {
        return searchableHashSet.toString();
    }
}
