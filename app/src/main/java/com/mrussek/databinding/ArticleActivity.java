package com.mrussek.databinding;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Date;

public class ArticleActivity extends AppCompatActivity {
    private final String ARTICLE_FRAGMENT_TAG = "Article Fragment";
    private ArticleFragment articleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding);

        ArticleEntity article = getArticleEntity();

        setUpArticleFragment(article);
    }

    private void setUpArticleFragment(ArticleEntity article) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        articleFragment = (ArticleFragment)supportFragmentManager.findFragmentByTag(ARTICLE_FRAGMENT_TAG);

        if (articleFragment == null) {
            articleFragment = ArticleFragment.newInstance(article);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragment_container, articleFragment, ARTICLE_FRAGMENT_TAG);
            transaction.commit();
        }
    }

    @NonNull
    private ArticleEntity getArticleEntity() {
        return new ArticleEntity(
                "Data Binding: The Good Parts",
                new Date(),
                Arrays.asList("Maxwell Russek", "Joe Smith"),
                Rating.FIVE_STARS, 10_000, true, getString(R.string.lorem_ipsum));
    }
}
