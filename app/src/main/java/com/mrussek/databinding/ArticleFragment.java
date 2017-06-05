package com.mrussek.databinding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {
    private static final String ARTICLE = "ARTICLE";

    private ArticleEntity article;

    public ArticleFragment() {
        // Required empty public constructor
    }

    public static ArticleFragment newInstance(ArticleEntity article) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARTICLE, article);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            article = (ArticleEntity) getArguments().getSerializable(ARTICLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_article, container, false);

        bindArticle(root, article);
        return root;
    }

    private void bindArticle(View root, ArticleEntity article) {
        // If only there was an easier way...
        TextView articleTitle = (TextView) root.findViewById(R.id.article_title);
        TextView mainAuthor = (TextView) root.findViewById(R.id.main_author);
        TextView publishedDate = (TextView) root.findViewById(R.id.published_date);
        View endorsedMarker = root.findViewById(R.id.endorsed_marker);
        TextView numViews = (TextView) root.findViewById(R.id.num_views);
        TextView articleContent = (TextView) root.findViewById(R.id.article_content);
        TextView rating = (TextView) root.findViewById(R.id.rating);

        articleTitle.setText(article.getTitle());
        mainAuthor.setText(article.getAuthors().get(0));
        publishedDate.setText(article.getPublishedDate().toString());
        endorsedMarker.setVisibility(article.isEndorsed() ? View.VISIBLE : View.GONE);
        numViews.setText(getString(R.string.num_of_views, article.getNumViews()));
        articleContent.setText(article.getContent());
        rating.setText(article.getRating().toString());
    }
}
