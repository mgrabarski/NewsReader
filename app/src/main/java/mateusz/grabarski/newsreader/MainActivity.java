package mateusz.grabarski.newsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import mateusz.grabarski.newsreader.model.GetArticlesResponse;
import mateusz.grabarski.newsreader.networking.NewsAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsList = findViewById(R.id.activity_main_rv);
        newsList.setLayoutManager(new LinearLayoutManager(this));

        Call<GetArticlesResponse> call = NewsAPI.getApi().getArticles("abc-news");
        call.enqueue(new Callback<GetArticlesResponse>() {
            @Override
            public void onResponse(Call<GetArticlesResponse> call, Response<GetArticlesResponse> response) {

                NewsStore.setNewsArticles(response.body().getArticles());

                final NewsAdapter adapter = new NewsAdapter(NewsStore.getNewsArticles());

                newsList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GetArticlesResponse> call, Throwable t) {

            }
        });
    }
}
