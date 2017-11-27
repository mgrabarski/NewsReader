package mateusz.grabarski.newsreader.networking;

import mateusz.grabarski.newsreader.model.GetArticlesResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by MGrabarski on 26.11.2017.
 */

public class NewsAPI {

    public static final String API_KEY = "08ec34bb14214a74888373e82bcfd2a1";
    public static final String API_PATH = "https://newsapi.org/v2/";

    private static NewsServices newsServices = null;

    public static NewsServices getApi() {
        if (newsServices == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_PATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            newsServices = retrofit.create(NewsServices.class);
        }

        return newsServices;
    }

    public interface NewsServices {

        @GET("top-headlines?apiKey=" + API_KEY)
        Call<GetArticlesResponse> getArticles(@Query("sources") String sources);
    }
}
