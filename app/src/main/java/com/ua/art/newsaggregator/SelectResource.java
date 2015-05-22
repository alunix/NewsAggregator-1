package com.ua.art.newsaggregator;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
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

    //TODO надо только раз чтоб загружалось (при перевороте доавляются кнопки)
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_resource);

        tableLayout_SelectSours = (TableLayout)findViewById(R.id.TableLayout_SelectSours);
        tableRowsArr_SelectSours = new ArrayList<>();

        // add Base to News
        BaseSourse.addBaseNews();
        // To add TableRow in TableLayout
        float tempIdSize = (float) BaseSourse.idSelectSourceArr.size() / 3;
        if ((int) tempIdSize < tempIdSize)       // Quantity TableRow / количество TableRow
            tempIdSize = (int) tempIdSize + 1;
        else
            tempIdSize = (int) tempIdSize;

        for (int i = 0; i < tempIdSize; i++) {
            tableRowsArr_SelectSours.add(new TableRow(this));
        }

        int idSizeSourceArr = 0;
        for (int j = 0; j < tableRowsArr_SelectSours.size(); j++) {
            //tableLayout_SelectSours.addView(tableRowsArr_SelectSours.get(j));
            for (int i = 0; i < 4; i++, idSizeSourceArr++) {
                if (BaseSourse.idSelectSourceArr.size() > idSizeSourceArr) {
                    Button button = new Button(this);
                    button.setText(BaseSourse.nameSelectSourceArr.get(idSizeSourceArr)); //Set to any meaningful text
                    button.setBackgroundColor(Color.GREEN);

                    tableRowsArr_SelectSours.get(j).addView(button); //Attach TextView to its parent (row)

                    TableRow.LayoutParams params =
                            (TableRow.LayoutParams) button.getLayoutParams();
                    params.column = i;
                    params.span = 1;
                    params.setMargins(3, 3, 3, 3);
                    params.width = TableRow.LayoutParams.WRAP_CONTENT;
                    params.height = TableRow.LayoutParams.WRAP_CONTENT;
                    params.gravity = 9;
                    button.setPadding(1, 1, 1, 1);
                }
                //tableRowsArr_SelectSours.get(j).setBackgroundColor(Color.BLACK);
            }

            tableLayout_SelectSours.addView(tableRowsArr_SelectSours.get(j),
                    new TableLayout.LayoutParams
                            (TableRow.LayoutParams.WRAP_CONTENT,
                                    TableRow.LayoutParams.WRAP_CONTENT));
        }
    }
}
