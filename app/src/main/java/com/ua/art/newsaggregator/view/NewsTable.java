package com.ua.art.newsaggregator.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.ua.art.newsaggregator.controller.db.CountSelectCategory;
import com.ua.art.newsaggregator.model.News;
import com.ua.art.newsaggregator.service.Settings;

public class NewsTable {
    final String LOG_TAG = "NTLogs";

    private Context mContext;
    private LinearLayout buttons_layout;
    private static final int COLUMNS = 3;
    private int counter = 0;

    public NewsTable(Context mContext, LinearLayout linearLayout) {
        this.mContext = mContext;
        buttons_layout = linearLayout;
    }

    public void createTable() {
        buttons_layout.removeAllViewsInLayout();
        setParamsForLayout(buttons_layout);

        ScrollView scrollView = new ScrollView(mContext);
        buttons_layout.addView(scrollView);

        TableLayout tableLayout = new TableLayout(mContext);
        //tableLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT
        ));
        tableLayout.setWeightSum(4);

        double newsCount = (double) News.values().length;
        for (int i = 0; i < Math.ceil(newsCount / COLUMNS); i++) {
            tableLayout.addView(prepareRow());
        }
        scrollView.addView(tableLayout);
    }

    private void setParamsForLayout(LinearLayout linearLayout) {
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        ));
    }

    private View prepareRow() {
        TableRow row = new TableRow(mContext);
        row.setGravity(Gravity.CENTER_HORIZONTAL);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
        for (int j = 0; j < COLUMNS; j++, counter++) {
            if (counter < News.values().length) {
                //row.setPadding(0, 0, 10, 0);
                row.addView(prepareButton(News.values()[counter]));
            }
        }
        return row;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private View prepareButton(final News news) {
        final Button button = new Button(mContext);
        button.setText(mContext.getString(news.getRuResource()));
        button.setTypeface(button.getTypeface(), Typeface.BOLD);
        //button.setTextColor(mContext.getResources().getColor(R.color.secondary_text_default_material_light));
        //button.setTextColor(0xff0000);
        button.setShadowLayer(1, 0, 2, Color.rgb(255, 255, 255));
        // TODO установить свет вона текста

        int width = (mContext.getResources().getDisplayMetrics().widthPixels / COLUMNS)-20;
        button.setWidth(width);
        button.setHeight(width);

        button.setBackground(mContext.getResources().getDrawable(news.getImgResourceClicked()));
        //button.setPadding(10, 10, 10, 10);

        LinearLayout.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(2, 6, 2, 2);

        //layoutParams.span = 1;
        //layoutParams.setMargins(3, 3, 3, 3);
        layoutParams.width = TableRow.LayoutParams.WRAP_CONTENT;
        layoutParams.height = TableRow.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = 9;

        button.setLayoutParams(layoutParams);
        button.setTag(news.getRuResource());
        button.setBackground(mContext.getResources().getDrawable(getImgResourceOnClick(news)));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (news.isClicked()) {
                    news.setClicked(false);
                } else {
                    news.setClicked(true);
                }
                button.setBackground(mContext.getResources().getDrawable(getImgResourceOnClick(news)));
                CountSelectCategory countSelC = new CountSelectCategory();  // save Settings button select Category
                Log.d(LOG_TAG, "sumItemOneCategory" + String.valueOf(Settings.sumItemOneCategory));
            }
        });
        return button;
    }

    public int getImgResourceOnClick(News news) {
        return news.isClicked() ? news.getImgResourceUnclicked() : news.getImgResourceClicked();
    }
}
