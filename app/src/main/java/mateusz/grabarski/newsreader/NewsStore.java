package mateusz.grabarski.newsreader;

import java.util.ArrayList;
import java.util.List;

import mateusz.grabarski.newsreader.model.NewsArticle;

/**
 * Created by MGrabarski on 25.11.2017.
 */

public class NewsStore {

    private static List<NewsArticle> newsArticles = new ArrayList<>();

    public static List<NewsArticle> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<NewsArticle> newsArticles) {
        NewsStore.newsArticles = newsArticles;
    }
}
