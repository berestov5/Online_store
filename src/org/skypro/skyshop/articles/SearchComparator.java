package org.skypro.skyshop.articles;

import java.util.Comparator;

public class SearchComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lengthSearchable = Integer.compare(o2.getName().length(), o1.getName().length());
        if (lengthSearchable == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return lengthSearchable;
    }
}