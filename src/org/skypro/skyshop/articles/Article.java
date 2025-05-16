package org.skypro.skyshop.articles;

import java.util.Objects;

public class Article implements Searchable {
    private String articleTitle;
    private String textOfTheArticle;

    public Article(String articleTitle, String textOfTheArticle) {
        this.articleTitle = articleTitle;
        this.textOfTheArticle = textOfTheArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleTitle, article.articleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleTitle);
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
