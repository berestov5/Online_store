package org.skypro.skyshop.articles;

public class Article implements Searchable {
    private String articleTitle;
    private String textOfTheArticle;

    public Article(String articleTitle, String textOfTheArticle) {
        this.articleTitle = articleTitle;
        this.textOfTheArticle = textOfTheArticle;
    }

    @Override
    public String toString() {
        return articleTitle + " " + textOfTheArticle;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return articleTitle;
    }
}
