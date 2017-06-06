package com.mrussek.databinding;

import android.content.Context;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Articles {
    private List<ArticleEntity> articleEntities;
    public Articles(Context context) {
        ArticleEntity articleEntity = new ArticleEntity("Android Development in Eclipse",
                new Date(),
                Arrays.asList("Old Joe", "Angry Steve"),
                Rating.ONE_STAR,
                589,
                false,
                context.getString(R.string.lorem_ipsum)
        );
        articleEntities = Arrays.asList(
                new ArticleEntity("Data Binding: The Good Parts",
                        new Date(),
                        Collections.singletonList("Max Russek"),
                        Rating.FIVE_STARS,
                        10_000,
                        true,
                        context.getString(R.string.lorem_ipsum)
                ),
                articleEntity,
                articleEntity,
                articleEntity,
                articleEntity,
                articleEntity,
                articleEntity,
                articleEntity,
                articleEntity,
                articleEntity,
                articleEntity,
                articleEntity
        );
    }

    public List<ArticleEntity> getArticleEntities() {
        return articleEntities;
    }
}
