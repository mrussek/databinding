package com.mrussek.databinding;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ArticleEntity implements Serializable {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getNumViews() {
        return numViews;
    }

    public void setNumViews(int numViews) {
        this.numViews = numViews;
    }

    public boolean isEndorsed() {
        return endorsed;
    }

    public void setEndorsed(boolean endorsed) {
        this.endorsed = endorsed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}