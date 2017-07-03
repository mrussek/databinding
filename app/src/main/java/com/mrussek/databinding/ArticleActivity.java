package com.mrussek.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mrussek.databinding.databinding.ArticleLayoutBinding;

public class ArticleActivity extends AppCompatActivity {
    public static final String ARTICLE_TAG = "ARTICLE_TAG";

    private ArticleLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.article_layout);

        ArticleEntity article = getArticleEntity(getIntent());

        Handler handler = new Handler(Looper.myLooper());

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                article.setNumViews(article.getNumViews() + 1);

                handler.postDelayed(this, 1000);
            }
        }, 1000);

        binding.setArticle(article);
        binding.setHandlers(new Handlers());
    }

    @NonNull
    private ArticleEntity getArticleEntity(Intent intent) {
        return (ArticleEntity)intent.getSerializableExtra(ARTICLE_TAG);
    }

    public class Handlers {
        public void clicked(View v) {
            Toast.makeText(ArticleActivity.this, "TOAST", Toast.LENGTH_LONG).show();
        }
    }
}
