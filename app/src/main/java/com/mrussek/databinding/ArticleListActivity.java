package com.mrussek.databinding;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class ArticleListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        Articles articles = new Articles(this);
        ArticleListAdapter adapter = new ArticleListAdapter(articles.getArticleEntities(), articleEntity -> {
            Intent intent = new Intent(this, ArticleActivity.class);
            intent.putExtra(ArticleActivity.ARTICLE_TAG, articleEntity);
            startActivity(intent);
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.article_list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(v -> {
            Toast.makeText(this, "Not Implemented", Toast.LENGTH_SHORT).show();
        });
    }
}
