package mateusz.grabarski.newsreader;

import java.util.ArrayList;
import java.util.List;

import mateusz.grabarski.newsreader.model.Article;

/**
 * Created by MGrabarski on 25.11.2017.
 */

public class NewsStore {

    private static List<Article> newsArticles = new ArrayList<>();

    public static List<Article> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<Article> newsArticles) {
        NewsStore.newsArticles = newsArticles;
    }
}
