package com.mrussek.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class ActivityViewModel extends BaseObservable {
    private String firstText;
    private String secondText;

    public ActivityViewModel(String firstText, String secondText) {
        this.firstText = firstText;
        this.secondText = secondText;
    }

    @Bindable
    public String getFirstText() {
        return firstText;
    }

    public void setFirstText(String firstText) {
        this.firstText = firstText;
        notifyPropertyChanged(BR.firstText);
    }

    @Bindable
    public String getSecondText() {
        return secondText;
    }

    public void setSecondText(String secondText) {
        this.secondText = secondText;
        notifyPropertyChanged(BR.secondText);
    }
}
