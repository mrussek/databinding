package com.mrussek.databinding;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;


public class ArticleListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ArticleEntity> articleEntities;
    private OnArticleSelectedListener articleSelectedListener;

    public ArticleListAdapter(List<ArticleEntity> articleEntities, OnArticleSelectedListener articleSelectedListener) {
        this.articleEntities = articleEntities;
        this.articleSelectedListener = articleSelectedListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.article_list_item_layout, viewGroup, false);
        return new ArticleItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ArticleItemViewHolder) {
            ArticleEntity article = articleEntities.get(i);
            bindArticleListItem(viewHolder, article);
        }
    }

    private void bindArticleListItem(RecyclerView.ViewHolder viewHolder, ArticleEntity article) {
        View root = viewHolder.itemView;
        Context context = root.getContext();

        TextView articleTitle = (TextView) root.findViewById(R.id.list_article_title);
        TextView mainAuthor = (TextView) root.findViewById(R.id.list_main_author);
        TextView numViews = (TextView) root.findViewById(R.id.list_num_views);
        TextView publishedDate = (TextView) root.findViewById(R.id.list_published_date);

        articleTitle.setText(article.getTitle());
        mainAuthor.setText(article.getAuthors().get(0));
        numViews.setText(context.getString(R.string.num_of_views, article.getNumViews()));
        publishedDate.setText(DateFormat.getInstance().format(article.getPublishedDate()));

        root.setOnClickListener(v -> articleSelectedListener.onArticleSelected(article));
    }

    @Override
    public int getItemCount() {
        return articleEntities.size();
    }

    public static class ArticleItemViewHolder extends RecyclerView.ViewHolder {
        public ArticleItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface OnArticleSelectedListener {
        void onArticleSelected(ArticleEntity articleEntity);
    }
}
