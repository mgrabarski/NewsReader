package mateusz.grabarski.newsreader;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mateusz.grabarski.newsreader.model.Article;
import mateusz.grabarski.newsreader.utils.DateUtils;

/**
 * Created by MGrabarski on 25.11.2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Article> newsArticles;

    public NewsAdapter(List<Article> newsArticles) {
        this.newsArticles = newsArticles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Article article = newsArticles.get(position);

        Picasso.with(holder.newsImage.getContext())
                .load(article.getUrlToImage())
                .fit()
                .centerCrop()
                .into(holder.newsImage);

        holder.title.setText(article.getTitle());
        holder.time.setText(DateUtils.formatApiDate(article.getPublishedAt()));
        holder.content.setText(article.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity.launch(v.getContext(), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView newsImage;
        TextView title, time, content;

        public ViewHolder(View itemView) {
            super(itemView);

            newsImage = (ImageView) itemView.findViewById(R.id.card_news_image);
            title = itemView.findViewById(R.id.card_news_title);
            time = itemView.findViewById(R.id.card_news_time);
            content = itemView.findViewById(R.id.card_news_content);
        }
    }
}
