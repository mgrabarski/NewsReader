package mateusz.grabarski.newsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mateusz.grabarski.newsreader.model.NewsArticle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<NewsArticle> newsArticles = new ArrayList<>();
        newsArticles.add(new NewsArticle("title 1", "details 1", "http://miastoknurow.pl/wp-content/uploads/2015/03/policja_radiowoz_01.jpg", "today", "http://miastoknurow.pl/48268,w-naszym-rejonie-wszczeto-6807-dochodzen-i-sledztw.html"));
        newsArticles.add(new NewsArticle("title 2", "details 2", "http://miastoknurow.pl/wp-content/uploads/2015/03/policja_radiowoz_01.jpg", "today", "http://miastoknurow.pl/48268,w-naszym-rejonie-wszczeto-6807-dochodzen-i-sledztw.html"));
        newsArticles.add(new NewsArticle("title 3", "details 3", "http://miastoknurow.pl/wp-content/uploads/2015/03/policja_radiowoz_01.jpg", "today", "http://miastoknurow.pl/48268,w-naszym-rejonie-wszczeto-6807-dochodzen-i-sledztw.html"));
        newsArticles.add(new NewsArticle("title 4", "details 4", "http://miastoknurow.pl/wp-content/uploads/2015/03/policja_radiowoz_01.jpg", "today", "http://miastoknurow.pl/48268,w-naszym-rejonie-wszczeto-6807-dochodzen-i-sledztw.html"));

        NewsStore.setNewsArticles(newsArticles);

        newsList = findViewById(R.id.activity_main_rv);
        newsList.setLayoutManager(new LinearLayoutManager(this));

        NewsAdapter adapter = new NewsAdapter(NewsStore.getNewsArticles());

        newsList.setAdapter(adapter);
    }
}
