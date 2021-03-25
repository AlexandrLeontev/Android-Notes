package ru.geekbrains.notes;

import android.content.res.Resources;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardDataSourceImp implements CardDataSource{

    private final LinkedList<CardData> mData = new LinkedList<>();

    public CardDataSourceImp(Resources resources){

    }

    @Override
    public List<CardData> getCardData() {
        return Collections.unmodifiableList(mData); // Для того, чтобы нельзя было изменять данные напрямую в CardDataSource
        // обернуть список в немодифицированный
    }

    @Override
    public CardData getItemAt(int idx) {
        return mData.get(idx);
    }

    @Override
    public int getItemsCount() {
        return mData.size();
    }
}
