package com.ua.art.newsaggregator.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ua.art.newsaggregator.R;
import com.ua.art.newsaggregator.view.NewsTable;

public class ChooseCategoryFragment extends Fragment {
    //private Context catContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choose_category,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout tableLayout = (LinearLayout) view.findViewById(R.id.linearSelMod);
        NewsTable newsTable = new NewsTable(getActivity(), tableLayout);
        newsTable.createTable();


    }
}
