package ru.geekbrains.notes;

import androidx.annotation.DrawableRes;

public class CardData {
    public final String text;
    public final @DrawableRes int resourceId;


    public CardData(String text, @DrawableRes int resourceId) {
        this.text = text;
        this.resourceId = resourceId;
    }
}
