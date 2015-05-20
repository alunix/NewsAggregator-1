package com.ua.art.newsaggregator;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class SelectResource extends Activity {
    private TableLayout tableLayout_SelectSours;
    private ArrayList<TableRow> tableRowsArr_SelectSours;
    private ArrayList<Button> buttonViewsArr_SelectSours;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tableLayout_SelectSours = (TableLayout)findViewById(R.id.TableLayout_SelectSours);
        tableRowsArr_SelectSours = new ArrayList<>();

        // To add TableRow in TableLayout
        float tempIdSize = BaseSourse.getIdSelectSourceArr().size()/3;
        if ((int)tempIdSize < tempIdSize)       // Quantity TableRow / количество TableRow
            tempIdSize = (int)tempIdSize + 1;
        else
            tempIdSize = (int)tempIdSize;

        for (int i = 0; i < tempIdSize; i++) {
            tableRowsArr_SelectSours.add(new TableRow(this));
            tableLayout_SelectSours.addView(tableRowsArr_SelectSours.get(i));
        }


        for (int i = 0; i < BaseSourse.getIdSelectSourceArr().size(); i++){           // Array add Button
            buttonViewsArr_SelectSours.add(new Button(this));
            buttonViewsArr_SelectSours.get(i).setId(i);      /// ?????????????????????????????????????????????????????????????????????????
            buttonViewsArr_SelectSours.get(i).setText(BaseSourse.getNameSelectSourceArr().get(i));
            buttonViewsArr_SelectSours.get(i).setBackground(Drawable.createFromPath("@mipmap/".concat(BaseSourse.getImgSelectSourceArr().get(i))));
        }

        int idSizeSourceArr = 0;
        for (TableRow elem : tableRowsArr_SelectSours){                             // add imageView
            for (int i = 0; i < 3; i++, idSizeSourceArr++) {
                if (BaseSourse.getIdSelectSourceArr().size() > idSizeSourceArr){
                    elem.addView(buttonViewsArr_SelectSours.get(idSizeSourceArr));
                }
            }
        }
    }
}
