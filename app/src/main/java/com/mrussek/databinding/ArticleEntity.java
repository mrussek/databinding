package com.mrussek.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ArticleEntity extends BaseObservable implements Serializable {
    private String title;
    private Date publishedDate;
    private List<String> authors;
    private Rating rating;
    private int numViews;
    private boolean endorsed;
    private String content;

    public ArticleEntity(String title, Date publishedDate, List<String> authors, Rating rating, int numViews, boolean endorsed, String content) {
        this.title = title;
        this.publishedDate = publishedDate;
        this.authors = authors;
        this.rating = rating;
        this.numViews = numViews;
        this.endorsed = endorsed;
        this.content = content;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
        notifyPropertyChanged(BR.publishedDate);
    }

    @Bindable
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
        notifyPropertyChanged(BR.authors);
    }

    @Bindable
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
        notifyPropertyChanged(BR.rating);
    }

    @Bindable
    public int getNumViews() {
        return numViews;
    }

    public void setNumViews(int numViews) {
        this.numViews = numViews;
        notifyPropertyChanged(BR.numViews);
    }

    @Bindable
    public boolean isEndorsed() {
        return endorsed;
    }

    public void setEndorsed(boolean endorsed) {
        this.endorsed = endorsed;
        notifyPropertyChanged(BR.endorsed);
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }
}