package mateusz.grabarski.newsreader.model;

/**
 * Created by MGrabarski on 25.11.2017.
 */

public class NewsArticle {

    private String title;
    private String details;
    private String imageUrl;
    private String time;
    private String articleUrl;

    public NewsArticle(String title, String details, String imageUrl, String time, String articleUrl) {
        this.title = title;
        this.details = details;
        this.imageUrl = imageUrl;
        this.time = time;
        this.articleUrl = articleUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }
}
