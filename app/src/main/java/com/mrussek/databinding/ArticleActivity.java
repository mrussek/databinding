package com.mrussek.databinding;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ArticleActivity extends AppCompatActivity {
    public static final String ARTICLE_TAG = "ARTICLE_TAG";
    private final String ARTICLE_FRAGMENT_TAG = "Article Fragment";
    private ArticleFragment articleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding);

        ArticleEntity article = getArticleEntity(getIntent());

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
    private ArticleEntity getArticleEntity(Intent intent) {
        return (ArticleEntity)intent.getSerializableExtra(ARTICLE_TAG);
    }
}
