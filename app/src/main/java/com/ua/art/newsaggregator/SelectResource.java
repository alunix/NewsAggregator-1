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

        // add Base to News
        BaseSourse baseSourse = new BaseSourse();

        //TODO newTab
        newTableRow(tableRowsArr_SelectSours);      // new TableRow, to add TableRow in TableLayout

        addTableRowToTableLayout(tableLayout_SelectSours, tableRowsArr_SelectSours);
    }

    private ArrayList newTableRow(ArrayList tableRowsArr_SelectSours) {
        // To add TableRow in TableLayout
        //TODO err??????????????????????????????????????????????????????????????????
        int tempIdSize = Integer.parseInt(String.format("the number is :%.0f", 10 / 3));    // int row in table
        if (BaseSourse.selectSourceArr.size() % 3 != 0)         // Quantity TableRow / количество TableRow
            tempIdSize++;
        for (int i = 0; i < tempIdSize; i++) {                  // new TableRow
            tableRowsArr_SelectSours.add(new TableRow(this));
        }
        return tableRowsArr_SelectSours;
    }

    private void addTableRowToTableLayout(TableLayout tableLayout_SelectSours, ArrayList<TableRow> tableRowsArr_SelectSours) {
        int idSizeSourceArr = 0;
        for (int j = 0; j < tableRowsArr_SelectSours.size(); j++) {
            //tableLayout_SelectSours.addView(tableRowsArr_SelectSours.get(j));
            for (int i = 0; i < 4; i++, idSizeSourceArr++) {
                if (BaseSourse.selectSourceArr.size() > idSizeSourceArr) {
                    Button button = new Button(this);
                    button.setText(BaseSourse.selectSourceArr.get(1)[idSizeSourceArr]); //Set to any meaningful text
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
            }
            tableLayout_SelectSours.addView(tableRowsArr_SelectSours.get(j),
                    new TableLayout.LayoutParams
                            (TableRow.LayoutParams.WRAP_CONTENT,
                                    TableRow.LayoutParams.WRAP_CONTENT));
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
