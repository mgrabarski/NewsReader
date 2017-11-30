package mateusz.grabarski.newsreader;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import mateusz.grabarski.newsreader.model.GetArticlesResponse;
import mateusz.grabarski.newsreader.networking.NewsAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView newsList;
    private CoordinatorLayout mCoordinatorLayout;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsList = findViewById(R.id.activity_main_rv);
        newsList.setLayoutManager(new LinearLayoutManager(this));
        mProgressBar = findViewById(R.id.activity_main_progress_bar);


        mCoordinatorLayout = findViewById(R.id.activity_main_coordinator_layout);

        Call<GetArticlesResponse> call = NewsAPI.getApi().getArticles("abc-news");
        call.enqueue(new Callback<GetArticlesResponse>() {
            @Override
            public void onResponse(Call<GetArticlesResponse> call, Response<GetArticlesResponse> response) {

                mProgressBar.setVisibility(View.GONE);

                showAPISnack();

                NewsStore.setNewsArticles(response.body().getArticles());

                final NewsAdapter adapter = new NewsAdapter(NewsStore.getNewsArticles());

                newsList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GetArticlesResponse> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }

    private void showAPISnack() {
        Snackbar.make(mCoordinatorLayout, "Powered by NewsApi.org ", Snackbar.LENGTH_LONG)
                .setAction("Visit", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        displayNewsApi();
                    }
                }).show();
    }

    private void displayNewsApi() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://newsapi.org")));
    }
}
