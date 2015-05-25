package com.ua.art.newsaggregator;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class SelectResource extends ActionBarActivity implements View.OnClickListener {
    private ArrayList<Button> buttonViewsArr_SelectSours;

    //TODO you just have to download again (when the coup add button)
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_resource);

        TableLayout tableLayout_SelectSours = (TableLayout) findViewById(R.id.TableLayout_SelectSours);
        ArrayList<TableRow> tableRowsArr_SelectSours = new ArrayList<>();
        Button button_SelectSours = (Button) findViewById(R.id.btnNextSelectResource);
        button_SelectSours.setOnClickListener(this);
        int columns = 3;

        // add Base to News
        BaseSourse baseSourse = new BaseSourse();
        // To add TableRow in TableLayout
        addTableRow(baseSourse.selectSourceArr, tableRowsArr_SelectSours, columns);

        int idSizeSourceArr = 0;
        for (int j = 0; j < tableRowsArr_SelectSours.size(); j++) {
            //tableLayout_SelectSours.addView(tableRowsArr_SelectSours.get(j));
            for (int i = 0; i < columns; i++, idSizeSourceArr++) {
                if (baseSourse.selectSourceArr.size() > idSizeSourceArr) {
                    //TODO ERROR
                    buttonViewsArr_SelectSours.add(new Button(this));
                    int sizeBtnArr = buttonViewsArr_SelectSours.size();
                    Button buttonLast = buttonViewsArr_SelectSours.get(sizeBtnArr);


                    buttonLast.setText(baseSourse.selectSourceArr.get(1)[idSizeSourceArr]); //Set to any meaningful text
                    buttonLast.setBackgroundColor(Color.GREEN);

                    tableRowsArr_SelectSours.get(j).addView(buttonLast); //Attach TextView to its parent (row)

                    TableRow.LayoutParams params =
                            (TableRow.LayoutParams) buttonLast.getLayoutParams();
                    params.column = i;
                    params.span = 1;
                    params.setMargins(3, 3, 3, 3);
                    params.width = TableRow.LayoutParams.WRAP_CONTENT;
                    params.height = TableRow.LayoutParams.WRAP_CONTENT;
                    params.gravity = 9;
                    buttonLast.setPadding(1, 1, 1, 1);
                }
                //tableRowsArr_SelectSours.get(j).setBackgroundColor(Color.BLACK);
            }

            tableLayout_SelectSours.addView(tableRowsArr_SelectSours.get(j),
                    new TableLayout.LayoutParams
                            (TableRow.LayoutParams.WRAP_CONTENT,
                                    TableRow.LayoutParams.WRAP_CONTENT));
        }

        // Click BUTTON NEXT
//        View.OnClickListener inputBtn = new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(this, ListNewsView.class);
//                startActivity(intent);
//
//            }
//        };
//        button_SelectSours.setOnClickListener(inputBtn);
    }

    // To add TableRow in TableLayout
    private void addTableRow(ArrayList<String[]> baseSourse, ArrayList<TableRow> tableRowsArr_SelectSours, int columns) {
        int tempIdSize = (int) Math.floor(baseSourse.size() / columns);
        //TODO
        if (baseSourse.size() % columns != 0)       // Quantity TableRow / количество TableRow
            tempIdSize += 1;
        for (int i = 0; i < tempIdSize; i++) {
            tableRowsArr_SelectSours.add(new TableRow(this));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNextSelectResource) {
            Intent intent = new Intent(this, ListNewsView.class);
            startActivity(intent);
        }
    }
}
