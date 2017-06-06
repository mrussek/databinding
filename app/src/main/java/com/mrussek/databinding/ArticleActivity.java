package com.mrussek.databinding;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {
    public static final String ARTICLE_TAG = "ARTICLE_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_layout);

        ArticleEntity article = getArticleEntity(getIntent());

        bindArticle(article);
    }

    private void bindArticle(ArticleEntity article) {
        // If only there was an easier way...
        TextView articleTitle = (TextView) findViewById(R.id.article_title);
        TextView mainAuthor = (TextView) findViewById(R.id.main_author);
        TextView publishedDate = (TextView) findViewById(R.id.published_date);
        View endorsedMarker = findViewById(R.id.endorsed_marker);
        TextView numViews = (TextView) findViewById(R.id.num_views);
        TextView articleContent = (TextView) findViewById(R.id.article_content);
        TextView rating = (TextView) findViewById(R.id.rating);

        articleTitle.setText(article.getTitle());
        mainAuthor.setText(article.getAuthors().get(0));
        publishedDate.setText(article.getPublishedDate().toString());
        endorsedMarker.setVisibility(article.isEndorsed() ? View.VISIBLE : View.GONE);
        numViews.setText(getString(R.string.num_of_views, article.getNumViews()));
        articleContent.setText(article.getContent());
        rating.setText(article.getRating().toString());
    }


    @NonNull
    private ArticleEntity getArticleEntity(Intent intent) {
        return (ArticleEntity)intent.getSerializableExtra(ARTICLE_TAG);
    }
}
